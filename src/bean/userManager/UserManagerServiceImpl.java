package bean.userManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserManagerServiceImpl implements UserManagerService{
	@Autowired
	private UserManagerDAOMybatis usermanagerDAOMybatis;
	public void register(UserManagerDTO dto) {
		usermanagerDAOMybatis.register(dto);
		
	}

}
