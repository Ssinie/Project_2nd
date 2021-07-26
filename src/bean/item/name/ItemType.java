package bean.item.name;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master")
public class ItemType {

	@Autowired
	private SqlSessionTemplate dao = null;
	
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
			
			System.out.println("URL 입력 시작");
			URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/"+key+"/C003/json/51/100");
			
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
				dao.insert("item_type.insert",dto);
				System.out.println(i+"번째 입력종료");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return "/master/ItemTypeCheck";
	}
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
	 * 
	 * 
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
		System.out.println(1);
		ItemTypeDTO dto;
		ItemTypeValueCheckDTO vcdto;
		list = dao.selectList("item_type.selectType");
		System.out.println(2);
		for(int i = 0; i < list.size(); i++) {
			dto = (ItemTypeDTO)list.get(i);
			String [] ele = dto.getRAWMTRL_NM().split(",");
			System.out.println(3);
			if(dto.getELE_COUNT() > 10) {
				dto.setELE_COUNT(10);
				System.out.println(4);
				vcdto = dao.selectOne("item_type.selectVC",dto.getELE_COUNT());
				System.out.println("succes");
			}
			
		}
		
		
		return "/master/ItemTypeCheck";
	}
}
