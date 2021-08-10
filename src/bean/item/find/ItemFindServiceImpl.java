package bean.item.find;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemFindServiceImpl implements ItemFindServiceInter{

	@Autowired
	private SqlSessionTemplate mybatis = null;
	
	@Override
	public List selectSubtag() {
		List list = mybatis.selectList("");
		return list;
	}

}
