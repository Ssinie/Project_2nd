package bean.item.name;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
			URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/"+key+"/C003/json/1/100");
			
			BufferedReader bf;
			System.out.println("bf에 담음");
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	
			result = bf.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			System.out.println("jsonObject = "+jsonObject);
			JSONObject itemTypeResult = (JSONObject)jsonObject.get("C003");
			System.out.println("itemTypeResult = "+itemTypeResult);
			JSONArray itemArray = (JSONArray)itemTypeResult.get("row");
			System.out.println("itemResult = "+itemArray);		
	
			for(int i =0; i <= itemArray.size(); i++) {
				JSONObject itemInfo = (JSONObject)itemArray.get(i);
				dto = new ItemTypeDTO();
				dto.setLCNS_NO((int)itemInfo.get("LCNS_NO"));
				dto.setPRMS_DT((int)itemInfo.get("PRMS_DT"));
				dto.setPRDLST_REPORT_NO((int)itemInfo.get("PRDLST_REPORT_NO"));
				dto.setCRET_DTM((int)itemInfo.get("CRET_DTM"));
				dto.setLAST_UPDT_DTM((int)itemInfo.get("LAST_UPDT_DTM"));
				dto.setBSSH_NM((String)itemInfo.get("BSSH_NM"));
				dto.setPRDLST_NM((String)itemInfo.get("PRDLST_NM"));
				dto.setNTK_MTHD((String)itemInfo.get("NTK_MTHD"));
				dto.setRAWMTRL_NM((String)itemInfo.get("RAWMTRL_NM"));
				dto.setPOG_DAYCNT((String)itemInfo.get("POG_DAYCNT"));
				dto.setPRIMARY_FNCLTY((String)itemInfo.get("PRIMARY_FNCLTY"));
				dto.setCSTDY_MTHD((String)itemInfo.get("CSTDY_MTHD"));
				dto.setIFTKN_ATNT_MATR_CN((String)itemInfo.get("IFTKN_ATNT_MATR_CN"));
				dto.setSTDR_STND((String)itemInfo.get("STDR_STND"));
				dto.setDISPOS((String)itemInfo.get("DISPOS"));
				dto.setSHAP((String)itemInfo.get("SHAP"));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return "item/insert";
	}
}
