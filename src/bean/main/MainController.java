package bean.main;

import java.sql.ResultSet;
import java.util.ArrayList;
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
	public String main(HttpSession session, Model model) throws Exception {
		System.out.println("main_sessionId = "+session.getAttribute("sessionId"));
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		List mainList = mainDAO.getMainPd();
		model.addAttribute("mainList", mainList);
		
		return "/main/index";
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
				
			if(wishCheck == "null") { // 관심상품 클릭 안 했으면
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
	
	/* 카테고리별 상품목록 */
	@RequestMapping("productlist.ns")
	public String productList(@RequestParam("category") String category, Model model) throws Exception {
		
		model.addAttribute("category", category);
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		List productList = mainDAO.getCatePd(category);
		model.addAttribute("productList", productList);
		
		return "/product/productList";
	}
	
	@RequestMapping("search.ns")
	public String search(Model model) throws Exception {
		
		return "/product/search";
	}

	
}


