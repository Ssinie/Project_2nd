package bean.healthy;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository // 데이터베이스 연동을 처리하는 DAO 클래스
public class HealthyDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(HealthyDTO dto) {
		mybatis.insert("healthy.insertBoard", dto);
	}
	
	public void updateBoard(HealthyDTO dto) {
		mybatis.update("healthy.updateBoard", dto);
	}
	
	public void deleteBoard(HealthyDTO dto) {
		mybatis.delete("healthy.deleteBoard", dto);
	}
	
	public HealthyDTO getBoard(HealthyDTO dto) {
		return (HealthyDTO) mybatis.selectOne("healthy.getBoard", dto);
	}
	
	public List<HealthyDTO> getBoardList(HealthyDTO dto) {
		return mybatis.selectList("healthy.getBoardList", dto);
	}

}
