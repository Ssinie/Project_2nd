package bean.healthy;

import java.util.List;

public interface HealthyDAOInter {
	
	//건강정보 insert
	public void insertBoard(HealthyDTO dto) throws Exception;
	
	public String selectBoard() throws Exception;

}
