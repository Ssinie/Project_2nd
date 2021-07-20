package bean.userManager;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserManagerDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void register(UserManagerDTO dto) {
		mybatis.insert("manager.register", dto);
	}
}
