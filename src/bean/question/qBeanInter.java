package bean.question;

import java.util.List;

import bean.healthy.Criteria;
import bean.item.name.ItemNameDTO;
import bean.item.name.ItemTypeDTO;
import bean.item.name.ItemTypeValueDTO;
import bean.question.pDTO;
import bean.question.qDTO;

public interface qBeanInter {
	
	public void pInsert(pDTO dto) throws Exception ;
	
	public Object aResult(pDTO dto) ;
	
	public Object pResult(ItemTypeDTO dto) throws Exception ;
	
	public Object nResult(Object result) ;
	
	public List<qDTO> qSelect() throws Exception ;
	public List<qDTO> qSelect02() throws Exception ;
	public List<qDTO> qSelect03() throws Exception ;
	public List<qDTO> qSelect04() throws Exception ;
	public List<qDTO> qSelect05() throws Exception ;
	public List<qDTO> qSelect06() throws Exception ;
	public List<qDTO> qSelect07() throws Exception ;
	public List<qDTO> qSelect08() throws Exception ;
	public List<qDTO> qSelect09() throws Exception ;
	public List<qDTO> qSelect10() throws Exception ;
	public List<qDTO> qSelect11() throws Exception ;
	public List<qDTO> qSelect12() throws Exception ;
	public List<qDTO> qSelect13() throws Exception ;
	public List<qDTO> qSelect14() throws Exception ;
	public List<qDTO> qSelect15() throws Exception ;
	public List<qDTO> qSelect16() throws Exception ;
	public List<qDTO> qSelect17() throws Exception ;
	public List<qDTO> qSelect18() throws Exception ;
	public List<qDTO> qSelect19() throws Exception ;
	public List<qDTO> qSelect20() throws Exception ;
	public List<qDTO> qSelect21() throws Exception ;

	List<qDTO> getBoardList(qDTO dto);
	
	List<vDTO> getValueList(vDTO dto);
	
	qDTO getBoard(qDTO dto);
	
	vDTO getValue(vDTO dto);
	
	void updateBoard(qDTO dto);
	
	void updateValue(vDTO dto);
	
	int qCount();
	
	List<qDTO> qList(Criteria cri);
	
	int vCount();
	
	List<vDTO> vList(Criteria cri);
	
	ItemTypeValueDTO resultItemSearch(String no);

	public int count(ItemTypeValueDTO resultDto);
	public int count02(ItemTypeValueDTO resultDto);
	public int count03(ItemTypeValueDTO resultDto);
	public int count04(ItemTypeValueDTO resultDto);
	public int count05(ItemTypeValueDTO resultDto);
	public int count06(ItemTypeValueDTO resultDto);
	public int count07(ItemTypeValueDTO resultDto);
	public int count08(ItemTypeValueDTO resultDto);
	public int count09(ItemTypeValueDTO resultDto);
	public int count10(ItemTypeValueDTO resultDto);

	public String countOne(ItemTypeValueDTO resultDto);

	public List countList(ItemTypeValueDTO resultDto);

	public String countOne02(ItemTypeValueDTO resultDto);

	public List countList02(ItemTypeValueDTO resultDto);

	public String countOne03(ItemTypeValueDTO resultDto);

	public List countList03(ItemTypeValueDTO resultDto);

	public String countOne04(ItemTypeValueDTO resultDto);

	public List countList04(ItemTypeValueDTO resultDto);

	public String countOne05(ItemTypeValueDTO resultDto);

	public List countList05(ItemTypeValueDTO resultDto);

	public String countOne06(ItemTypeValueDTO resultDto);

	public List countList06(ItemTypeValueDTO resultDto);

	public String countOne07(ItemTypeValueDTO resultDto);

	public List countList07(ItemTypeValueDTO resultDto);

	public String countOne08(ItemTypeValueDTO resultDto);

	public List countList08(ItemTypeValueDTO resultDto);

	public String countOne09(ItemTypeValueDTO resultDto);

	public List countList09(ItemTypeValueDTO resultDto);

	public String countOne10(ItemTypeValueDTO resultDto);

	public List countList10(ItemTypeValueDTO resultDto);

	public ItemTypeDTO sProduct(String PRDLST_REPORT_NO);
	
	public int sNameCount(String PRDLST_REPORT_NO);

	public ItemNameDTO sName(String nm);
	
	public List sNames(String nm);
}