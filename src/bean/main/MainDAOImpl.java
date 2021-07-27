package bean.main;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainDAOImpl implements MainDAOInter {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public Integer wishCheck(ProductDTO dto) throws Exception {
		return dao.selectOne("main.wishCheck", dto);
	}
	
	@Override
	public void wishInsert(ProductDTO dto) throws Exception {
		dao.insert("main.wishInsert", dto);
	}

	@Override
	public void wishDelete(ProductDTO dto) throws Exception {
		dao.delete("main.wishDelete", dto);
		
	}
	
}
