package bean.item.find;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.item.name.ItemNameCheck;

@Controller
@RequestMapping
public class ItemFindControllerImpl implements ItemFindControllerInter{

	@Autowired
	private ItemFindServiceImpl itemfindImpl = null;
	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	@RequestMapping("/itemfind.do")
	public String itemFind(Model model) {
		List subtag = itemfindImpl.selectSubtag();
		model.addAttribute("subtag",subtag);
		return "/itemfind/itemfind";
	}

	@Override
	@RequestMapping("/itemfindPro.do")
	public String itemFindPro(Model model, String subtag, int count) {
		ItemNameCheck INCdto = new ItemNameCheck();
		int catId = itemfindImpl.selectCatId(subtag);
		int resultCount = INCdto.itemInsert(dao, catId, count);
		model.addAttribute("resultCount", resultCount);
		return "/itemfind/itemfindPro";
	}

}
