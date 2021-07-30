package bean.healthy;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository // 데이터베이스 연동을 처리하는 DAO 클래스
public class HealthyDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//입력
	public void insertBoard(HealthyDTO dto) {
		mybatis.insert("healthy.insertBoard", dto);
	}
	
	//수정
	public void updateBoard(HealthyDTO dto) {
		mybatis.update("healthy.updateBoard", dto);
	}
	
	//삭제
	public void deleteBoard(HealthyDTO dto) {
		mybatis.delete("healthy.deleteBoard", dto);
	}
	
	//상세화면
	public HealthyDTO getBoard(HealthyDTO dto) {
		return (HealthyDTO) mybatis.selectOne("healthy.getBoard", dto);
	}
	
	//목록
	public List<HealthyDTO> getBoardList(HealthyDTO dto) {
		return mybatis.selectList("healthy.getBoardList", dto);
	}

	//개시물 총 갯수
	public int count() {
		return mybatis.selectOne("healthy.count");
	}
	
	//목록 + 페이징처리
	public List<HealthyDTO> listPage(Criteria cri){
		return mybatis.selectList("healthy.listPage", cri);
	}
}
