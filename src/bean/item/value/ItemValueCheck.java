package bean.item.value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/")
public class ItemValueCheck {
	
	public String ItemValueCheck() {
		
		
		
		return "master/ItemValueCheck";
	}
}
