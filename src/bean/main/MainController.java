package bean.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
	/*
	 * - 로그인 시 직전 페이지로 이동하기 위해 헤더가 포함된 모든 페이지에서 해당 페이지 주소 getRequestURL을 세션에 preUrl로 저장
	 * - get방식으로 넘겨받는 값 있으면 getRequestURL에 getQueryString 추가로 붙여서 저장
	 */
@Controller
public class MainController {
	
	@Autowired
	private MainDAOImpl mainDAO = null;
	
	@RequestMapping("index.ns")
	public String index(Model model) throws Exception {
		
		return "/main/index";
	}
	
	/*
	 * 메인 페이지
	 * - 로그인 시 직전 페이지로 이동하기 위해 헤더가 포함된 모든 페이지에서 해당 페이지 주소를 세션에 preUrl로 저장
	 * - preUrl 저장할 때 get방식으로 넘겨받는 값 있으면 getRequestURL에 getQueryString 추가로 붙여줌
	 */
	@RequestMapping("main.ns")
	public String main(Model model, HttpSession session, HttpServletRequest request) throws Exception {
		String preUrl = request.getRequestURL().toString();
		session.setAttribute("preUrl", preUrl);
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		List mainList = mainDAO.getMainPd();
		model.addAttribute("mainList", mainList);
		
		// 건강뉴스
		
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
	
	/*
	 * 관심상품 등록/삭제 처리 페이지
	 * - @ResponseBody = 주소가 아니라 해당 결과 값이 ajax로 넘어감
	 * - null 체크 위해 int 아닌 Integer로 num 받음
	 */
	@RequestMapping("wishlistPro.ns")
	public @ResponseBody String wishlistPro(
			@RequestParam(value="num", required=false) Integer num,
			@RequestParam(value="str", required=false, defaultValue="null") String str,
			ProductDTO dto, HttpSession session, HttpServletRequest request) throws Exception{
		String result = null;
		String id = (String)session.getAttribute("sessionId");
		
		if(num != null) {
			dto.setId(id);
			dto.setNum(num);
			String wishCheck = String.valueOf(mainDAO.wishCheck(dto));
			
			if(wishCheck.equals("0") || wishCheck.equals("null")) {
				mainDAO.wishInsert(dto);
				result = "1";
			}
			if(wishCheck.equals("1")) {
				mainDAO.wishDelete(dto);
				result = "0";
			}
		}
		if(num == null) {
			if(!str.equals("null")) {
				String [] deleteNum = str.split("&");
				dto.setId(id);
				for(String c : deleteNum) {
					dto.setNum(Integer.parseInt(c));
					mainDAO.wishDelete(dto);
				}
				result = "100";
			}else {
				mainDAO.wishAllDelete(id);
				result = "10";	
			}

		}
		
		return result;
	}
	
	/* 
	 * 상품목록 페이지
	 * - 전체 영양제 또는 카테고리별 영양제 페이지
	 * - 카테고리 클릭할 때 category 받아서 처리
	 */
	@RequestMapping("productlist.ns")
	public String productList(
			@RequestParam(value="category", required=false, defaultValue="null") String category, 
			@RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, 
			ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		
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
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		
		if(category.equals("null") || category.equals(""))  {
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
	
	/* 
	 * 검색 페이지 (헤더 검색창 결과 페이지)
	 * - keyword 받아서 처리
	 */
	@RequestMapping("search.ns")
	public String search(
			@RequestParam("keyword") String keyword, 
			@RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, 
			ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
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
	
	/*
	 * 로딩 페이지
	 * - 새 창으로 구매 페이지 이동 시 안내 페이지
	 * - 클릭 시 해당 상품번호 num 받아서 처리
	 */
	@RequestMapping("loading.ns")
	public String loading(@RequestParam("num") int num, Model model) throws Exception {
		
		String url = mainDAO.getUrl(num);
		
		model.addAttribute("url", url);
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		return "/product/loading";
	}
	
//	/*
//	 * 기존 마이페이지
//	 * - 검색 mykeyword 또는 태그 category 받아서 처리
//	 */
//	@RequestMapping("mypage2.ns")
//	public String myPage(
//			@RequestParam(value="mykeyword", required=false, defaultValue="null") String mykeyword, 
//			@RequestParam(value="category", required=false, defaultValue="null") String category, 
//			@RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum, 
//			ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
//		
//		String preUrl = request.getRequestURL().toString();
//		session.setAttribute("preUrl", preUrl);
//		
//		String id = (String)session.getAttribute("sessionId");
//		dto.setId(id);
//		
//		List categoryList = mainDAO.getCategory();
//		model.addAttribute("categoryList", categoryList);
//		
//		if(id != null) {
//			
//			int pageSize = 6;
//			if(pageNum.equals("null")) {
//				pageNum = "1";
//			}
//			
//			int currentPage = Integer.parseInt(pageNum);
//			int startRow = (currentPage - 1) * pageSize + 1;
//			int endRow = currentPage * pageSize;
//			
//			dto.setStartRow(startRow);
//			dto.setEndRow(endRow);
//			
//			if(mykeyword.equals("null") && category.equals("null")) {
//				int mypagePdCount = mainDAO.wishPdCount(id);
//				model.addAttribute("mypagePdCount", mypagePdCount);
//				
//				if(mypagePdCount > 0) {
//					List mypageList = mainDAO.getWishPd(dto);
//					model.addAttribute("mypageList", mypageList);
//				}
//			}
//			if(!mykeyword.equals("null")) {
//				dto.setKeyword(mykeyword);
//				
//				int mypagePdCount = mainDAO.wishSearchCount(dto);
//				model.addAttribute("mypagePdCount", mypagePdCount);
//				
//				if(mypagePdCount > 0) {
//					List mypageList = mainDAO.getWishSearch(dto);
//					model.addAttribute("mypageList", mypageList);
//				}
//			}
//			if(!category.equals("null")) {
//				dto.setCategory(category);
//				
//				int mypagePdCount = mainDAO.wishTagPdCount(dto);
//				model.addAttribute("mypagePdCount", mypagePdCount);
//				
//				if(mypagePdCount > 0) {
//					List mypageList = mainDAO.getWishTagPd(dto);
//					model.addAttribute("mypageList", mypageList);
//				}
//			}
//			
//			model.addAttribute("pageSize", pageSize);
//			model.addAttribute("currentPage", currentPage);
//		}
//		
//		return "/product/myPage";
//	}
	
	/*
	 * 신규 마이페이지
	 * - 검색 mykeyword 또는 태그 category 받아서 처리
	 */
	@RequestMapping("mypage.ns")
	public String mypage(
			@RequestParam(value="mykeyword", required=false, defaultValue="null") String mykeyword,
			@RequestParam(value="category", required=false, defaultValue="null") String category,
			@RequestParam(value="pageNum", required=false, defaultValue="null") String pageNum,
			ProductListDTO dto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		
		String preUrl = request.getRequestURL().toString();
		session.setAttribute("preUrl", preUrl);
		
		String id = (String)session.getAttribute("sessionId");
		dto.setId(id);
		
		int pageSize = 8;
		if(pageNum.equals("null")) {
			pageNum = "1";
		}
		int col = 5;
		
		List categoryList = mainDAO.getCategory();
		model.addAttribute("categoryList", categoryList);
		
		if(id != null) {
			
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = currentPage * pageSize;
			
			dto.setStartRow(startRow);
			dto.setEndRow(endRow);
			
			if(mykeyword.equals("null") && category.equals("null")) {
				int mypagePdCount = mainDAO.wishPdCount(id);
				model.addAttribute("mypagePdCount", mypagePdCount);
				
				if(mypagePdCount > 0) {
					List mypageList = mainDAO.getWishPd(dto);
					model.addAttribute("mypageList", mypageList);
				}
			}
			if(!mykeyword.equals("null")) {
				dto.setKeyword(mykeyword);
				
				int mypagePdCount = mainDAO.wishSearchCount(dto);
				model.addAttribute("mypagePdCount", mypagePdCount);
				
				if(mypagePdCount > 0) {
					List mypageList = mainDAO.getWishSearch(dto);
					model.addAttribute("mypageList", mypageList);
				}
			}
			if(!category.equals("null")) {
				dto.setCategory(category);
				
				int mypagePdCount = mainDAO.wishTagPdCount(dto);
				model.addAttribute("mypagePdCount", mypagePdCount);
				
				if(mypagePdCount > 0) {
					List mypageList = mainDAO.getWishTagPd(dto);
					model.addAttribute("mypageList", mypageList);
				}
			}
		}
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("col", col);
		
		return "/product/mypage2";
	
	}
	
}
