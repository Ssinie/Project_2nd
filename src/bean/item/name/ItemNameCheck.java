package bean.item.name;

import org.rosuda.REngine.Rserve.RConnection;

public class ItemNameCheck {
	
	// path1과 2 사이엔 상품탭 id값을 연결
	// path2와 3 사이엔 페이지 번호 연결
	public String urlpath1 = "https://search.shopping.naver.com/search/category?catId=";
	public String urlpath2 = "&frm=NVSHCAT&origQuery&pagingIndex=";
	public String urlpath3 = "&pagingSize=20&productSet=total&query&sort=rel&timestamp=&viewType=thumb";
	
	public static void main(String[] args) {
		long catId = 50002426;
		ItemNameCheck check = new ItemNameCheck(); 
		System.out.println(check.pageNumCheck(catId));
	}
	
	// 상품명을 찾을 때 사용할 페이지 갯수를 구할 메서드
	public int pageNumCheck(long catId) {
		int pageNum = 0;
		String pageurl = urlpath1+catId+urlpath2+1+urlpath3;
		System.out.println(pageurl);
		RConnection conn = null;
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
