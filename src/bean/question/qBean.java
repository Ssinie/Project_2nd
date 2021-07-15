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
    private qBeanInter service = null;
	
	// DB를 qSelect랑 연결.
    @RequestMapping("qForm01.do")
    public String qSelect(Model model) throws Exception{

        List<qDTO> qSelect = service.qSelect() ;
        model.addAttribute("qSelect", qSelect) ;
 
        return "/question/qForm01" ;
    }
    
    // qPro 페이지.
    @RequestMapping("qPro.do")
	public String qPro() throws Exception{
		return "/question/qPro" ;
	}
    
    // pForm 페이지.
    @RequestMapping("pForm.do")
    public String pForm() throws Exception{
    	return "/question/pForm" ;
    }
    
    // pinfo DB에 개인정보 삽입.
    @RequestMapping("pInsert.do")
    public String pInsert(pDTO dto) throws Exception{
    	service.pInsert(dto) ;
    	return "/question/qForm01" ;
    }
}