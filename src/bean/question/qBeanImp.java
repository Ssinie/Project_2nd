package bean.question;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class qBeanImp implements qBeanInter{
	
	@Autowired
	private SqlSessionTemplate mybatis = null ;
	
	@Override
	public void qInsert(qDTO dto) throws Exception {
		mybatis.insert("question.qInsert", dto) ;
	}
	
	// 세션.
	// @Autowired
    // private HttpSession session;
	
	/*
	// 2번째 질문 부터 세션 저장.
	@Override
	public void qInsert2(q2DTO dto2) throws Exception {
		// session.setAttribute("question2", dto2) ;
		mybatis.insert("question.insert2", dto2) ;
		// System.out.println(dto2.getIntr()) ;
	}
	*/
	@Override
	public void qcInsert(qcDTO dto) throws Exception {
		mybatis.insert("question2.qcInsert", dto) ;
	}
}
