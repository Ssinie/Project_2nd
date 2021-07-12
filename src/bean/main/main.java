package bean.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/health/")
public class main {
	
	@RequestMapping("main.go")
	public String front() {
		return "/main/main";
	}
	
	@RequestMapping("main.ns")
	public String main() {
		
		return "/main/main";
	}
}


