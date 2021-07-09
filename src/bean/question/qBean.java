package bean.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import bean.question.qDTO;

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
		return "/question/qForm02" ;
	}
	
	@RequestMapping("qInsert02.do")
	public String qInsert02(qDTO dto) throws Exception{
		qImp.qInsert02(dto) ;
		return "/question/qPro" ;
	}
	
}