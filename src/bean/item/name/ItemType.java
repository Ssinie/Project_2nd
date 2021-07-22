package bean.item.name;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ItemType {

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
	 * LCNS_NO	인허가번호
	 * BSSH_NM	업소명
	 * PRDLST_REPORT_NO	품목제조번호
	 * PRDLST_NM	품목명
	 * PRMS_DT	보고일자
	 * POG_DAYCNT	유통기한
	 * DISPOS	성상
	 * NTK_MTHD	섭취방법
	 * PRIMARY_FNCLTY	주된기능성
	 * IFTKN_ATNT_MATR_CN	섭취시주의사항
	 * CSTDY_MTHD	보관방법
	 * SHAP	형태
	 * STDR_STND	기준규격
	 * RAWMTRL_NM	원재료
	 * CRET_DTM	최초생성일시
	 * LAST_UPDT_DTM	최종수정일시
	 */
	
	public static void main(String[] args) {
		String key = "287bd69b5be34b4ead96";
		String result = "";
		try {
			
		System.out.println("URL 입력 시작");
		URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/"+key+"/C003/json/1/1");
		
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
		/*
		itemInfo.get("NTK_MTHD");
		itemInfo.get("PRDLST_NM");
		itemInfo.get("RAWMTRL_NM");
		itemInfo.get("PRMS_DT");
		itemInfo.get("CRET_DTM");
		itemInfo.get("POG_DAYCNT");
		itemInfo.get("PRDLST_REPORT_NO");
		itemInfo.get("PRIMARY_FNCLTY");
		itemInfo.get("CSTDY_MTHD");
		itemInfo.get("BSSH_NM");
		itemInfo.get("LAST_UPDT_DTM");
		itemInfo.get("LCNS_NO");
		itemInfo.get("IFTKN_ATNT_MATR_CN");
		itemInfo.get("STDR_STND");
		itemInfo.get("DISPOS");
		itemInfo.get("SHAP");
		*/
		JSONObject itemInfo = (JSONObject)itemArray.get(0);
		System.out.println(itemInfo.get("NTK_MTHD"));
		System.out.println(itemInfo.get("PRDLST_NM"));
		System.out.println(itemInfo.get("RAWMTRL_NM"));
		System.out.println(itemInfo.get("PRMS_DT"));
		System.out.println(itemInfo.get("CRET_DTM"));
		System.out.println(itemInfo.get("POG_DAYCNT"));
		System.out.println(itemInfo.get("PRDLST_REPORT_NO"));
		System.out.println(itemInfo.get("PRIMARY_FNCLTY"));
		System.out.println(itemInfo.get("CSTDY_MTHD"));
		System.out.println(itemInfo.get("BSSH_NM"));
		System.out.println(itemInfo.get("LAST_UPDT_DTM"));
		System.out.println(itemInfo.get("LCNS_NO"));
		System.out.println(itemInfo.get("IFTKN_ATNT_MATR_CN"));
		System.out.println(itemInfo.get("STDR_STND"));
		System.out.println(itemInfo.get("DISPOS"));
		System.out.println(itemInfo.get("SHAP"));
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void main() {
		
	}
}
