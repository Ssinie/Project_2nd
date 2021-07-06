package bean.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class qBean {
	// DI
	@Autowired
	private qDTO qDTO = null ;
	
	@RequestMapping("qForm.do")
	public String qForm() {
		System.out.println(qDTO.nick()) ;
		return "/WEB-INF/view/question/qForm.jsp" ;
	}
}
