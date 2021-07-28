package bean.manager;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ManagerDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void register(ManagerDTO dto) {
		mybatis.insert("manager.register", dto);
	}
	
	public ManagerDTO loginCheck(ManagerDTO dto) {
		return mybatis.selectOne("manager.loginCheck", dto);
	}
	
	public ManagerDTO getManager(ManagerDTO dto) {
		return (ManagerDTO) mybatis.selectOne("manager.getManager", dto);
	}
	
	public List<ManagerDTO> getBoardList(ManagerDTO dto) {
		return mybatis.selectList("manager.getBoardList", dto);
	}
	
	public void updateManager(ManagerDTO dto) {
		mybatis.update("manager.updateManager", dto);
	}
	
	public void exUpdate(ManagerDTO dto) {
		mybatis.update("manager.exUpdate", dto);
	}
	
	public void exInsert(ManagerDTO dto) {
		mybatis.insert("manager.exInsert", dto);
	}
	
	public void exDelete(ManagerDTO dto) {
		mybatis.insert("manager.exDelete", dto);
	}
	
	public int idChk(ManagerDTO dto) {
		int result = mybatis.selectOne("manager.idChk", dto);
		return result;
	}
	
	public void pwUdate(ManagerDTO dto) {
		mybatis.update("manager.pwUdate", dto);
	}
}