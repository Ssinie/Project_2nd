package bean.question;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question/")
public class qBean {
	@Autowired
	// 다형성.
	private qBeanInter qImp = null ;
	
	@RequestMapping("qForm.do")
	public String qForm() throws Exception{
		return "/question/qForm" ;
	}
	
	// qForm에서 값 입력 받은 후 qForm02로 이동.
	@RequestMapping("qInsert.do")
	public String qInsert(qDTO dto) throws Exception{
		qImp.qInsert(dto) ;
		return "/question/qForm2" ;
	}
	
	@RequestMapping("qForm2.do")
	public String qForm2(q2DTO dto2, HttpSession session) throws Exception{
		session.setAttribute("qForm2", dto2);
		return "/question/qForm2_1" ;
	}
	@RequestMapping("qInsert2.do")
	public String qInsert2(q2DTO dto2, HttpSession session) throws Exception{
		session.getAttribute("qForm2") ;
		qImp.qInsert2(dto2) ;
		return "/question/qPro" ;
	}
}