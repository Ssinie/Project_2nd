package bean.userManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("manager")
public class UserManagerController {
	
	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("usermanager.ns")
	public 
}
