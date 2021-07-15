package bean.healthy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8080/Project_2nd/healthyTip.ns
@Controller
	public class HealthyController {	
	@Autowired
	private HealthyDAO healthydao = null;

	@RequestMapping("healthyTip.ns")
	public String home() {
		//System.out.println("main()");
		return "/healthy/home";
	}
	
	@RequestMapping("getlist.ns")
	public String getList() throws Exception {
		String allList = healthydao.selectBoard();
		System.out.println(allList);
		return "/healthy/list";
	}
	
	
}
