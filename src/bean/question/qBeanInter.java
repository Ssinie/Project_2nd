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

	public int count();

	public String countOne();

	public List countList();

	public String countOne02();

	public List countList02();

	public String countOne03();

	public List countList03();

	public String countOne04();

	public List countList04();

	public String countOne05();

	public List countList05();

	public String countOne06();

	public List countList06();

	public String countOne07();

	public List countList07();

	public String countOne08();

	public List countList08();

	public String countOne09();

	public List countList09();

	public String countOne10();

	public List countList10();
}