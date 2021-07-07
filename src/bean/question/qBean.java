package bean.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import bean.question.qDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question/")
public class qBean {
	// DI
	@Autowired
	// private qDTO qDTO = null ;
	
	@RequestMapping("qForm.do")
	public String qForm() {
		return "/question/qForm" ;
	}
	
	@RequestMapping("qPro.do")
	public String qPro(qDTO qDTO) {
		return "/question/qForm" ;
	}
}