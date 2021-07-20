package bean.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("main.ns")
	public String main() {
		
		return "/main/main";
	}
	
	@RequestMapping("mypage.ns")
	public String mypage() {
		return "/myPage/myPage";
	}

	// 회원탈퇴 페이지
//	@RequestMapping("signout.ns")
//	public String signout(MemberDTO dto, @RequestParam String pw) {
//		
//		String id = dto.getId();
//		
//		return "/main/myPage/deleteForm";
//	}
}
