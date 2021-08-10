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
	public int catePdCount(String category) throws Exception {
		return dao.selectOne("main.catePdCount", category);
	}

	@Override
	public List getSearchPd(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getSearchPd", dto);
	}

	@Override
	public int searchPdCount(String keyword) throws Exception {
		return dao.selectOne("main.searchPdCount", keyword);
	}
	
//	@Override
//	public List getPd(int num) throws Exception {
//		return dao.selectList("main.getPd", num);
//	}
	
	@Override
	public String getUrl(int num) throws Exception {
		return dao.selectOne("main.getUrl", num);
	}

	@Override
	public List getWishPd(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getWishPd", dto);
	}

	@Override
	public int wishPdCount(String id) throws Exception {
		return dao.selectOne("main.wishPdCount", id);
	}

	@Override
	public List getAllPd(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getAllPd", dto);
	}

	@Override
	public List getAllBest() throws Exception {
		return dao.selectList("main.getAllBest");
	}

	@Override
	public int allPdCount() throws Exception {
		return dao.selectOne("main.allPdCount");
	}

	@Override
	public List getWishSearch(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getWishSearch", dto);
	}

	@Override
	public int wishSearchCount(ProductListDTO dto) throws Exception {
		return dao.selectOne("main.wishSearchCount", dto);
	}

	@Override
	public List getWishTagPd(ProductListDTO dto) throws Exception {
		return dao.selectList("main.getWishTagPd", dto);
	}

	@Override
	public int wishTagPdCount(ProductListDTO dto) throws Exception {
		return dao.selectOne("main.wishTagPdCount", dto);
	}

	@Override
	public void wishAllDelete(String id) throws Exception {
		dao.delete("main.wishAllDelete", id);
	}
}


