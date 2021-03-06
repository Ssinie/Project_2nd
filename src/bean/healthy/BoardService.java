package bean.healthy;

import java.util.List;

public interface BoardService {
	
	void insertBoard(HealthyDTO dto);
	
	void updateBoard(HealthyDTO dto);
	
	void deleteBoard(HealthyDTO dto);
	
	HealthyDTO getBoard(HealthyDTO dto);

	List<HealthyDTO> getBoardList(HealthyDTO dto);
	
	int count();
	
	List<HealthyDTO> listPage(Criteria cri);
	
	List<HealthyDTO> healthyBoardList(HealthyDTO dto);

}
