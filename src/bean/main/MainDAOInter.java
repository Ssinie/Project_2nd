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
	public List getCatePd(String category) throws Exception;
	
}

