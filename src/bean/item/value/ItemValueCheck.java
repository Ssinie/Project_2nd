package bean.item.value;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import bean.item.value.ItemNameDTO;

@Controller
@RequestMapping("/master/")
public class ItemValueCheck {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	
	// 옥션 search URL : https://www.coupang.com/np/search?component=&q=몬스터머슬WPH-2kg+헬스보충제+순수근육/순수단백질
	// 쿠팡 search URL : https://browse.auction.co.kr/search?keyword=몬스터머슬WPH-2kg+헬스보충제
	
	
	
	@RequestMapping("itemcheck.go")
	public String ItemValueCheck(Model model) {
		
		List list = dao.selectList("Item_value.getItemName");
		
		System.out.println(list.size());
		
		// ItemNameDTO INDTO = (ItemNameDTO)list.get(0);
		// System.out.println(INDTO.getNum());
		// System.out.println(INDTO.getName());
		
		model.addAttribute("list", list);
		return "/master/ItemValueCheck";
	}
	
	
	// 옥션, 쿠팡에서 'item_name'에서 가져온 이름을 이용해 검색 후 최저가 5개의 가격 정보를 가져온다..
	public void ItemValueSearch() {
		String aucpath = "https://www.coupang.com/np/search?component=&q=";
		String coupath = "https://browse.auction.co.kr/search?keyword=";
		
	}
}
