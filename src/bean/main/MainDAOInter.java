package bean.main;

import java.util.List;

public interface MainDAOInter {

	// 관심상품 버튼 눌렀는지 확인 select
	public Integer wishCheck(ProductDTO dto) throws Exception;
	
	// 관심상품 등록 insert
	public void wishInsert(ProductDTO dto) throws Exception;
	
	// 관심상품 삭제 delete
	public void wishDelete(ProductDTO dto) throws Exception;
	
	// 상품목록(상품명, 이미지) select
	public List getPdList() throws Exception;
	
}
