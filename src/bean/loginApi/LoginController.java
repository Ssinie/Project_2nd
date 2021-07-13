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
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.social.google.connect.GoogleConnectionFactory;
//import org.springframework.social.oauth2.GrantType;
//import org.springframework.social.oauth2.OAuth2Operations;
//import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
 
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
        //////System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);
 
        /* 생성한 인증 URL을 View로 전달 */
        return "/loginApi/login";
    }
 
    //네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "/callback.ns", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException, ParseException {
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
        
        //response의 nickname값 파싱
        String nickname = (String)response_obj.get("nickname");
        
        //추가
        String id = (String)response_obj.get("id");
        //String nickname = (String)response_obj.get("nickname");
        String age = (String)response_obj.get("age");
        String gender = (String)response_obj.get("gender");
        String email = (String)response_obj.get("email");
        String name = (String)response_obj.get("name");
        String birthday = (String)response_obj.get("birthday");
        String birthyear = (String)response_obj.get("birthyear");
        String profile_image = (String)response_obj.get("profile_image");
        String mobile = (String)response_obj.get("mobile");
               
        System.out.println(id);
        System.out.println(nickname);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(email);
        System.out.println(name);
        System.out.println(birthday);
        System.out.println(birthyear);
        System.out.println(profile_image);        
        System.out.println(mobile); 
        
        //4.파싱 닉네임 세션으로 저장
        session.setAttribute("sessionId",nickname); //세션 생성
        model.addAttribute("result", apiResult);
 
        /* 네이버 로그인 성공 페이지 View 호출 */
        return "/loginApi/callback";
    }
    
    @RequestMapping("/kakao.ns")
    public String kakao(Model model, @RequestParam(value = "code", required = false) String code) throws Exception{
    	
        //System.out.println("#########" + code);
        
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        
        //////System.out.println("###access_Token#### : " + access_Token);
//        System.out.println("*** nickname : " + userInfo.get("nickname"));
//        System.out.println("*** email : " + userInfo.get("email"));
//        System.out.println("*** profile_image : " + userInfo.get("profile_image"));
//        System.out.println("*** gender : " + userInfo.get("gender"));
//        System.out.println("*** age_range : " + userInfo.get("age_range"));
//        System.out.println("*** birthday : " + userInfo.get("birthday"));
        
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

