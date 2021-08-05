package bean.main;

import java.util.List;

public interface MainDAOInter {

	// 관심상품 버튼 눌렀는지 확인 select
	public Integer wishCheck(ProductDTO dto) throws Exception;
	
	// 관심상품 등록 insert
	public void wishInsert(ProductDTO dto) throws Exception;
	
	// 관심상품 삭제 delete
	public void wishDelete(ProductDTO dto) throws Exception;
	
	// 메인 페이지 전체상품 조회순 상품명, 이미지 8개 select
	public List getMainPd() throws Exception;
	
	// 상품목록 카테고리 select
	public List getCategory() throws Exception;
	
	// 카테고리별 상품목록 조회순 상품명, 이미지 select
	public List getCatePd(ProductListDTO dto) throws Exception;
	
	// 카테고리별 상품목록 Best (조회순 6개) 상품명, 이미지 select --> 관심상품 등록순으로 변경 예정
	public List getCateBest(String category) throws Exception;
	
	// 카테고리별 상품개수 select count(*)
	public int catePdCount(String category) throws Exception;
	
	// 검색 상품목록 조회순 상품명, 이미지 select
	public List getSearchPd(ProductListDTO dto) throws Exception;
	
	// 검색 상품개수 select count(*)
	public int searchPdCount(String keyword) throws Exception;
	
//	// 상품 페이지 상품번호로 상품명, 이미지 select
//	public List getPd(int num) throws Exception;
	
	// 상품번호로 상품구매 url select
	public String getUrl(int num) throws Exception;
	
	// 아이디로 wishlist 상품번호 select --> 상품번호로 상품명, 이미지, 영양성분 select
	public List getMypagePd(ProductListDTO dto) throws Exception;
	
	// 아이디로 관심상품 개수 select
	public int mypagePdCount(String id) throws Exception;
	
	// 전체상품 조회순 select
	public List getAllPd(ProductListDTO dto) throws Exception;
	
	// 전체상품 조회순 상품명, 이미지 6개 select
	public List getAllBest() throws Exception;
	
	// 전체상품 개수 select count(*)
	public int allPdCount() throws Exception;
	
	// 마이페이지 검색 관심상품 등록순 상품번호, 상품명, 이미지, 영양성분 select
	public List getMypageSearch(ProductListDTO dto) throws Exception;
	
	// 마이페이지 검색 개수
	public int mypageSearchCount(ProductListDTO dto) throws Exception;
	
}

