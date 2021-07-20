package bean.question;

import java.util.List;

import bean.question.pDTO;
import bean.question.qDTO;

public interface qBeanInter {
	
	public void pInsert(pDTO dto) throws Exception ;
	
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
	
	public void result(qDTO dto) throws Exception ;
}