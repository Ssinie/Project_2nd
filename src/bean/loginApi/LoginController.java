package bean.loginApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.github.scribejava.core.model.OAuth2AccessToken;

import bean.main.MemberDAOImpl;
import bean.main.MemberDTO;
 
@Controller
public class LoginController {
	
	@Autowired
	private MemberDAOImpl memberDAO = null;
 
    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
    
    @Autowired
    private KakaoService kakaoService;
 
    // 로그인 첫 화면 요청 메소드
    @RequestMapping(value = "login.ns", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) throws Exception{
        
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        //System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);
 
        /* 생성한 인증 URL을 View로 전달 */
        return "/loginApi/login";
    }
 
    // 네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "callback.ns", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(MemberDTO dto, Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws Exception, ParseException {
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        
        //1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
        /** apiResult json 구조
        {"resultcode":"00",
        "message":"success",
        "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
        **/
        
        //2. String형식인 apiResult를 json형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject)obj;
        JSONObject response_obj = (JSONObject)jsonObj.get("response");
        
        System.out.println(response_obj);

        String id = (String)response_obj.get("id");
        String name = (String)response_obj.get("name");
        String email = (String)response_obj.get("email");
        String gender = (String)response_obj.get("gender");
        String age = (String)response_obj.get("age");
        String birthday = (String)response_obj.get("birthday");
        
        String profile_image = "";
        String nickname = "";
        
        if(response_obj.get("profile_image") != null) {
        	profile_image = (String)response_obj.get("profile_image");
        }
        if(response_obj.get("nickname") != null) {
        	nickname = (String)response_obj.get("nickname");
        }
        
        dto.setId(id);
        dto.setName(name);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setAge(age);
        dto.setBirthday(birthday);
        
        dto.setNickname(nickname);
        dto.setProfile_image(profile_image);
        
        int checkId = memberDAO.checkId(dto);
        System.out.println("checkId naver = "+checkId);
        
        if(checkId == 1) {
        	session.setAttribute("sessionId", dto.getId());
        	memberDAO.loginLog(dto);
        }else {
        	dto.setJoin_from(1);
        	dto.setStatus(1);
        	
        	memberDAO.join(dto);
        	session.setAttribute("sessionId", dto.getId());
        }
        
        return "/loginApi/callback";
    }
    
    @RequestMapping("kakao.ns")
    public String kakao(MemberDTO dto, Model model, @RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{
        
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        
        String id = (String)userInfo.get("id");
        String nickname = (String)userInfo.get("nickname");
        String profile_image = (String)userInfo.get("profile_image");
        String email = (String)userInfo.get("email");
        String gender = (String)userInfo.get("gender");
        String age = (String)userInfo.get("age_range");
        String birthday = (String)userInfo.get("birthday");
        
        dto.setId(id);
        dto.setNickname(nickname);
        dto.setProfile_image(profile_image);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setAge(age);
        dto.setBirthday(birthday);
        
        int checkId = memberDAO.checkId(dto);
        System.out.println("checkId (기존 회원인가) = "+checkId);
        
        if(checkId == 1) {
        	session.setAttribute("sessionId", dto.getId());
        	memberDAO.loginLog(dto);
        	
        }else {
        	dto.setName("");
        	dto.setJoin_from(2);
        	dto.setStatus(1);
        	
        	memberDAO.join(dto);
        	session.setAttribute("sessionId", dto.getId());
        }
        
        return "/loginApi/kakao";
    }

    @RequestMapping("logout.ns")
    public String logout(HttpSession session) throws Exception{
    	
    	session.invalidate();
    	
    	return "/loginApi/logout";
    }
    
}
