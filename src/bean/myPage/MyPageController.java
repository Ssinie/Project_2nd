package bean.myPage;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyPageController {
	@RequestMapping("mypage.ns")
	public String mypage() {
		return "/myPage/myPage";
	}
	
	@RequestMapping("wishlist.ns")
	public String wishlist() {
		return "/myPage/wishlist";
	}
}
