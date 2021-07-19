package bean.healthy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService") // 비지니스 로직을 처리하는 Service 클래스
public class BoardServiceImpl implements BoardService	{
	@Autowired
	private HealthyDAOMybatis healthyDAOMybatis;

	public void insertBoard(HealthyDTO dto) {
		healthyDAOMybatis.insertBoard(dto);	
	}
	

	public void updateBoard(HealthyDTO dto) {
		healthyDAOMybatis.updateBoard(dto);		
	}

	
	public void deleteBoard(HealthyDTO dto) {
		healthyDAOMybatis.deleteBoard(dto);		
	}

	
	public HealthyDTO getBoard(HealthyDTO dto) {
		return healthyDAOMybatis.getBoard(dto);
	}

	
	public List<HealthyDTO> getBoardList(HealthyDTO dto) {
		return healthyDAOMybatis.getBoardList(dto);
	}
	

}
