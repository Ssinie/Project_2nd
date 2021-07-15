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
	
	
	// ���� search URL : https://www.coupang.com/np/search?component=&q=���͸ӽ�WPH-2kg+�ｺ������+��������/�����ܹ���
	// ���� search URL : https://browse.auction.co.kr/search?keyword=���͸ӽ�WPH-2kg+�ｺ������
	
	
	
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
	
	
	// ����, ���ο��� 'item_name'���� ������ �̸��� �̿��� �˻� �� ������ 5���� ���� ������ �����´�..
	public void ItemValueSearch() {
		String aucpath = "https://www.coupang.com/np/search?component=&q=";
		String coupath = "https://browse.auction.co.kr/search?keyword=";
		
	}
}
