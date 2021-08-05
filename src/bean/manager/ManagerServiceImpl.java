package bean.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAOMybatis managerDAOMybatis;
	
	public void register(ManagerDTO dto) {
		managerDAOMybatis.register(dto);
	}


	public ManagerDTO loginCheck(ManagerDTO dto) {
		return managerDAOMybatis.loginCheck(dto);
	}
	
	
	public ManagerDTO getManager(ManagerDTO dto) {
		return managerDAOMybatis.getManager(dto);
	}
	
	public List<ManagerDTO> getBoardList(ManagerDTO dto) {
		return managerDAOMybatis.getBoardList(dto);
	}


	public void updateManager(ManagerDTO dto) {
		managerDAOMybatis.updateManager(dto);
		
	}


	public void exUpdate(ManagerDTO dto) {
		managerDAOMybatis.exUpdate(dto);
		
	}


	public void exInsert(ManagerDTO dto) {
		managerDAOMybatis.exInsert(dto);
		
	}


	public void exDelete(ManagerDTO dto) {
		managerDAOMybatis.exDelete(dto);
		
	}


	public int idChk(ManagerDTO dto) {
		int result = managerDAOMybatis.idChk(dto);
		return result;
	}


	public void pwUdate(ManagerDTO dot) {
		managerDAOMybatis.pwUdate(dot);
		
	}


	public void sessionChk(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		   ManagerDTO mem = (ManagerDTO)session.getAttribute("mem");
			  if(mem == null || mem.getVerify() != 9 || mem.getStatus()==90) {
				  try {
					response.sendRedirect("/Project_2nd/manager/managerLogin.ns");
				} catch (IOException e) {
					e.printStackTrace();
				}
			  }	  
		}

}
