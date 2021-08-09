package bean.question;

import bean.question.pDTO;
import bean.question.qDTO;
import bean.question.qBeanInter;
import bean.healthy.Criteria;
import bean.healthy.PageMaker;
import bean.item.name.ItemKeyValueDTO;
import bean.item.name.ItemType;
import bean.item.name.ItemTypeDTO;
import bean.manager.ManagerDTO;
import bean.manager.ManagerServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

@Controller
@RequestMapping("/question/")
public class qBean {
	
	@Autowired
	private SqlSession session ;
	@Autowired
	private SqlSessionTemplate sessions ;
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
	public String pInsert(pDTO dto, Model model, HttpServletRequest request) throws Exception{
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
        
        String pNick = request.getParameter("nick") ;
        String pAge = request.getParameter("age") ;
        String pWeight = request.getParameter("weight") ;
        String pheight = request.getParameter("height") ;
        String pGender = request.getParameter("gender") ;
        System.out.println(pNick) ;
        
		return "/question/form" ;
	}
    
    // 설문조사 값 R 로 전송.
    @RequestMapping("qResult.do")
    public String qResult(HttpServletRequest request, vDTO dto, ItemKeyValueDTO ikvDto, ItemTypeDTO itDto, Model model) throws Exception{
    	// form 페이지에서 체크 value 값을 pValue에 vList로 넣는다.
    	String [] pValue = request.getParameterValues("contents") ;
    	List<vDTO> vList =  new ArrayList<vDTO>() ;
    	for(String v : pValue) {
    		System.out.println("----------" + "질문 답변 : " + v + "----------") ;
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
        vMap.put("propolis", 0) ;
        vMap.put("amino", 0) ;
        vMap.put("dietryfiber", 0) ;
        vMap.put("gammalinolenic", 0) ;
    	
    	for(int i = 0 ; i < vList.size(); i++) {
    		dto = vList.get(i) ;
    		if(dto.getNutri01() != null) {
    			int value = 0 ;
    			if(vMap.get(dto.getNutri01()) != null) {
		    		value = vMap.get(dto.getNutri01()) ;
    			}
    		value = value + dto.getVal01() ;
		    vMap.put(dto.getNutri01(), value) ;
    		}
    	}
    	
    	for(int i = 0 ; i < vList.size(); i++) {
    		dto = vList.get(i) ;
    		if(dto.getNutri02() != null) {
    			int value02 = 0 ;
    			if(vMap.get(dto.getNutri02()) != null) {
		    		value02 = vMap.get(dto.getNutri02()) ;
    			}
	        value02 = value02 + dto.getVal02() ;
	        vMap.put(dto.getNutri02(), value02) ;
    		}
    	}

    	System.out.println("선택된 영양소 : " + vMap) ;
    	
    	Object obj[] = vMap.keySet().toArray() ;
        Object val[] = vMap.values().toArray() ;
        String [] nutriList = new String[obj.length] ;
        String [] valueList = new String[val.length] ;
        for(int i = 0 ; i < obj.length ; i ++) {
           nutriList[i] = (String)obj[i];
           valueList[i] = val[i] + "";
        }
        
        // ItemType 클래스의 ReturnValueList 메소드 호출.
        //List 타입으로 호출됨.
        ItemType it = new ItemType() ;
        List resultList = it.ReturnValueList(sessions);
    	
        // List를 배열로 담기.
        String [] ikvList = new String[resultList.size()] ;
        String [][] ikvList02 = new String[resultList.size()][23] ;
        for(int i = 0 ; i < resultList.size() ; i++) {
        	ikvDto = (ItemKeyValueDTO) resultList.get(i) ;
        	ikvList = new String[] {ikvDto.getPRDLST_REPORT_NO() + "", ikvDto.getAmino() + "", ikvDto.getBiotin() + "", ikvDto.getCalcium() + "", ikvDto.getCollagen() + "", ikvDto.getDietryfiber() + "", ikvDto.getGammalinolenic() + "",
					        	ikvDto.getIron() + "", ikvDto.getLutein() + "", ikvDto.getMagnesium() + "", ikvDto.getMilkthistle() + "", ikvDto.getMineral() + "", ikvDto.getOmega3() + "", ikvDto.getProbiotics() + "", ikvDto.getPropolis() + "",
					        	ikvDto.getRedGinseng() + "", ikvDto.getVitaA() + "", ikvDto.getVitaB() + "", ikvDto.getVitaC() + "", ikvDto.getVitaD() + "", ikvDto.getVitaE() + "", ikvDto.getVitaK() + "", ikvDto.getZinc() + ""
					        	} ;
        	ikvList02[i] = ikvList ;
        }
        
        /*
        for(int i = 0 ; i < ikvList02.length ; i++) {
        	System.out.println("데이타 : " + Arrays.toString(ikvList02[i])) ;
        }
        */
        
    	// R 연결 및 data.frame화.
    	RConnection conn ;
    	try {
			conn = new RConnection() ;
			REXP x = conn.eval("R.version.string") ;
	    	// System.out.println("R version : " + x.asString()) ;
			
			String [][] ikvList03 = ikvList02 ;
			// 크롤링 데이터를 데이터 프레임화.
			conn.eval("ikvList <- data.frame(amino = '"+ikvList03[0][1]+"', biotin = '"+ikvList03[0][2]+"', calcium = '"+ikvList03[0][3]+"', collagen = '"+ikvList03[0][4]+"', dietryfiber = '"+ikvList03[0][5]+"', gammalinolenic = '"+ikvList03[0][6]+"', "
	    			+ "iron = '"+ikvList03[0][7]+"', lutein = '"+ikvList03[0][8]+"', magnesium = '"+ikvList03[0][9]+"', milkthistle = '"+ikvList03[0][10]+"', mineral = '"+ikvList03[0][11]+"', omega3 = '"+ikvList03[0][12]+"', "
	    			+ "probiotic = '"+ikvList03[0][13]+"', propolis = '"+ikvList03[0][14]+"', redginseng = '"+ikvList03[0][15]+"', vitaminA = '"+ikvList03[0][16]+"', vitaminB = '"+ikvList03[0][17]+"', "
	    			+ "vitaminC = '"+ikvList03[0][18]+"', vitaminD = '"+ikvList03[0][19]+"', vitaminE = '"+ikvList03[0][20]+"', vitaminK = '"+ikvList03[0][21]+"', zinc = '"+ikvList03[0][22]+"', pro_NO = '"+ikvList03[0][0]+"')") ;
			// conn.eval("rownames(ikvList) <- c('"+ikvList03[0][0]+"')") ;
			
			for(int i = 0 ; i < ikvList03.length ; i++) {
				conn.eval("ikvList02 <- data.frame(amino = '"+ikvList03[i][1]+"', biotin = '"+ikvList03[i][2]+"', calcium = '"+ikvList03[i][3]+"', collagen = '"+ikvList03[i][4]+"', dietryfiber = '"+ikvList03[i][5]+"', gammalinolenic = '"+ikvList03[i][6]+"', "
		    			+ "iron = '"+ikvList03[i][7]+"', lutein = '"+ikvList03[i][8]+"', magnesium = '"+ikvList03[i][9]+"', milkthistle = '"+ikvList03[i][10]+"', mineral = '"+ikvList03[i][11]+"', omega3 = '"+ikvList03[i][12]+"', "
		    			+ "probiotic = '"+ikvList03[i][13]+"', propolis = '"+ikvList03[i][14]+"', redginseng = '"+ikvList03[i][15]+"', vitaminA = '"+ikvList03[i][16]+"', vitaminB = '"+ikvList03[i][17]+"', "
		    			+ "vitaminC = '"+ikvList03[i][18]+"', vitaminD = '"+ikvList03[i][19]+"', vitaminE = '"+ikvList03[i][20]+"', vitaminK = '"+ikvList03[i][21]+"', zinc = '"+ikvList03[i][22]+"', pro_NO = '"+ikvList03[i][0]+"')") ;
				// conn.eval("rownames(ikvList02) <- '"+ikvList03[i][0]+"'") ;
				conn.eval("ikvList <- rbind(ikvList, ikvList02)") ;
			}
			// 형 변환 시 list 오류 나면 unlist로 감싸기.
			conn.eval("ikvList[1:22] <- as.numeric(unlist(ikvList[1:22]))") ;
			conn.eval("print(ikvList)") ;
			conn.eval("str(ikvList)") ;
			
			// 설문조사 값을 데이터 프레임화.
	    	conn.eval("myList <- data.frame(amino = '"+valueList[0]+"', biotin = '"+valueList[1]+"', calcium = '"+valueList[2]+"', collagen = '"+valueList[3]+"', dietryfiber = '"+valueList[4]+"', gammalinolenic = '"+valueList[5]+"', "
	    			+ "iron = '"+valueList[6]+"', lutein = '"+valueList[7]+"', magnesium = '"+valueList[8]+"', milkthistle = '"+valueList[9]+"', mineral = '"+valueList[10]+"', omega3 = '"+valueList[11]+"', "
	    			+ "probiotic = '"+valueList[12]+"', propolis = '"+valueList[13]+"', redginseng = '"+valueList[14]+"', vitaminA = '"+valueList[15]+"', vitaminB = '"+valueList[16]+"', "
	    			+ "vitaminC = '"+valueList[17]+"', vitaminD = '"+valueList[18]+"', vitaminE = '"+valueList[19]+"', vitaminK = '"+valueList[20]+"', zinc = '"+valueList[21]+"')") ;
	    	conn.eval("v <- as.numeric(myList[1, 1:22])") ;
	    	conn.eval("ml <- data.frame(amino = v[1], biotin = v[2], calcium = v[3], collagen = v[4], dietryfiber = v[5],"
	    								+ "gammalinolenic = v[6], iron = v[7], lutein = v[8], magnesium = v[9], milkthistle = v[10],"
	    								+ "mineral = v[11], omega3 = v[12], probiotic = v[13],"
	    								+ "propolis = v[14], redginseng = v[15], vitaminA = v[16], vitaminB = v[17],"
	    								+ "vitaminC = v[18], vitaminD = v[19], vitaminE = v[20], vitaminK = v[21], zinc = v[22])") ;
	    	conn.eval("print(ml)") ;
	    	conn.eval("str(ml)") ;
	    	
	    	// 대망의 knn 회귀 분석!!!
	    	conn.eval("library(class)") ;
	    	// 훈련 데이타.
	    	conn.eval("data01 <- ikvList[ ,c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)]") ;
	    	// 품번 데이타.
	    	conn.eval("data02 <- ikvList[ ,23]") ;
	    	// 조지기. (머신러닝)
	    	conn.eval("result1 <- 0") ;
	    	// conn.eval("result <- knn(data01, ml, data02, k = 3, prob = TRUE)") ;
	    	// conn.eval("result <- as.character(result)") ;
	    	/*
	    	for(int i = 1 ; i < 21 ; i++) {
	    		for(int j = 1 ; j < 6 ; j++) {
	    			conn.eval("result <- knn(data01, ml, data02, k = '"+j+"', prob = TRUE)") ;
	    			conn.eval("result <- as.character(result)") ;
	    			conn.eval("result1 <- c(result1, result)") ;
	    		}
	    	}
	    	*/
	    	conn.eval("for(i in 1:20) {\n"
	    			+ "  for(j in 1:5) {\n"
	    			+ "    result <- knn(data01, ml, data02, k = j, prob = TRUE)\n"
	    			+ "    result <- as.character(result)\n"
	    			+ "    result1 <- c(result1, result)\n"
	    			+ "  }\n"
	    			+ "}") ;
	    	conn.eval("result1 <- result1[-1]") ;
	    	/*
	    	conn.eval("for(i in 1:9){
	    			+ "result01 <- knn(data01, ml, data02, k = i, prob = TRUE)"
	    			+ "}") ;
	    	*/

	    	conn.eval("print(result1)") ;
	    	conn.eval("str(result1)") ;
	    	conn.eval("result1") ;
	    	// List r1 = (List)conn.eval("result1") ;
	    	// System.out.println(r1) ;
	    	/*
	    	// 결과 페이지 최대 3개씩 출력 하고자 3번 작업함.
	    	String result1 = conn.eval("result").asString() ;
	    	String result2 = conn.eval("result02").asString() ;
	    	String result3 = conn.eval("result03").asString() ;
	    	String result4 = conn.eval("result04").asString() ;
	    	String result5 = conn.eval("result05").asString() ;
	    	*/
	    	String rl = conn.eval("result1").asString() ;
	    	String [] rl2 = conn.eval("result1").asStrings() ;
	    	System.out.println("?!?!?" + rl) ;
	    	System.out.println("?!?!?2" + Arrays.toString(rl2)) ;
	    	// 중복값 제거.
	    	List<String> list = new ArrayList<String>() ;
	    	List setList = new ArrayList() ;
	    	for(String v : rl2) {
	    		list.add(v) ;
	    	}
	    	//list.add(result2) ;
	    	//list.add(result3) ;
	    	//list.add(result4) ;
	    	//list.add(result5) ;
	    	
	    	for(String v : list) {
	            System.out.println("중복 = " + v) ;
	         }
	    	// 중복 값 제거 후 리스트에 담기.
	    	System.out.println("====================") ;
	        for(String v : list) {
	        	if(!setList.contains(v)) {
	        		setList.add(v) ;
	        	}
	        }
	        // 중복 값 제거 후 콘솔 출력.
	        for(Object v : setList) {
	        	System.out.println("안중복 = " + v) ;
	        }
	        
	        // 중복 아닌 값들 list인 setList 에서 하나 씩 꺼내서 pResult 쿼리문 적용 후 vl이라는 list에 담기.
	        List<ItemTypeDTO> vl = new ArrayList<ItemTypeDTO>() ;
	        // HashMap<String, String> vMap2 = new HashMap<String, String>() ;
	        
	        for(int i = 0 ; i < setList.size() ; i++) {
	        	itDto = (ItemTypeDTO) setList.get(i);
	        	vl = service.pResult() ;
	        	vDTO dto02 = session.selectOne("question.qValue", v) ;
	        	// vl = (List<ItemTypeDTO>) (service.pResult((ItemTypeDTO) v)) ;
	        	// vMap2.put(r.getPRDLST_NM(), r.getBSSH_NM()) ;
	        	// vl 리스트에 선택된 pResult 쿼리문 적용한 것 담기.
	        	// vl.add(r) ;
	        	
	        	System.out.println("====================\n" + (i + 1) + "번 : " + ((ItemTypeDTO) vl).getPRDLST_NM() + "\n") ;
		    	System.out.println(((ItemTypeDTO) vl).getBSSH_NM() + "\n====================") ;
		    	model.addAttribute("pr", vl) ;
	        }
	        for(Object v : vl) {
	        	System.out.println("vl에 담긴 요소 : " + v) ;
	        }
	        
	        // System.out.println("선택된 영양소 : " + vMap2) ;
	        // Object vn[] = vMap2.keySet().toArray() ;
	        String [] valueNames = new String[vl.size()] ;
	        /* for(int i = 0 ; i < vn.length ; i ++) {
	           valueNames[i] = (String)vn[i] ;
	        } */
	        System.out.println("띠용" + Arrays.toString(valueNames)) ;
	        ArrayList vnList = new ArrayList<>(Arrays.asList(valueNames));
	        for(int i = 0 ; i < vnList.size() ; i++) {
	        	System.out.println("싸그리 몽땅 중2 " + (i + 1) + "번 : " + vnList.get(i)) ;
	        }
	        /*
	        // ??왜 주소??
	        for(int i = 0 ; i < vl.size() ; i++) {
	        	System.out.println("싸그리 몽땅 중 " + (i + 1) + "번 : " + vl.get(i)) ;
	        }
	        */
	        List<Object> nvl = new ArrayList<Object>() ;
	        /*
	        for(int i = 0 ; i < vl.size() ; i++) {
	        	Object v = vl.get(i) ;
	        	System.out.println(v) ;
	        	
	        	Object nv = service.nResult(v) ;
	        	nvl.add(nv) ;
	        	
	        	System.out.println("++++++\n" + (i + 1) + "번 : " + ((ItemNameDTO) nv).getName() + "\n") ;
	        	model.addAttribute("nr", nv) ;
	        }
	        */
	        for(Object v : vl) {
	        	itDto = session.selectOne("question.nResult", v) ;
	        	nvl.add(itDto) ;
	        	System.out.println("nvl" + nvl) ;
	        	// System.out.println("====================\n" + "번 : " + itDto.getName() + "\n") ;
	        	System.out.println("----------" + "솎아낸 것 : " + v + "----------") ;
	        }
	        /*
	        for (int i = 0 ; vl.size() ; i++) { 
	        	System.out.println("vl" + vl.get(i)) ;
	        }
	    	Object[] a = (Object[]) vl.get(i) ;
	    	System.out.println("a" + a) ;
	    	
	    	Object b = service.nResult(a) ;
	    	System.out.println("b" + b) ;
	    	*/
	    	/*
	    	ItemTypeDTO result01 = (ItemTypeDTO)service.pResult(result1) ;
	    	ItemTypeDTO result02 = (ItemTypeDTO)service.pResult(result2) ;
	    	ItemTypeDTO result03 = (ItemTypeDTO)service.pResult(result3) ;
	    	ItemTypeDTO result04 = (ItemTypeDTO)service.pResult(result4) ;
	    	ItemTypeDTO result05 = (ItemTypeDTO)service.pResult(result5) ;
	    	
	    	System.out.println("====================\n" + "1번 : " + result01.getPRDLST_NM() + "\n") ;
	    	System.out.println(result01.getBSSH_NM() + "\n====================") ;
	    	System.out.println("====================\n" + "2번 : " + result02.getPRDLST_NM() + "\n") ;
	    	System.out.println(result02.getBSSH_NM() + "\n====================") ;
	    	System.out.println("====================\n" + "3번 : " + result03.getPRDLST_NM() + "\n") ;
	    	System.out.println(result03.getBSSH_NM() + "\n====================") ;
	    	System.out.println("====================\n" + "4번 : " + result04.getPRDLST_NM() + "\n") ;
	    	System.out.println(result04.getBSSH_NM() + "\n====================") ;
	    	System.out.println("====================\n" + "5번 : " + result05.getPRDLST_NM() + "\n") ;
	    	System.out.println(result05.getBSSH_NM() + "\n====================") ;
	    	
	    	// qResult 페이지로 결과 값 넘기기 저장. model.addAttribute로.
	    	model.addAttribute("pResult01", result01) ;
	    	model.addAttribute("pResult02", result02) ;
	    	model.addAttribute("pResult03", result03) ;
	    	model.addAttribute("pResult04", result04) ;
	    	model.addAttribute("pResult05", result05) ;
	    	*/
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return "/question/qResult" ;
    }
    
    @RequestMapping("aResult.do")
    public String aResult(pDTO dto, Model model) throws Exception {
    	pInsert(dto, model, null) ;
    	model.addAttribute("aResult", service.aResult(dto)) ;
    	return "/question/qResult" ;
    }
    
  //인선- 설문지 내용 리스트
    @RequestMapping("getBoardList.do")
    public String getBoardList(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
    	List<qDTO> list = service.qList(cri);
    	model.addAttribute("boardList", list);
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setCri(cri);
    	pageMaker.setTotalCount(service.qCount());
    	model.addAttribute("pageMaker", pageMaker);
    	return "/question/getBoardList";
    }
    
    //인선- 설문지 내용 상세화면
    @RequestMapping("getBoard.do")
    public String getBoard(qDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
    	model.addAttribute("board", service.getBoard(dto));
    	return "/question/getBoard";
    }
    
    //인선- 설문지 내용 수정화면
    @RequestMapping("updateBoard.do")
    public String updateBoardView(qDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
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
    public String getValueList(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
    	List<vDTO> list = service.vList(cri);
    	model.addAttribute("boardList", list);
    
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setCri(cri);
    	pageMaker.setTotalCount(service.vCount());
    	model.addAttribute("pageMaker", pageMaker);
    	return "/question/getValueList";

    }
    
    //인선- QUESTION_VALUE 상세화면
    @RequestMapping("getValue.do")
    public String getValue(vDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
    	model.addAttribute("board", service.getValue(dto));
    	return "question/getValue";
    }
    
    //인선- QUESTION_VALUE 수정화면
    @RequestMapping("updateValue.do")
    public String updateValueView(vDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
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