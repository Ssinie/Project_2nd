package bean.main;

import java.util.List;

public interface MainDAOInter {

	// 관심상품 버튼 눌렀는지 확인 select
	public Integer wishCheck(ProductDTO dto) throws Exception;
	
	// 관심상품 등록 insert
	public void wishInsert(ProductDTO dto) throws Exception;
	
	// 관심상품 삭제 delete
	public void wishDelete(ProductDTO dto) throws Exception;
	
	// main.ns 전체상품 조회순 상품명, 이미지 select
	public List getMainPd() throws Exception;
	
	// 상품목록 카테고리 select
	public List getCategory() throws Exception;
	
	// 카테고리별 상품목록 조회순 상품명, 이미지 select
	public List getCatePd(ProductListDTO dto) throws Exception;
	
	// 카테고리별 상품목록 조회순 6개 상품명, 이미지 select --> 관심상품 등록순으로 변경 예정
	public List getCateBest(String category) throws Exception;
	
	// 상품 개수 select count(*)
	public int getPdCount(String category) throws Exception;
}

