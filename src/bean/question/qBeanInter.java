package bean.question;

import java.util.List;

import bean.question.pDTO;
import bean.question.qDTO;

public interface qBeanInter {
	public List<qDTO> qSelect() throws Exception ;
}