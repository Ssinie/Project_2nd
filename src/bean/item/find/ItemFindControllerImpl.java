package bean.item.find;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ItemFindControllerImpl implements ItemFindControllerInter{

	@Override
	@RequestMapping("/itemfind.do")
	public String itemFind(Model model) {
		
		// TODO Auto-generated method stub
		return "/itemfind/itemfind";
	}

	@Override
	@RequestMapping("/itemfindPro.do")
	public String itemFindPro() {
		// TODO Auto-generated method stub
		return "/itemfind/itemfindPro";
	}

}
