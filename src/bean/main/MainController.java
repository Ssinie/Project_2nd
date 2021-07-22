package bean.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private MainDAOImpl mainDAO = null;
	
	@RequestMapping("main.ns")
	public String main() {
		return "/main/main";
	}
	
	@RequestMapping("product.ns")
	public String product(WishlistDTO dto, HttpSession session) throws Exception{
		
		int num = 721;
		
		String id = (String)session.getAttribute("sessionId");
		
		
		if(id == null) {
			System.out.println("로그인이 필요합니다.");
		}else {
			
			
			
		}
		
		
//		dto.setId(id);
//		dto.setNum(num);
//		
//		mainDAO.wishInsert(dto);
		
		
		
		return "/product/product";
	}
	
	@RequestMapping("wishlistPro.ns")
	public String wishlistPro() {
		return "/product/wishlistPro";
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
