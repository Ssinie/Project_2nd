package bean.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private MainDAOImpl mainDAO = null;
	
	@RequestMapping("main.ns")
	public String main(HttpSession session) {
		//System.out.println("main_sessionId = "+session.getAttribute("sessionId"));
		
		return "/main/mainTest";
	}
	
	@RequestMapping("product.ns")
	public String product(ProductDTO dto, HttpSession session, Model model) throws Exception{
		
		int num = 723;
		model.addAttribute("num", num);
		
		String id = (String)session.getAttribute("sessionId");
		System.out.println("product_sessionId = "+id);
		model.addAttribute("id", id);
		
		dto.setId(id);
		dto.setNum(num);
		
		if(id != null) {
			String wishCheck = String.valueOf(mainDAO.wishCheck(dto));
				
			System.out.println("상품 페이지 wishCheck = "+wishCheck);
				
			if(wishCheck == "null") {
				model.addAttribute("wishCheck", "0");
			}
			if(wishCheck == "1"){
				model.addAttribute("wishCheck", "1");
			}
		}
		
		return "/product/product";
	}
	
	@RequestMapping("wishlistPro.ns")
	public @ResponseBody String wishlistPro(ProductDTO dto, String id, int num, String wishCheck) throws Exception{
		String result = null;
		
		dto.setId(id);
		dto.setNum(num);
		
		wishCheck = String.valueOf(mainDAO.wishCheck(dto));
		
		System.out.println("클릭했을 때 wishCheck = "+wishCheck);
		
		if(wishCheck.equals("0") || wishCheck.equals("null")) {
			System.out.println("insert");
			mainDAO.wishInsert(dto);
			result = "1";
		}
		if(wishCheck.equals("1")) {
			System.out.println("delete");
			mainDAO.wishDelete(dto);
			result = "0";
		}
		
		return result;
	}
	
	@RequestMapping("productlist.ns")
	public String productList(HttpSession session, Model model) throws Exception {
		
		List imgList = mainDAO.getPdImg();
		String img = "";
		
		System.out.println("imgList = "+imgList);
		
		model.addAttribute("imgList", imgList);

		
//		String id = (String)session.getAttribute("sessionId");
//		
//		if(id != null) {
//			
//			// 적합순으로 DB에서 꺼내기
//			
//		}else {
//			// 조회순으로 DB에서 꺼내기
//		}
		
		return "/product/productList";
	}

	
}
