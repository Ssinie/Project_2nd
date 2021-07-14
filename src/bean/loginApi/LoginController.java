package bean.loginApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import bean.member.MemberDAOImpl;
import bean.member.MemberDTO;
 
@Controller
public class LoginController {
	
	@Autowired
	private MemberDAOImpl memberDAO = null;
	
	@Autowired
	private SqlSessionTemplate dao = null; 
 
    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
    
    @Autowired
    private KakaoService kakaoService;
 
    //로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/login.ns", method = { RequestMethod.GET, RequestMethod.POST })
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
 
    //네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "/callback.ns", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(MemberDTO dto, Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws Exception, ParseException {
        //////System.out.println("여기는 callback");
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
        JSONObject jsonObj = (JSONObject) obj;
        //3. 데이터 파싱
        //Top레벨 단계 _response 파싱
        JSONObject response_obj = (JSONObject)jsonObj.get("response");
        
        System.out.println(response_obj);
        
        //response 값 파싱
        String id = (String)response_obj.get("id");
        String nickname = (String)response_obj.get("nickname");
        String profile_image = (String)response_obj.get("profile_image");
        String email = (String)response_obj.get("email");
        String gender = (String)response_obj.get("gender");
        String age = (String)response_obj.get("age");
        String birthday = (String)response_obj.get("birthday");
        
        //dto에 넣기
        dto.setId(id);
        dto.setNickname(nickname);
        dto.setProfile_image(profile_image);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setAge(age);
        dto.setBirthday(birthday);
        
        memberDAO.insert(dto);
        
        //4.파싱 닉네임 세션으로 저장
        session.setAttribute("sessionId",nickname); //세션 생성
        model.addAttribute("result", apiResult);
 
        /* 네이버 로그인 성공 페이지 View 호출 */
        return "/loginApi/callback";
    }
    
    @RequestMapping("/kakao.ns")
    public String kakao(Model model, @RequestParam(value = "code", required = false) String code) throws Exception{
        
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        
        model.addAttribute("id", userInfo.get("id"));
        model.addAttribute("nickname", userInfo.get("nickname"));
        model.addAttribute("email", userInfo.get("email"));
        model.addAttribute("profile_image", userInfo.get("profile_image"));
        model.addAttribute("gender", userInfo.get("gender"));
        model.addAttribute("age_range", userInfo.get("age_range"));
        model.addAttribute("birthday", userInfo.get("birthday"));
        
        return "/loginApi/kakao";
    }
    
}
