package bean.healthy;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class HealthyDAO implements HealthyDAOInter{
	
	@Autowired
	private SqlSessionTemplate dao = null;

	@Override
	public void insertBoard(HealthyDTO dto) {
		dao.insert("healthy.insertBoard", dto);
	}
	
	@Override
	public String selectBoard(){
		return dao.selectOne("healthy.selectBoard");	
	}
	
}
