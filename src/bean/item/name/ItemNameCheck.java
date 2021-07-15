package bean.item.name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class ItemNameCheck {
	
	// path1과 2 사이엔 상품탭 id값을 연결
	// path2와 3 사이엔 페이지 번호 연결
	public static String urlpath1 = "https://search.shopping.naver.com/search/category?catId=";
	public static String urlpath2 = "&frm=NVSHCAT&origQuery&pagingIndex=";
	public static String urlpath3 = "&pagingSize=20&productSet=total&query&sort=rel&timestamp=&viewType=thumb";
	public static RConnection conn= null;
	
	public static void main(String[] args) throws Exception{
		ItemNameCheck check = new ItemNameCheck();
		ItemNameDTO dto = null;
		int [] catIds = check.marketnum();
		
		for(int v : catIds) {
			HashMap markettag = check.marktetag(v);
			String maintag = (String)markettag.get("maintag");
			String subtag = (String)markettag.get("subtag");
			long catId = 50000000 + v;
			RList list = check.itemreward(catId);
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					String [] val = list.at(i).asStrings();
					dto = new ItemNameDTO();
					dto.setName(val[0]);
					dto.setUrl(val[1]);
					dto.setMaintag(maintag);
					dto.setSubtag(subtag);
				}
			}
		}
		/*
		 
		System.out.println("처리시작");
		RList list = check.itemreward(catId);
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				String [] val = list.at(i).asStrings();
				for(String v : val) {
					System.out.println(v + " ");
				}
			}
		}
		
		System.out.println("처리종료");
		*/
	}
	
	// 상품의 catId와 상품명의 갯수를 이용한 상품의 상품명, URL을 가져오는 메서드
	public RList itemreward(long catId) {
		RList item = null;
		long pagenum = pageNumCheck(catId);
		String pageurl = urlpath1+catId+urlpath2;
		System.out.println("try문 진입");
		try {
			conn = new RConnection();
			
			conn.eval("library(rvest)"); 
			conn.eval("item_url <- c(); item_name <- c()");
			conn.eval("pageNum<-"+pagenum+"");
			conn.assign("pageurl",pageurl);
			conn.assign("urlpath3",urlpath3);
			conn.eval("for(i in 1:5){ "
					+ "  url <- paste(pageurl,i,urlpath3, sep=\"\");"
					+ "  for(j in 1:5){"
					+ "    path <- paste(\"ul:nth-child(2) > li:nth-child(\",j,\") > div > div.imgList_title__3yJlT > a\",sep=\"\");"
					+ "    html <- read_html(url);"
					+ "    nodes <- html_nodes(html,path);"
					+ "    text <- html_text(nodes);"
					+ "    link <- html_attr(nodes,'href');"
					+ "    item_url <- c(item_url, link);"
					+ "    item_name <- c(item_name, text);"
					+ "    print(paste(i,\"번째 페이지의 \",j));"
					+ "  }"
					+ "}");
			conn.eval("item <- data.frame(item_name, item_url)");
			conn.eval("print(str(item))");
			item = conn.eval("item").asList();
			System.out.println("try문 종료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return item;
	}
	
	
	
	// 상품명을 찾을 때 사용할 페이지 갯수를 구할 메서드
	public static int pageNumCheck(long catId) {
		int pageNum = 0;
		String pageurl = urlpath1+catId+urlpath2+1+urlpath3;
		try {
		conn = new RConnection();
		
		// 완성한 String 문자 URL로 전달
		conn.assign("url", pageurl);
		conn.eval("library(rvest)"); 
		conn.eval("i<-2; j<-1; item_url <- c(); item_name <- c()");
		conn.eval("html <- read_html(url)");
		conn.eval("nodes <- html_nodes(html, \"div.seller_filter_area > ul > li:nth-child(1) > a > span\")");
		conn.eval("text <- html_text(nodes)");
		conn.eval("text <- gsub(\",\",\"\",text)");
		conn.eval("pageNum <- ceiling(as.numeric(text)/20)");
		
		// 페이지번호 갯수를 가져와 리턴에 사용 될 변수에 대입
		pageNum = conn.eval("pageNum").asInteger();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return pageNum;
	}
	
	// 마켓 카테고리를 list로 리턴해줌..
	public int [] marketnum() {
		int [] listnum = {2425, 2426, 2427, 2428, 2429, 7042, 7043, 7044, 2440, 2441, 2442, 
							2443, 2444, 2445, 2446, 2447, 2448, 2608, 2609, 2610, 2612};			
		return listnum;
	}
	
	// 마켓 카테고리를 비교하여 maintag, subtag를 뽑아내기위한 메서드
	public HashMap marktetag(int catId) {
		HashMap hash = new HashMap();
		String maintag = "";
		String subtag = "";
		switch(catId){
			case 2425 :	maintag = "비타민";subtag = "멀티비타민";break;
			case 2426 :	maintag = "비타민";subtag = "비타민A";break;
			case 2427 :	maintag = "비타민";subtag = "비타민B";break;
			case 2428 :	maintag = "비타민";subtag = "비타민C";break;
			case 2429 :	maintag = "비타민";subtag = "기타비타민";break;
			case 7042 :	maintag = "비타민";subtag = "비타민D";break;
			case 7043 :	maintag = "비타민";subtag = "비타민E";break;
			case 7044 :	maintag = "비타민";subtag = "비오틴";break;
				
			case 2440 :	maintag = "영양제";subtag = "엽산";break;
			case 2441 :	maintag = "영양제";subtag = "아연";break;
			case 2442 :	maintag = "영양제";subtag = "철분";break;
			case 2443 :	maintag = "영양제";subtag = "칼슘";break;
			case 2444 :	maintag = "영양제";subtag = "마그네슘";	break;
			case 2445 :	maintag = "영양제";subtag = "프로폴리스";break;
			case 2446 :	maintag = "영양제";subtag = "글루코사민";break;
			case 2447 :	maintag = "영양제";subtag = "오메가3";break;
			case 2448 :	maintag = "영양제";subtag = "감마리놀렌산";break;
			case 2608 :	maintag = "영양제";subtag = "루테인";break;
			case 2609 :	maintag = "영양제";subtag = "스쿠알렌";break;
			case 2610 :	maintag = "영양제";subtag = "쏘팔메토";break;
			case 2612 :	maintag = "영양제";subtag = "키토산";break;
		}
		hash.put("maintag", maintag);
		hash.put("subtag", subtag);
		return hash;
	}
}
