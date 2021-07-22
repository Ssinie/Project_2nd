package bean.main;

public interface MainDAOInter {

	// 관심상품 버튼 눌렀는지 확인 select
	public int wishCheck(ProductDTO dto) throws Exception;
	
	// 관심상품 등록 insert
	public void wishInsert(ProductDTO dto) throws Exception;
}
