package bean.loginApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginApiBean {
	
	
	@RequestMapping("login.ns")
	public String login() {
		
		return "/loginApi/login";
	}
	
	@RequestMapping("callback.ns")
	public String callback() {
		
		return "/loginApi/callback";
	}
}
