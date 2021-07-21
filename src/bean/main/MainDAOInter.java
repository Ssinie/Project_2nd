package bean.main;

import bean.myPage.WishlistDTO;

public interface MainDAOInter {

	// 관심상품 등록 insert
	public void wishInsert(WishlistDTO dto) throws Exception;
}
