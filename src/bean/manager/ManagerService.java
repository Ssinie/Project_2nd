package bean.manager;

import java.util.List;

public interface ManagerService {
	
	void register(ManagerDTO dto);
	
	ManagerDTO loginCheck(ManagerDTO dto);
	
	ManagerDTO getManager(ManagerDTO dto);
	
	List<ManagerDTO> getBoardList(ManagerDTO dto);
	
	void updateManager(ManagerDTO dto);
	
	void exUpdate(ManagerDTO dto);
	
	void exInsert(ManagerDTO dto);
	
	void exDelete(ManagerDTO dto);
	
	int idChk(ManagerDTO dto);
	
	void pwUdate(ManagerDTO dot);

}
