package bean.item.find;

import org.springframework.ui.Model;

public interface ItemFindControllerInter {

	// 관리페이지 중 itemfind 페이지를 보여 줄 메서드
		public String itemFind(Model model);
		
	// 관리페이지 중 itemfind 페이지의 처리를 진행 할 메서드
	public String itemFindPro(Model model, String subtag, int count);
}
