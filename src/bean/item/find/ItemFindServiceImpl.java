package bean.item.find;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemFindServiceImpl implements ItemFindServiceInter{

	@Autowired
	private SqlSessionTemplate mybatis = null;
	
	@Override
	public List selectSubtag() {
		return mybatis.selectList("item_name.findCategory");
	}

	@Override
	public int selectCatId(String subtag) {
		return mybatis.selectOne("item_name.findCatId",subtag);
	}

}
