package bean.main;

import java.util.List;

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

	@Override
	public List getMainPd() throws Exception {
		return dao.selectList("main.getMainPd");
	}

	@Override
	public List getCategory() throws Exception {
		return dao.selectList("main.getCategory");
	}

	@Override
	public List getCatePd(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getCatePd", dto);
	}

	@Override
	public List getCateBest(String category) throws Exception {
		return dao.selectList("main.getCateBest", category);
	}

	@Override
	public int getPdCount(String category) throws Exception {
		return dao.selectOne("main.getPdCount", category);
	}
	
}


