package bean.item.name;

import java.util.ArrayList;
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
		long catId = 50002426;
		ItemNameCheck check = new ItemNameCheck(); 
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
}
