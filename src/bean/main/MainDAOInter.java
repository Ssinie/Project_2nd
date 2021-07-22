package bean.main;

public interface MainDAOInter {

	// 관심상품 등록 insert
	public void wishInsert(WishlistDTO dto) throws Exception;
}
