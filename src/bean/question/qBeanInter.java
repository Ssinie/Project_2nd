package bean.question;

import javax.servlet.http.HttpSession;

public interface qBeanInter {
	// 입력 받은 값을 qDTO에 받아 question 테이블에 추가.
	public void qInsert(qDTO dto) throws Exception ;
	
	// 입력02.
	public void qInsert2(q2DTO dto2) throws Exception ;
}
