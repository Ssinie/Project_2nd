package bean.item.find;

import java.util.List;

public interface ItemFindServiceInter {

	public List selectSubtag();
	
	public int selectCatId(String subtag);
}
