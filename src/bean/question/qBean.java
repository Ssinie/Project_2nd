package bean.question;

import bean.question.pDTO;
import bean.question.qDTO;
import bean.question.qBeanInter;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/question/")
public class qBean {
	
	@Autowired
	private SqlSession session ;
	private String Namespace = "question" ;
	
	// DB에서 컬럼 지문출력.
	public List<qDTO> qSelect() throws Exception{
		return session.selectList(Namespace+".qSelect") ;
	}
	
	@Resource(name = "qBeanInter")
    private qBeanInter service ;
	
    @RequestMapping("qForm01.do")
    public String qSelect(Model model) throws Exception{

        List<qDTO> qSelect = service.qSelect() ;
        model.addAttribute("question", qSelect) ;
 
        return "/question/qForm01" ;
    }
}