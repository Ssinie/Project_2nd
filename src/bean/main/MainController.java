package bean.main;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private MainDAOImpl mainDAO = null;
	
	@RequestMapping("index.ns")
	public String index(Model model) throws Exception {
		
		return "/main/index";
	}
	
	@RequestMapping("main.ns")
	public String main(Model model, HttpSession session, HttpServletRequest request) throws Exception {
		String preUrl = request.getRequestURL().toString();
		session.setAttribute("preUrl", preUrl);
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		List mainList = mainDAO.getMainPd();
		model.addAttribute("mainList", mainList);
		
		return "/main/main";
	}
	
//	@RequestMapping("product.ns")
//	public String product(@RequestParam("num") int num, ProductDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception{
//		String preUrl = request.getRequestURL().toString();
//		session.setAttribute("preUrl", preUrl);
//		
//		model.addAttribute("num", num);
//		
//		String id = (String)session.getAttribute("sessionId");
//		model.addAttribute("id", id);
//		
//		List pdList = mainDAO.getPd(num);
//		model.addAttribute("pdList", pdList);
//		
//		dto.setId(id);
//		dto.setNum(num);
//		
//		if(id != null) {
//			String wishCheck = String.valueOf(mainDAO.wishCheck(dto));
//				
//			System.out.println("상품 페이지 wishCheck = "+wishCheck);
//				
//			if(wishCheck == "null") { // 관심상품 클릭 안 했으면
//				model.addAttribute("wishCheck", "0");
//			}
//			if(wishCheck == "1"){
//				model.addAttribute("wishCheck", "1");
//			}
//		}
//		
//		return "/product/product";
//	}
	
	@RequestMapping("wishlistPro.ns")
	public @ResponseBody String wishlistPro(@RequestParam("num") int num, ProductDTO dto, HttpSession session) throws Exception{
		String result = null;
		String id = (String)session.getAttribute("sessionId");
		
		System.out.println(id);
		System.out.println(num);
		
		dto.setId(id);
		dto.setNum(num);
			
		String wishCheck = String.valueOf(mainDAO.wishCheck(dto));
		
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
	
	/* 
	 * [상품목록]
	 * 
	 *  
	 */
	@RequestMapping("productlist.ns")
	public String productList(@RequestParam(value="category", required=false, defaultValue="null") String category, @RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		
		if(request.getQueryString() == null) {
			String preUrl = request.getRequestURL().toString();
			session.setAttribute("preUrl", preUrl);
		}
		
		if(request.getQueryString() != null) {
			String preUrl = request.getRequestURL()+"?"+request.getQueryString().toString();
			session.setAttribute("preUrl", preUrl);
		}
		
		String sessionId = (String)session.getAttribute("sessionId");
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("pageNum", pageNum);
		
		int pageSize = 9;
			if(pageNum.equals("null")) {
				pageNum = "1";
			}
			
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
			
		if(category.equals("null")) {
			
			int catePdCount = mainDAO.allPdCount();
			model.addAttribute("catePdCount", catePdCount);
			
			if(catePdCount > 0) {
				List productList = mainDAO.getAllPd(dto);
				model.addAttribute("productList", productList);
			}
			
			List productBest = mainDAO.getAllBest();
			model.addAttribute("productBest", productBest);
			
		}else {
			
			model.addAttribute("category", category);
			dto.setCategory(category);
			
			int catePdCount = mainDAO.catePdCount(category);
			model.addAttribute("catePdCount", catePdCount);
			
			if(catePdCount > 0) {
				List productList = mainDAO.getCatePd(dto);
				model.addAttribute("productList", productList);
				
				List productBest = mainDAO.getCateBest(category);
				model.addAttribute("productBest", productBest);
			}
		}
			
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
				
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		
		return "/product/productList";
	}
	
	@RequestMapping("search.ns")
	public String search(@RequestParam("keyword") String keyword, @RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		String preUrl = request.getRequestURL()+"?"+request.getQueryString().toString();
		session.setAttribute("preUrl", preUrl);
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageNum", pageNum);
		
		int pageSize = 9;
		if(pageNum.equals("null")) {
			pageNum = "1";
		}
		int searchPdCount = mainDAO.searchPdCount(keyword);
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		dto.setKeyword(keyword);
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		if(searchPdCount > 0) {
			List searchList = mainDAO.getSearchPd(dto);
			model.addAttribute("searchList", searchList);
		}
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("searchPdCount", searchPdCount);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		
		return "/product/search";
	}
	
	@RequestMapping("loading.ns")
	public String loading(@RequestParam("num") int num, Model model) throws Exception {
		
		String url = mainDAO.getUrl(num);
		
		model.addAttribute("url", url);
		
		return "/product/loading";
	}
	
	@RequestMapping("mypage.ns")
	public String myPage(@RequestParam(value="category", required=false, defaultValue="null") String category, @RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		String preUrl = request.getRequestURL().toString();
		session.setAttribute("preUrl", preUrl);
		
		String id = (String)session.getAttribute("sessionId");
		dto.setId(id);
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		if(id != null) {
			
			int pageSize = 6;
			if(pageNum.equals("null")) {
				pageNum = "1";
			}
			
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = currentPage * pageSize;
			
			dto.setStartRow(startRow);
			dto.setEndRow(endRow);
			
			int mypagePdCount = mainDAO.mypagePdCount(id);
			
			if(mypagePdCount > 0) {
				List mypageList = mainDAO.getMypagePd(dto);
				model.addAttribute("mypageList", mypageList);
				
				model.addAttribute("mypagePdCount", mypagePdCount);
				model.addAttribute("pageSize", pageSize);
				model.addAttribute("currentPage", currentPage);
			}
		}
		
		return "/product/myPage";
	}
}


