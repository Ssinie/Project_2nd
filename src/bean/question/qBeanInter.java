package bean.question;

import bean.question.qDTO ;

public interface qBeanInter {
	// 입력 받은 값을 qDTO에 받아 question 테이블에 추가.
	public void qInsert(qDTO dto) throws Exception ;
}
