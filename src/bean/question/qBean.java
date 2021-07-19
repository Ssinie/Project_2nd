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
	public List<qDTO> qSelect() throws Exception{return session.selectList(Namespace+".qSelect") ;}
	public List<qDTO> qSelect02() throws Exception{return session.selectList(Namespace+".qSelect02") ;}
	public List<qDTO> qSelect03() throws Exception{return session.selectList(Namespace+".qSelect03") ;}
	public List<qDTO> qSelect04() throws Exception{return session.selectList(Namespace+".qSelect04") ;}
	public List<qDTO> qSelect05() throws Exception{return session.selectList(Namespace+".qSelect05") ;}
	public List<qDTO> qSelect06() throws Exception{return session.selectList(Namespace+".qSelect06") ;}
	public List<qDTO> qSelect07() throws Exception{return session.selectList(Namespace+".qSelect07") ;}
	public List<qDTO> qSelect08() throws Exception{return session.selectList(Namespace+".qSelect08") ;}
	public List<qDTO> qSelect09() throws Exception{return session.selectList(Namespace+".qSelect09") ;}
	public List<qDTO> qSelect10() throws Exception{return session.selectList(Namespace+".qSelect10") ;}
	public List<qDTO> qSelect11() throws Exception{return session.selectList(Namespace+".qSelect11") ;}
	public List<qDTO> qSelect12() throws Exception{return session.selectList(Namespace+".qSelect12") ;}
	public List<qDTO> qSelect13() throws Exception{return session.selectList(Namespace+".qSelect13") ;}
	public List<qDTO> qSelect14() throws Exception{return session.selectList(Namespace+".qSelect14") ;}
	public List<qDTO> qSelect15() throws Exception{return session.selectList(Namespace+".qSelect15") ;}
	public List<qDTO> qSelect16() throws Exception{return session.selectList(Namespace+".qSelect16") ;}
	public List<qDTO> qSelect17() throws Exception{return session.selectList(Namespace+".qSelect17") ;}
	public List<qDTO> qSelect18() throws Exception{return session.selectList(Namespace+".qSelect18") ;}
	public List<qDTO> qSelect19() throws Exception{return session.selectList(Namespace+".qSelect19") ;}
	public List<qDTO> qSelect20() throws Exception{return session.selectList(Namespace+".qSelect20") ;}
	public List<qDTO> qSelect21() throws Exception{return session.selectList(Namespace+".qSelect21") ;}
	
	@Resource(name = "qBeanInter")
    private qBeanInter service = null;
	
	// DB를 qSelect랑 연결.
    @RequestMapping("qForm01.do")
    public String qSelect(Model model) throws Exception{
        List<qDTO> qSelect = service.qSelect() ;
        model.addAttribute("qSelect", qSelect) ;
        return "/question/qForm01" ;
    }
    @RequestMapping("qForm02.do")
    public String qSelect02(Model model) throws Exception{
        List<qDTO> qSelect02 = service.qSelect02() ;
        model.addAttribute("qSelect02", qSelect02) ;
        return "/question/qForm02" ;
    }
    @RequestMapping("qForm03.do")
    public String qSelect03(Model model) throws Exception{
        List<qDTO> qSelect03 = service.qSelect03() ;
        model.addAttribute("qSelect03", qSelect03) ;
        return "/question/qForm03" ;
    }
    @RequestMapping("qForm04.do")
    public String qSelect04(Model model) throws Exception{
        List<qDTO> qSelect04 = service.qSelect04() ;
        model.addAttribute("qSelect04", qSelect04) ;
        return "/question/qForm04" ;
    }
    @RequestMapping("qForm05.do")
    public String qSelect05(Model model) throws Exception{
        List<qDTO> qSelect05 = service.qSelect05() ;
        model.addAttribute("qSelect05", qSelect05) ;
        return "/question/qForm05" ;
    }
    @RequestMapping("qForm06.do")
    public String qSelect06(Model model) throws Exception{
        List<qDTO> qSelect06 = service.qSelect06() ;
        model.addAttribute("qSelect06", qSelect06) ;
        return "/question/qForm06" ;
    }
    @RequestMapping("qForm07.do")
    public String qSelect07(Model model) throws Exception{
        List<qDTO> qSelect07 = service.qSelect07() ;
        model.addAttribute("qSelect07", qSelect07) ;
        return "/question/qForm07" ;
    }
    @RequestMapping("qForm08.do")
    public String qSelect08(Model model) throws Exception{
        List<qDTO> qSelect08 = service.qSelect08() ;
        model.addAttribute("qSelect08", qSelect08) ;
        return "/question/qForm08" ;
    }
    @RequestMapping("qForm09.do")
    public String qSelect09(Model model) throws Exception{
        List<qDTO> qSelect09 = service.qSelect09() ;
        model.addAttribute("qSelect09", qSelect09) ;
        return "/question/qForm09" ;
    }
    @RequestMapping("qForm10.do")
    public String qSelect10(Model model) throws Exception{
        List<qDTO> qSelect10 = service.qSelect10() ;
        model.addAttribute("qSelect10", qSelect10) ;
        return "/question/qForm10" ;
    }
    @RequestMapping("qForm11.do")
    public String qSelect11(Model model) throws Exception{
        List<qDTO> qSelect11 = service.qSelect11() ;
        model.addAttribute("qSelect11", qSelect11) ;
        return "/question/qForm11" ;
    }
    @RequestMapping("qForm12.do")
    public String qSelect12(Model model) throws Exception{
        List<qDTO> qSelect12 = service.qSelect12() ;
        model.addAttribute("qSelect12", qSelect12) ;
        return "/question/qForm12" ;
    }
    @RequestMapping("qForm13.do")
    public String qSelect13(Model model) throws Exception{
        List<qDTO> qSelect13 = service.qSelect13() ;
        model.addAttribute("qSelect13", qSelect13) ;
        return "/question/qForm13" ;
    }
    @RequestMapping("qForm14.do")
    public String qSelect14(Model model) throws Exception{
        List<qDTO> qSelect14 = service.qSelect14() ;
        model.addAttribute("qSelect14", qSelect14) ;
        return "/question/qForm14" ;
    }
    @RequestMapping("qForm15.do")
    public String qSelect15(Model model) throws Exception{
        List<qDTO> qSelect15 = service.qSelect15() ;
        model.addAttribute("qSelect15", qSelect15) ;
        return "/question/qForm15" ;
    }
    @RequestMapping("qForm16.do")
    public String qSelect16(Model model) throws Exception{
        List<qDTO> qSelect16 = service.qSelect16() ;
        model.addAttribute("qSelect16", qSelect16) ;
        return "/question/qForm16" ;
    }
    @RequestMapping("qForm17.do")
    public String qSelect17(Model model) throws Exception{
        List<qDTO> qSelect17 = service.qSelect17() ;
        model.addAttribute("qSelect17", qSelect17) ;
        return "/question/qForm17" ;
    }
    @RequestMapping("qForm18.do")
    public String qSelect18(Model model) throws Exception{
        List<qDTO> qSelect18 = service.qSelect18() ;
        model.addAttribute("qSelect18", qSelect18) ;
        return "/question/qForm18" ;
    }
    @RequestMapping("qForm19.do")
    public String qSelect19(Model model) throws Exception{
        List<qDTO> qSelect19 = service.qSelect19() ;
        model.addAttribute("qSelect19", qSelect19) ;
        return "/question/qForm19" ;
    }
    @RequestMapping("qForm20.do")
    public String qSelect20(Model model) throws Exception{
        List<qDTO> qSelect20 = service.qSelect20() ;
        model.addAttribute("qSelect20", qSelect20) ;
        return "/question/qForm20" ;
    }
    @RequestMapping("qForm21.do")
    public String qSelect21(Model model) throws Exception{
        List<qDTO> qSelect21 = service.qSelect21() ;
        model.addAttribute("qSelect21", qSelect21) ;
        return "/question/qForm21" ;
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
    	return "redirect: http://localhost:8080/Project_2nd/question/qForm01.do" ;
    }
    
    // qResult 페이지.
    @RequestMapping("qResult.do")
    public String qResult() throws Exception{
        return "/question/qResult" ;
    }
}