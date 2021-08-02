package bean.item.name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemNameCheck {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	// path1과 2 사이엔 상품탭 id값을 연결
	// path2와 3 사이엔 페이지 번호 연결
	public static String urlpath1 = "https://search.shopping.naver.com/search/category?catId=";
	public static String urlpath2 = "&frm=NVSHCAT&origQuery&pagingIndex=";
	public static String urlpath3 = "&pagingSize=20&productSet=total&query&sort=rel&timestamp=&viewType=thumb";
	public static RConnection conn= null;
	
	@RequestMapping("/Insert.do")
	public String itemInsert() throws Exception {
		ItemNameCheck check = new ItemNameCheck();
		ItemNameDTO dto = null;
		int [] catIds = check.marketnum();
		
		for(int v : catIds) {
			HashMap markettag = check.marktetag(v);
			String maintag = (String)markettag.get("maintag");
			String subtag = (String)markettag.get("subtag");
			long catId = 50000000 + v;
			System.out.println(catId);
			RList list = check.itemreward(catId);
			ArrayList nametag = new ArrayList();
			ArrayList urltag = new ArrayList();
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					String [] val = list.at(i).asStrings();
					if(i == 0) {
						for(String c : val) {
								nametag.add(c);
							}
						}			
					if(i == 1) {
						for(String c : val) {
								urltag.add(c);
							}
						}
				}
				for(int i = 0; i < nametag.size(); i++) {
					dto = new ItemNameDTO();
					dto.setName((String)nametag.get(i));
					dto.setUrl((String)urltag.get(i));
					dto.setMaintag(maintag);
					dto.setSubtag(subtag);
					dto.setImgurl("a");
					System.out.print(i);
					dao.insert("setItem_name",dto);
				}
				System.out.println();
				Thread.sleep(1000);
			}
		}
		return "/main/main";
	}
	/*
	public static void main(String[] args) throws Exception{
		ItemNameCheck check = new ItemNameCheck();
		RList list = check.itemreward(50002425);
		ArrayList<String> nametag = new ArrayList();
		ArrayList urltag = new ArrayList();
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				String [] val = list.at(i).asStrings();
				if(i == 0) {
					for(String v : val) {
							nametag.add(v);
						}
					}			
				if(i == 1) {
					for(String v : val) {
							urltag.add(v);
						}
					}
				}
			}
		for(int c = 0; c < nametag.size(); c++) {
			System.out.println(nametag.get(c));
			System.out.println(urltag.get(c));
			System.out.println();
		}
		
	}
	*/
	
	// 상품의 catId와 상품명의 갯수를 이용한 상품의 상품명, URL을 가져오는 메서드
	public RList itemreward(long catId) throws Exception{
		RList item = null;
		int pagenum = pageNumCheck(catId);
		Thread.sleep(1000);
		System.out.println("페이지 숫자: "+pagenum);
		if(pagenum!= 0) {
			String pageurl = urlpath1+catId+urlpath2;
			if(pagenum > 100) {
				pagenum = 100;
			}
			System.out.println("try문 진입");
			try {
				conn = new RConnection();
				
				conn.eval("library(rvest)"); 
				conn.eval("item_url <- c(); item_name <- c()");
				conn.eval("pageNum<-"+pagenum+"");
				conn.assign("pageurl",pageurl);
				conn.assign("urlpath3",urlpath3);
				conn.eval("for(i in 1:pageNum){ "
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
		}
		return item;
	}
	
	
	
	// 상품명을 찾을 때 사용할 페이지 갯수를 구할 메서드
	// 페이지 URL을 찾아 상품갯수를 구한 뒤 (상품 갯수 / 20) 반올림 하여 페이지 수 를 구함.
	// 간혹 크롤링 중 정보를 가져오지 못하는 경우가 있어, while문을 사용하여 반복하도록 함.
	public static int pageNumCheck(long catId) {
		int pageNum = 0;
		System.out.println("페이지 체크 ID :"+catId);
		String pageurl = urlpath1+catId+urlpath2+1+urlpath3;
		try {
			conn = new RConnection();
			// 완성한 String 문자 URL로 전달
			conn.assign("url", pageurl);
			conn.eval("library(rvest)"); 
			conn.eval("pageNum <- 0");
			conn.eval("while(pageNum == 0){ "
					 +"html <- read_html(url);"
					 +"nodes <- html_nodes(html, \"div.seller_filter_area > ul > li:nth-child(1) > a > span\");"
				 	 +"text <- html_text(nodes);"
					 +"text <- gsub(\",\",\"\",text);"
					 +"pageNum <- ceiling(as.numeric(text)/20);"
					 +"if(length(pageNum) == 0){"
					 +"pageNum <- 0;"
					 +"Sys.sleep(0.5);"
					 +"}"
					 +"}");
				// 페이지번호 갯수를 가져와 리턴에 사용 될 변수에 대입
			pageNum = conn.eval("pageNum").asInteger();
			System.out.print(pageNum);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return pageNum;
	}
	
	// 마켓 카테고리를 list로 리턴해줌..
	public int [] marketnum() {
		int [] listnum = {2425, 2427, 7042, 7043, 7044, 2440, 2441, 2442, 
							2443, 2444, 2445, 2609, 2610, 2612, 2428, 2446, 2447, 2448, 2608, 2426, 2429};
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
	
	/* 동적페이지 크롤링을 위한 셀레니움을 키는 메서드
	 * 아래의 스탭을 참조..
	 * # 동적 크롤링
	 * # -Selenium 웹조작 서버
	 * # -다운로드 : 크롬드라이버
	 * # -드라이버/jar 같은폴더에 넣어둔다.
	 * # ex) d:/r/
	 * 
	 * # cmd 실행
	 * # 드라이버/jar 폴더로 이동
	 * # java   -jar   selenium-server-standalone.jar   -port   4445
	 */
	public void conSelenium(RConnection conn) {
		try {
			conn.eval("library(RSelenium)");
			conn.eval("library(rvest)");
			conn.eval("remDr <- remoteDriver(remoteServerAddr=\"localhost\", port=4445, browserName=\"chrome\")");
			conn.eval("remDr$open()");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 셀레니움 브라우저를 이용한 크롤링
	 * 
	 */
	@RequestMapping("/selenium.do")
	public String seleniumCrolling(Model model) {
		RList item;
		List nametag;
		List urltag;
		List imgtag;
		String catId = "50002426";
		String pageurl = urlpath1+catId+urlpath2;
		
		ItemNameDTO dto;
		try {
			conn = new RConnection();
			conSelenium(conn);
			conn.eval("item_name <- c(); item_url <- c(); item_img <- c();");
			conn.assign("pageurl",pageurl);
			conn.assign("urlpath3",urlpath3);
			conn.eval("for(u in 1:2){"
					+ "  url <- paste(pageurl,u,urlpath3,sep='');"
					+ "  print(paste(\"출력성공1\"));"
					+ "  remDr$navigate(url);"
					+ "  print(paste(\"출력성공2\"));"
					+ "  webNode <- remDr$findElements(using=\"css\",\"#__next > div > div.style_container__1YjHN > div > div.style_content_wrap__1PzEo > div.style_content__2T20F > div.seller_filter_area > div > div.subFilter_sort_box__1r06j > a:nth-child(7)\");"
					+ "  sapply(webNode,function(x){x$clickElement()});"
					+ "  for(k in 1:13){"
					+ "    remDr$executeScript(paste(\"scrollTo(\",k*400,\",\",(k*400)+400,\")\"));Sys.sleep(0.6);}"
					+ "  Sys.sleep(0.3);"
					+ "  html <- remDr$getPageSource()[[1]];"
					+ "  Sys.sleep(0.3);"
					+ "  html <- read_html(html);"
					+ "  for(i in 2:16){"
					+ "    for(j in 1:5){"
					+ "      path <- paste(\"ul:nth-child(\",i,\") > li:nth-child(\",j,\") > div > div.imgList_title__3yJlT > a\");"
					+ "      imgPath <- paste(\"ul:nth-child(\",i,\") > li:nth-child(\",j,\") > div.thumbnail_thumb_wrap__1pEkS._wrapper > a > img\");"
					+ "      nodes <- html_nodes(html,path);"
					+ "      img_nodes <- html_nodes(html,imgPath);"
					+ "      text <- html_text(nodes);"
					+ "      link <- html_attr(nodes,'href');"
					+ "      img <- html_attr(img_nodes,'src');"
					+ "      item_name <- c(item_name,text);"
					+ "      item_url <- c(item_url, link);"
					+ "      item_img <- c(item_img,img);}}}");
			conn.eval("item <- data.frame(item_name, item_url, item_img)");
			item = conn.eval("item").asList();
			
			if(item != null) {
				List itemIndex = new ArrayList();
				nametag = new ArrayList();
				urltag = new ArrayList();
				imgtag = new ArrayList();
				for(int i = 0; i < item.size(); i++) {
					String [] val = item.at(i).asStrings();
					if(i == 0) {for(String c : val) {nametag.add(c);}}			
					if(i == 1) {for(String c : val) {urltag.add(c);}}
					if(i == 2) {for(String c : val) {imgtag.add(c);}}
				}
				dto = new ItemNameDTO();
				for(int i = 0; i < nametag.size(); i++) {
					dto.setName((String)nametag.get(i));
					dto.setUrl((String)urltag.get(i));
					dto.setImgurl((String)imgtag.get(i));
					itemIndex.add(dto);
				}
				model.addAttribute("list",itemIndex);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return "/master/ItemNameInput";
	}
}