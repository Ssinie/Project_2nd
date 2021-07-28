package bean.question;

import bean.question.pDTO;
import bean.question.qDTO;
import bean.question.qBeanInter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

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
    
    @RequestMapping("pInsert.do")
	public String pInsert(pDTO dto, Model model) throws Exception{
    	// 신상정보 DB입력.
    	service.pInsert(dto) ;
    	
    	// 01
    	List<qDTO> qSelect = service.qSelect() ;
        model.addAttribute("qSelect", qSelect) ;
        // 02
        List<qDTO> qSelect02 = service.qSelect02() ;
        model.addAttribute("qSelect02", qSelect02) ;
        // 03
        List<qDTO> qSelect03 = service.qSelect03() ;
        model.addAttribute("qSelect03", qSelect03) ;
        // 04
        List<qDTO> qSelect04 = service.qSelect04() ;
        model.addAttribute("qSelect04", qSelect04) ;
        // 05
        List<qDTO> qSelect05 = service.qSelect05() ;
        model.addAttribute("qSelect05", qSelect05) ;
        // 06
        List<qDTO> qSelect06 = service.qSelect06() ;
        model.addAttribute("qSelect06", qSelect06) ;
        // 07
        List<qDTO> qSelect07 = service.qSelect07() ;
        model.addAttribute("qSelect07", qSelect07) ;
        // 08
        List<qDTO> qSelect08 = service.qSelect08() ;
        model.addAttribute("qSelect08", qSelect08) ;
        // 09
        List<qDTO> qSelect09 = service.qSelect09() ;
        model.addAttribute("qSelect09", qSelect09) ;
        // 10
        List<qDTO> qSelect10 = service.qSelect10() ;
        model.addAttribute("qSelect10", qSelect10) ;
        // 11
        List<qDTO> qSelect11 = service.qSelect11() ;
        model.addAttribute("qSelect11", qSelect11) ;
        // 12
        List<qDTO> qSelect12 = service.qSelect12() ;
        model.addAttribute("qSelect12", qSelect12) ;
        // 13
        List<qDTO> qSelect13 = service.qSelect13() ;
        model.addAttribute("qSelect13", qSelect13) ;
        // 14
        List<qDTO> qSelect14 = service.qSelect14() ;
        model.addAttribute("qSelect14", qSelect14) ;
        // 15
        List<qDTO> qSelect15 = service.qSelect15() ;
        model.addAttribute("qSelect15", qSelect15) ;
        // 16
        List<qDTO> qSelect16 = service.qSelect16() ;
        model.addAttribute("qSelect16", qSelect16) ;
        // 17
        List<qDTO> qSelect17 = service.qSelect17() ;
        model.addAttribute("qSelect17", qSelect17) ;
        // 18
        List<qDTO> qSelect18 = service.qSelect18() ;
        model.addAttribute("qSelect18", qSelect18) ;
        // 19
        List<qDTO> qSelect19 = service.qSelect19() ;
        model.addAttribute("qSelect19", qSelect19) ;
        // 20
        List<qDTO> qSelect20 = service.qSelect20() ;
        model.addAttribute("qSelect20", qSelect20) ;
        // 21
        List<qDTO> qSelect21 = service.qSelect21() ;
        model.addAttribute("qSelect21", qSelect21) ;
        
		return "/question/form" ;
	}
    
    // 설문조사 값 R 로 전송.
    @RequestMapping("qResult.do")
    public List<vDTO> qResult(HttpServletRequest request, vDTO dto) throws Exception{
    	// form 페이지에서 체크 value 값을 pValue에 vList로 넣는다.
    	String [] pValue = request.getParameterValues("contents") ;
    	List<vDTO> vList =  new ArrayList<vDTO>() ;
    	for(String v : pValue) {
    		System.out.println(v) ;
    		vDTO dto02 = session.selectOne("question.qValue", v) ;
    		vList.add(dto02) ;
    	}
    	// vList의 크기 만큼, key의 유무를 따져 중복이면 그 값만큼 더하고 집어 넣는다.
    	// 중복이 아니면 null값 체크 후 넣는다.
    	// TreeMap 으로 영양소 알파벳 순서대로 집어 넣는다.
    	TreeMap<String, Integer> vMap = new TreeMap<String, Integer>() ;
    	// 영양소 기본값 셋팅.
    	vMap.put("vitaminA", 0) ;
        vMap.put("vitaminB", 0) ;
        vMap.put("vitaminC", 0) ;
        vMap.put("vitaminD", 0) ;
        vMap.put("vitaminE", 0) ;
        vMap.put("vitaminK", 0) ;
        vMap.put("omega3", 0) ;
        vMap.put("lutein", 0) ;
        vMap.put("probiotic", 0) ;
        vMap.put("calcium", 0) ;
        vMap.put("collagen", 0) ;
        vMap.put("redginseng", 0) ;
        vMap.put("magnesium", 0) ;
        vMap.put("mineral", 0) ;
        vMap.put("zinc", 0) ;
        vMap.put("biotin", 0) ;
        vMap.put("milkthistle", 0) ;
        vMap.put("iron", 0) ;
        vMap.put("phosphorus", 0) ;
        vMap.put("propolis", 0) ;
        vMap.put("amino", 0) ;
        vMap.put("dietryfiber", 0) ;
        vMap.put("gammalinolenic", 0) ;
        vMap.put("selenium", 0) ;
    	System.out.println(vMap) ;
    	
    	for(int i = 0 ; i < vList.size(); i++) {
    		dto = vList.get(i) ;
    		int value = vMap.get(dto.getNutri01()) ;
	        value = value + dto.getVal01() ;
	        vMap.put(dto.getNutri01(), value) ;
    	}
    	
    	for(int i = 0 ; i < vList.size(); i++) {
    		dto = vList.get(i) ;
    		if(dto.getNutri02() != null) {
	    		int value02 = vMap.get(dto.getNutri02()) ;
		        value02 = value02 + dto.getVal02() ;
		        vMap.put(dto.getNutri02(), value02) ;
    		}
    	}
    	/* 	
    	for(int i = 0 ; i < vList.size() ; i++){
    		dto = vList.get(i) ;
	    	if(vMap.containsKey(dto.getNutri01())) {
	    		dto.setVal01(dto.getVal01() + dto.getVal01());
	    		vMap.put(dto.getNutri01(), dto.getVal01() + "") ;
	    	} else if (dto.getNutri01() != null) {
	    		dto.setVal01(dto.getVal01());
	    		vMap.put(dto.getNutri01(), dto.getVal01() + "") ;
	    	}
	    	if(vMap.containsKey(dto.getNutri02()) || dto.getNutri02() != null) {
	    		dto.setVal02(dto.getVal02() + dto.getVal02());
	    		vMap.put(dto.getNutri02(), dto.getVal02() + "") ;
	    	} else if (dto.getNutri02() != null) {
	    		dto.setVal02(dto.getVal02());
	    		vMap.put(dto.getNutri02(), dto.getVal02() + "") ;
	    	}
    	}
    	*/
    	System.out.println(vMap) ;
    	
    	Object obj[] = vMap.keySet().toArray() ;
        Object val[] = vMap.values().toArray() ;
        String [] nutriList = new String[obj.length] ;
        String [] valueList = new String[val.length] ;
        for(int i = 0 ; i < obj.length ; i ++) {
           nutriList[i] = (String)obj[i];
           valueList[i] = val[i] + "";
        }
        // System.out.println(Arrays.toString(valueList)) ;
    	// R 연결 및 data.frame화.
    	RConnection conn ;
    	try {
			conn = new RConnection() ;
			REXP x = conn.eval("R.version.string") ;
	    	System.out.println("R version : " + x.asString()) ;
	    	
	    	//, length(pValue)
	    	// + "assign(pValue[i],i)"
	    	/*
	    	conn.assign("nutriList", nutriList) ;
	    	conn.assign("valueList", valueList) ;
	    	conn.eval("print(nutriList)") ;
	    	conn.eval("str(nutriList)") ;
	    	conn.eval("print(valueList)") ;
	    	conn.eval("str(valueList)") ;
	    	conn.eval("library('stringr')") ;
	    	conn.eval("valueList <- as.numeric(valueList)") ;
	    	conn.eval("valueList <- c(valueList)") ;
	    	conn.eval("print(valueList)") ;
	    	conn.eval("str(valueList)") ;
	    	*/
	    	conn.eval("myList <- data.frame(amino = '"+valueList[0]+"', biotin = '"+valueList[1]+"', calcium = '"+valueList[2]+"', collagen = '"+valueList[3]+"', dietryfiber = '"+valueList[4]+"', gammalinolenic = '"+valueList[5]+"', "
	    			+ "iron = '"+valueList[6]+"', lutein = '"+valueList[7]+"', magnesium = '"+valueList[8]+"', milkthistle = '"+valueList[9]+"', mineral = '"+valueList[10]+"', omega3 = '"+valueList[11]+"', phosphorus = '"+valueList[12]+"', "
	    			+ "probiotic = '"+valueList[13]+"', propolis = '"+valueList[14]+"', redginseng = '"+valueList[15]+"', selenium = '"+valueList[16]+"', vitaminA = '"+valueList[17]+"', vitaminB = '"+valueList[18]+"', "
	    			+ "vitaminC = '"+valueList[19]+"', vitaminD = '"+valueList[20]+"', vitaminE = '"+valueList[21]+"', vitaminK = '"+valueList[22]+"', zinc = '"+valueList[23]+"')") ;
	    	conn.eval("v <- as.numeric(myList[1, 1:24])") ;
	    	conn.eval("ml <- data.frame(amino = v[1], biotin = v[2], calcium = v[3], collagen = v[4], dietryfiber = v[5],"
	    								+ "gammalinolenic = v[6], iron = v[7], lutein = v[8], magnesium = v[9], milkthistle = v[10],"
	    								+ "mineral = v [11], omega3 = v[12], phosphorus = v[13], probiotic = v[14],"
	    								+ "propolis = v[15], redginseng = v[16], selenium = v[17], vitaminA = v[18], vitaminB = v[19],"
	    								+ "vitaminC = v[20], vitaminD = v[21], vitaminE = v[22], vitaminK = v[23], zinc = v[24])") ;
	    	conn.eval("print(ml)") ;
	    	conn.eval("str(ml)") ;
	    	// conn.eval("ml <- data.frame(amino = valueList[1])") ;
	    	// conn.eval("print(ml") ;
	    	// conn.eval("str(ml)") ;
	    	// conn.eval("myList <- data.frame("+nutriList+" = "+valueList+"") ;
	    	// conn.eval("print(myList)") ;
	    	// conn.eval("pList <- strsplit(pValue, split = '#')") ;
	    	// conn.eval("score <- c(pList[[1]][2], pList[[1]][4], pList[[2]][2], pList[[2]][4], pList[[3]][2]), pList[[3]][4], pList[[4]][2], pList[[4]][4], pList[[5]][2], pList[[5]][4], pList[[6]][2], pList[[6]][4], pList[[7]][2], pList[[7]][4], pList[[8]][2], pList[[8]][4], pList[[9]][2], pList[[9]][4], pList[[10]][2], pList[[10]][4]") ;
	    	// conn.eval("score <- c(pList[[1]][2], pList[[1]][4], pList[[2]][2], pList[[2]][4], pList[[3]][2]), pList[[3]][4], pList[[4]][2], pList[[4]][4], pList[[5]][2], pList[[5]][4], pList[[6]][2], pList[[6]][4], pList[[7]][2], pList[[7]][4], pList[[8]][2], pList[[8]][4], pList[[9]][2], pList[[9]][4], pList[[10]][2], pList[[10]][4]") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return vList ;
    }
    //인선- 설문지 내용 리스트
    @RequestMapping("getBoardList.do")
    public String getBoardList(qDTO dto, Model model) {
    	model.addAttribute("boardList", service.getBoardList(dto));
    	return "/question/getBoardList";
    }
    
    //인선- 설문지 내용 상세화면
    @RequestMapping("getBoard.do")
    public String getBoard(qDTO dto, Model model) {
    	model.addAttribute("board", service.getBoard(dto));
    	return "/question/getBoard";
    }
    
    //인선- 설문지 내용 수정화면
    @RequestMapping("updateBoard.do")
    public String updateBoardView(qDTO dto, Model model) {
    	model.addAttribute("board", service.getBoard(dto));
    	return "/question/updateBoard";
    }
    
    //인선- 설문지 내용 수정Pro
    @RequestMapping("updateBoardPro.do")
    public String updateBoard(qDTO dto) {
    	service.updateBoard(dto);
    	return "redirect:/question/getBoardList.do";
    }
    
    //인선- QUESTION_VALUE 리스트
    @RequestMapping("getValueList.do")
    public String getValueList(vDTO dto, Model model) {
    	model.addAttribute("boardList", service.getValueList(dto));
    	return "/question/getValueList";
    }
    
    //인선- QUESTION_VALUE 상세화면
    @RequestMapping("getValue.do")
    public String getValue(vDTO dto, Model model) {
    	model.addAttribute("board", service.getValue(dto));
    	return "question/getValue";
    }
    
    //인선- QUESTION_VALUE 수정화면
    @RequestMapping("updateValue.do")
    public String updateValueView(vDTO dto, Model model) {
    	model.addAttribute("board", service.getValue(dto));
    	return "/question/updateValue";
    }
    
    //인선- QUESTION_VALUE 수정Pro
    @RequestMapping("updateValuePro.do")
    public String updateValue(vDTO dto) {
    	service.updateValue(dto);
    	return "redirect:/question/getValueList.do";
    }
    
}