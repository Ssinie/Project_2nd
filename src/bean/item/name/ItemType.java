package bean.item.name;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.manager.ManagerDTO;
import bean.manager.ManagerServiceImpl;

@Controller
@RequestMapping("/master")
public class ItemType {

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@RequestMapping("item.do")
	public String item(HttpServletRequest request, HttpServletResponse response) {
    	ManagerServiceImpl ma = new ManagerServiceImpl();
    	ma.sessionChk(request, response);
    	
		return"/master/Item";
	}
	
	
	/* '데이터 활용 서비스' 사이트의 '건강기능식품 품목제조신고(원재료) OpenAPI' 를 이용하여 DB에 저장하는 클래스.
	 * www.foodsafetykorea.go.kr
	 * OpenAPI에서 허가받은 key를 URL 페이지에 연결하여 관련된 내용을 JSON 형태로 가져온다.
	 * 
	 * URL 구성 방식
	 * 'https://openapi.foodsafetykorea.go.kr/api/'인증키/서비스명/요청파일타입/요청시작위치/요청종료위치
	 * 인증 키 = 287bd69b5be34b4ead96
	 * API의 서비스 명 = C003
	 * 요청 가능 파일 타입 = xml / JSON 
	 * 
	 * 요청완료시의 출력값의 정보
	 * - ItemTypeDTO.java 주석 참조
	 */	
	@RequestMapping("/iteminsert.do")
	public String ItemTypeInsert() {
		String key = "287bd69b5be34b4ead96";
		String result = "";
		ItemTypeDTO dto = null;
		try {
			// dao.delete("item_type.deleteItemType");
			for(int j = 350; j <= 500; j++) {
				int StartNum = (j * 10) + 1;
				int EndNum = (j * 10) + 10;
				System.out.println("URL 입력 시작");
				URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/"+key+"/C003/json/"+StartNum+"/"+EndNum);
				
				BufferedReader bf;
				System.out.println("bf에 담음");
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
				result = bf.readLine();
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
				JSONObject itemTypeResult = (JSONObject)jsonObject.get("C003");
				JSONArray itemArray = (JSONArray)itemTypeResult.get("row");
				String [] count;
				List arr;
				int searchCount;
				for(int i =0; i < itemArray.size(); i++) {
					JSONObject itemInfo = (JSONObject)itemArray.get(i);
					arr = new ArrayList();
					dto = new ItemTypeDTO();
					dto.setLCNS_NO(itemInfo.get("LCNS_NO").toString());
					dto.setPRMS_DT(itemInfo.get("PRMS_DT").toString());
					dto.setPRDLST_REPORT_NO(itemInfo.get("PRDLST_REPORT_NO").toString());
					dto.setCRET_DTM(itemInfo.get("CRET_DTM").toString());
					dto.setLAST_UPDT_DTM(itemInfo.get("LAST_UPDT_DTM").toString());
					dto.setBSSH_NM(itemInfo.get("BSSH_NM").toString());
					dto.setPRDLST_NM(itemInfo.get("PRDLST_NM").toString());
					dto.setNTK_MTHD(itemInfo.get("NTK_MTHD").toString());
					dto.setRAWMTRL_NM(itemInfo.get("RAWMTRL_NM").toString());
					dto.setPOG_DAYCNT(itemInfo.get("POG_DAYCNT").toString());
					dto.setPRIMARY_FNCLTY(itemInfo.get("PRIMARY_FNCLTY").toString());
					dto.setCSTDY_MTHD(itemInfo.get("CSTDY_MTHD").toString());
					dto.setIFTKN_ATNT_MATR_CN(itemInfo.get("IFTKN_ATNT_MATR_CN").toString());
					dto.setSTDR_STND(itemInfo.get("STDR_STND").toString());
					dto.setDISPOS(itemInfo.get("DISPOS").toString());
					dto.setSHAP(itemInfo.get("SHAP").toString());
					
					count = dto.getRAWMTRL_NM().split(",");
					for(String v : count) {
						arr.add(v);
					}
					dto.setELE_COUNT(arr.size());
					searchCount = dao.selectOne("item_type.SearchTypeCount",dto.getPRDLST_REPORT_NO());
					if(searchCount == 0) {
						dao.insert("item_type.insert",dto);
						System.out.println(i+"번째 입력종료");
					}
			}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return "/master/ItemListInput";
	}
	
	/* 개발용 관리페이지의 Controller
	 * 페이지를 불러올 때 'ITEM_TYPE' 테이블의 테이블 정보를 가져와
	 * 표를 이용해 정보를 노출시켜준다.
	 */
	@RequestMapping("/itemtype.do")
	public String ItemTypeSelect(Model model) {
		List list = null;
		list = dao.selectList("item_type.selectType");
		
		model.addAttribute("list",list);
		return "/master/ItemTypeCheck";
	}
	
	/* 
	 * 제품정보의 성분이 겹치지 않는 항목이 몇종류인지를 파악하기 위해 만든
	 * ITEM_TYPE 테이블의 RAWMTRL_NA의 정보를 CSV파일로 변환해주는 메서드
	 * System.lineSeparator(); > 줄바꿈(\n)
	 */	
	@RequestMapping("/itemTypeCSVWrite.do")
	public String ItemTypeCSVWrite() {
		
		String filePath = "C:/Users/Yoo/Desktop/BIG_DATA/10. 문서/Table/csv_demo.csv";
		
		File file = null;
		BufferedWriter bw = null;
		List list = null;
		String NEWLINE = System.lineSeparator();
		
		try {
			file = new File(filePath);
			bw = new BufferedWriter(new FileWriter(file));
			ItemTypeDTO dto = new ItemTypeDTO();
			
			String [] splitText;
			ArrayList<String> arr = new ArrayList<String>();
			List<String> result = new ArrayList<String>();
			
			
			// DB에서 제품정보를 가져와서 텍스트를 split하여 arr에 하나씩 List로 담음
			list = dao.selectList("item_type.selectType");
			for(int i =0; i < list.size(); i++) {
				dto = (ItemTypeDTO)list.get(i);
				splitText = dto.getRAWMTRL_NM().split(",");
				for(String v : splitText) {
					arr.add(v);
					}
				}
			// arr에 있는 하나씩담긴 내용을 중복검사하여 하나씩 다시 담음
			for(String v : arr) {
				if(!result.contains(v)) {
					result.add(v);
				}
			}
			// 하나씩 담은 내용을 csv파일에 하나씩 입력함
			for(int i=0; i < result.size(); i++) {
				String v = result.get(i);
				bw.write(v);
				bw.write(NEWLINE);
			}
			
			
			
			bw.flush();
			bw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/master/ItemTypeCheck";
	}
	
	/* 제품정보의 성분이 겹치지 않는 항목을 'ITEM_TYPE_KEY' 테이블에 추가하는 메서드 
	 * DB에서 제품정보를 가져와서 텍스트를 split하여 arr에 하나씩 List로 담음
	 * arr에 있는 하나씩담긴 내용을 중복검사하여 하나씩 다시 담음
	 * 하나씩 담은 내용을 'ITEM_TYPE_KEY' 테이블에 하나씩 입력함
	 */
	@RequestMapping("/ItemTypeKeyInsert.do")
	public String ItemTypeKeyInsert() {
		
		List list = null;
		ArrayList<String> arr = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		HashMap hash = new HashMap();
		String [] splitText;
		
		try {
			ItemTypeDTO dto = new ItemTypeDTO();
			dao.delete("item_type.deleteItemTypeKey");
			list = dao.selectList("item_type.selectType");
			for(int i =0; i < list.size(); i++) {
				dto = (ItemTypeDTO)list.get(i);
				splitText = dto.getRAWMTRL_NM().split(",");
				for(String v : splitText) {
					arr.add(v);
					}
				}
			for(String v : arr) {
				if(!result.contains(v)) {
					result.add(v);
				}
			}
			for(int i=0; i < result.size(); i++) {
				String v = result.get(i);
				hash.put("num", i+1);
				hash.put("element", v);
				dao.insert("item_type.type_insert", hash);
				System.out.println(i+1+"번째 삽입 완료");
			}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/master/ItemTypeCheck";
	}
	
	/*
	 * ITEM_TYPE 테이블의 정보를 가져와, 원재료 성분의 갯수를 확인하고, 갯수에 따른 가중치를 ITEM_TYPE_VALUECHECK 를 참고하여
	 * ITEM_TYPE_VALUE 테이블에 가중치 별 테이블 정보를 기재한다.
	 * ITEM_TYPE 테이블의 유니크 값의 컬럼명은 'PRDLST_REPORT_NO' 이다. 
	 * 
	 * 작업순서...
	 * 1. 'ITEM_TYPE' 테이블의 내용을 DTO에 담은 LIST를 받는다.
	 * 2. LIST에서 하나씩 빼서 dto를 가지고 원재료 갯수를 가져온다.
	 * 3. dto에서 원재료를 split해서 배열로 담는다.
	 * 4. 원재료 갯수가 10개초과일 경우 값을 10으로 대입
	 * 5. 원재료 갯수로 'ITEM_TYPE_VALUECHECK' 테이블에서 select 한다.
	 * 6. split 한 배열을 반복하되
	 * 6-1. 'ITEM_TYPE_KEY' 테이블에서 key 값을 찾고,
	 * 6-2. 'ITEM_TYPE_VALUECHECK' 테이블에서 배열 위치에 따라 val값을 찾는다.
	 * 6-3. 찾은 key, value값을 테이블에 insert해준다.
	 * 6-4. 반복...
	 */
	@RequestMapping("/ItemTypeValueInsert.do")
	public String ItemTypeValueInsert() {
		List list = new ArrayList();
		ItemTypeDTO dto;
		ItemTypeValueCheckDTO vcdto;
		ItemTypeValueDTO vdto;
		String [] ele;
		String element;
		Integer itemNum;
		list = dao.selectList("item_type.selectType");
		
		dao.delete("item_type.deleteItemTypeValue");
		
		for(int i = 0; i < list.size(); i++) {
			vcdto = new ItemTypeValueCheckDTO();
			dto = (ItemTypeDTO)list.get(i);
			ele = dto.getRAWMTRL_NM().split(",");
			if(dto.getELE_COUNT() > 10) {
				dto.setELE_COUNT(10);
				}
			vcdto = dao.selectOne("item_type.selectVC",dto.getELE_COUNT());
			vdto = new ItemTypeValueDTO();
			vdto.setPRDLST_REPORT_NO(dto.getPRDLST_REPORT_NO());
			
			
			for(int v = 0; v < dto.getELE_COUNT(); v++) {
				element = ele[v];
				itemNum = dao.selectOne("item_type.SelectKey", element);
				if(itemNum == null) {
					v = 100;
				}
				switch(v) {
					case 0: vdto.setKey_1(itemNum);vdto.setValue_1(vcdto.getVal1());break;
					case 1: vdto.setKey_2(itemNum);vdto.setValue_2(vcdto.getVal2());break;
					case 2: vdto.setKey_3(itemNum);vdto.setValue_3(vcdto.getVal3());break;
					case 3: vdto.setKey_4(itemNum);vdto.setValue_4(vcdto.getVal4());break;
					case 4: vdto.setKey_5(itemNum);vdto.setValue_5(vcdto.getVal5());break;
					case 5: vdto.setKey_6(itemNum);vdto.setValue_6(vcdto.getVal6());break;
					case 6: vdto.setKey_7(itemNum);vdto.setValue_7(vcdto.getVal7());break;
					case 7: vdto.setKey_8(itemNum);vdto.setValue_8(vcdto.getVal8());break;
					case 8: vdto.setKey_9(itemNum);vdto.setValue_9(vcdto.getVal9());break;
					case 9: vdto.setKey_10(itemNum);vdto.setValue_10(vcdto.getVal10());break;
					case 100: break;
				}
			}
			dao.insert("item_type.insertValue",vdto);
			System.out.println(i+" 번째 Susses");
		}
		
		
		return "/master/ItemTypeCheck";
	}
	
	/*
	 * 1. 'ITEM_TYPE_VALUE' 테이블을 참조하되,
	 * 2. 호재님에게 받은 nutrist.csv 파일의 영양성분 컬럼명을 'ITEM_TYPE_KEY'에서 고유명사의 문구를 찾는다...
	 * 3. 메서드를 작성하여 고유명사를 이용해서 key를 찾도록 하고, 그에 맞는 'ITEM_TYPE_VALUE' 테이블의 값을 가져와, 표 형식의 LIST를 만든다.
	 * 4. 이 때 표에는 유니크 제조번호 값, 영양성분 24개의 컬럼이 있어야한다.
	 * 
	 * 1. 'ITEM_TYPE_VALUE' 테이블 값을 LIST로 가져온다.
	 * 2. 
	 */
	
	@RequestMapping("/RetrunValueLists.do")
	public String RetrunValueLists(Model model) {
		List result = ReturnValueListat(dao);
		ItemKeyValueDTO ikvDto;
		for(int i = 0; i < result.size(); i++) {
			ikvDto = (ItemKeyValueDTO)result.get(i);
			dao.insert("item_type.InsertItemTypeKeyValue",ikvDto);
		}
		model.addAttribute("result",result);
		return "/master/ItemListInput";
	}
	
	
	/* 설문에서 제품의 표준편차를 List로 받아가기 위해 만든 메서드
	 * 설문에서 해당 메서드를 호출하면 return 값으로 List를 반환하여
	 * 전달하여 준다. List 인덱스엔 'ItemKeyValueDTO' 형식의 dto가
	 * 입력되어 전달된다.
	 */
	public List ReturnValueListat(SqlSessionTemplate dao) {
		ItemTypeValueDTO itvdto;
		ItemKeyValueDTO ikvdto;
		KeyNumberCheck(dao);
		List list = dao.selectList("item_type.selectTypeValue");
		List result = new ArrayList();
		for(int i = 0; i < list.size(); i++) {
			itvdto = (ItemTypeValueDTO)list.get(i);
			ikvdto = new ItemKeyValueDTO();
			
			ikvdto = dtoFactoring(itvdto, dao);
			ikvdto.setPRDLST_REPORT_NO(itvdto.getPRDLST_REPORT_NO());
			
			result.add(ikvdto);
		}
		return result;
	}
	
	public List ReturnValueList(SqlSessionTemplate dao) {
		List list = null;
		list = dao.selectList("item_type.SelectItemKeyValue");
		return list;
	}
	
	// 전달받은 DTO정보를 이용하여 case에 맞춰 'ItemKeyValueDTO'에 정보를 담음.
	public ItemKeyValueDTO dtoFactoring(ItemTypeValueDTO itvdto, SqlSessionTemplate dao) {
		ItemKeyValueDTO ikvdto = new ItemKeyValueDTO();
		Integer count;
		Integer index;
		List arr;
		for(int i = 1; i <= 10; i ++) {
			System.out.println("품번 : "+itvdto.getPRDLST_REPORT_NO()+" "+i+"번째 값 찾는중..");
			switch(i) {
				case 1 : 
					if(itvdto.getKey_1() != 0) {int key = itvdto.getKey_1();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_1(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_1(), ikvdto, index);}}break;
						
				case 2 : 
					if(itvdto.getKey_2() != 0) {int key = itvdto.getKey_2();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_2(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_2(), ikvdto, index);}}break;
						
				case 3 : 
					if(itvdto.getKey_3() != 0) {int key = itvdto.getKey_3();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_3(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_3(), ikvdto, index);}}break;
						
				case 4 : 
					if(itvdto.getKey_4() != 0) {int key = itvdto.getKey_4();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_4(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_4(), ikvdto, index);}}break;
						
				case 5 : 
					if(itvdto.getKey_5() != 0) {int key = itvdto.getKey_5();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_5(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_5(), ikvdto, index);}}break;
						
				case 6 : 
					if(itvdto.getKey_6() != 0) {int key = itvdto.getKey_6();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_6(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_6(), ikvdto, index);}}break;
						
				case 7 : 
					if(itvdto.getKey_7() != 0) {int key = itvdto.getKey_7();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_7(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_7(), ikvdto, index);}}break;
						
				case 8 : 
					if(itvdto.getKey_8() != 0) {int key = itvdto.getKey_8();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_8(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_8(), ikvdto, index);}}break;
						
				case 9 : 
					if(itvdto.getKey_9() != 0) {int key = itvdto.getKey_9();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_9(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_9(), ikvdto, index);}}break;
						
				case 10 : 
					if(itvdto.getKey_10() != 0) {int key = itvdto.getKey_10();
					count = dao.selectOne("item_type.SearchKeysFindCount", key);
					if(count > 1) {
						arr = dao.selectList("item_type.SearchKeysFindIndex", key);
						for(int j = 0; j < arr.size(); j++) {
							index = (Integer)arr.get(j);
							switchIndex(itvdto.getValue_10(), ikvdto, index);}
					}else {
						index = dao.selectOne("item_type.SearchKeysFindIndex", key);
						switchIndex(itvdto.getValue_10(), ikvdto, index);}}break;		
				default : break;
			}
		}
		return ikvdto;
	}
	
	
	/* 인덱스 정보를 지역변수로 받아, 
	 * 인덱스에 맞는 'ItemKeyValueDTO' 클래스에 해당하는 벨류값을 더해준다.
	 */
	public void switchIndex(double values, ItemKeyValueDTO ikvdto, Integer index) {
		if(index != null) {
			switch(index) {
			case 1 : ikvdto.addVitaA(values);break;
			case 2 : ikvdto.addVitaB(values);break;
			case 3 : ikvdto.addVitaC(values);break;
			case 4 : ikvdto.addVitaD(values);break;
			case 5 : ikvdto.addVitaE(values);break;
			case 6 : ikvdto.addVitaK(values);break;
			case 7 : ikvdto.addOmega3(values);break;
			case 8 : ikvdto.addLutein(values);break;
			case 9 : ikvdto.addProbiotics(values);break;
			case 10 : ikvdto.addCalcium(values);break;
			case 11 : ikvdto.addCollagen(values);break;
			case 12 : ikvdto.addRedGinseng(values);break;
			case 13 : ikvdto.addMagnesium(values);break;
			case 14 : ikvdto.addMineral(values);break;
			case 15 : ikvdto.addZinc(values);break;
			case 16 : ikvdto.addBiotin(values);break;
			case 17 : ikvdto.addMilkthistle(values);break;
			case 18 : ikvdto.addIron(values);break;
			case 19 : ikvdto.addPropolis(values);break;
			case 20 : ikvdto.addAmino(values);break;
			case 21 : ikvdto.addDietryfiber(values);break;
			case 22 : ikvdto.addGammalinolenic(values);break;
			default : System.out.println("해당없음");break;
			}
		}
	}
	
	// dto 받아와서 key검사해서 참조테이블로 확인해야함.. 
	// 정제작업을 마치고 return값을 ItemKeyValueDTO 로 전달해준다..
	// key값이 0이 아니면,  
	public ItemKeyValueDTO KeyCheck(ItemTypeValueDTO dto) {
		ItemKeyValueDTO ikvDto = null;
		if(dto.getKey_1() != 0) {
			dto.getKey_1();
		}
		
		return ikvDto;
	}
	
	// item_search_key 테이블의 key값을 넣어주는 작업...
	public void KeyNumberCheck(SqlSessionTemplate dao) {
		HashMap searchDto;
		Integer count;
		List list;
		List eleList;
		String indexed;
		dao.delete("item_type.deleteSearchKeys");
		list = dao.selectList("item_type.SearchKeyFind");
		for(int i =0; i < list.size(); i++) {
			searchDto = (HashMap)list.get(i);
			count = dao.selectOne("item_type.SearchKeyCount",searchDto.get("SEARCHSTRING"));
			indexed = searchDto.get("INDEXED").toString();
			if(count > 1) {
				eleList = dao.selectList("item_type.SearchKeyLike",searchDto.get("SEARCHSTRING"));
				for(int l = 0; l < eleList.size(); l++) {
					searchDto = (HashMap)eleList.get(l);
					searchDto.put("INDEXED", indexed);
					dao.insert("item_type.InsertItem_Search_Keys",searchDto);
				}
			}else if(count == 1){
				searchDto = dao.selectOne("item_type.SearchKeyLike",searchDto.get("SEARCHSTRING"));
				searchDto.put("INDEXED", indexed);
				dao.insert("item_type.InsertItem_Search_Keys",searchDto);
			}else {
				System.out.println("-------null-------");
				System.out.println(searchDto);
				System.out.println("-------null끝-------");
			}
		}
	}
}
