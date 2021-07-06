package bean.item.value;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/")
public class ItemValueCheck {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	@RequestMapping("itemcheck.go")
	public String ItemValueCheck() {
		
		List member = dao.selectList("Item_value.getItemName");
		
		
		return "/master/ItemValueCheck";
	}
}
