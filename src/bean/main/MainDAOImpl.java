package bean.main;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.myPage.WishlistDTO;

@Service
public class MainDAOImpl implements MainDAOInter {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public void wishInsert(WishlistDTO dto) throws Exception {
		dao.insert("main.wishInsert", dto);
	}
	
}
