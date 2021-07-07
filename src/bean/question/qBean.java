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
	
	@RequestMapping("qInsert.do")
	public String qInsert(qDTO dto) throws Exception{
		qImp.qInsert(dto) ;
		return "/question/qPro" ;
	}
}