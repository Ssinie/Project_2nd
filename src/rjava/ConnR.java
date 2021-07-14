package rjava;

import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class ConnR {

	public static void main(String[] args) {
		RConnection conn = null;
		try {
			conn = new RConnection();
			System.out.println(conn);
			/*conn.eval("library(httr)");
			conn.eval("library(RSelenium)"); */
			conn.eval("library(rvest)");
			/*conn.eval("base_url <- 'https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=241&sid1=103&date=20210712&page='");
			conn.eval("urls <- NULL");
			conn.eval("for (x in 0:6){"
					+ "urls <- c(urls, paste(base_url,x+1,sep = ''));"
					+ "}");
			conn.eval("news_links <- NULL");
			conn.eval("for (url in urls){"
					+ "html <- read_html(url);"
					+ "news_links <- c(news_links, html %>%;"
					+ "html_nodes('ul>li>dl>dt>a') %>%;"
					+ "html_attr('href'));"
					+ "}");
			conn.eval("news_links <- unique(news_links)");
			conn.eval("Title <- NULL");
			conn.eval("for (link in news_links){"
					+ "html <- read_html(link);"
				    + "Title <- c(Title, html %>% html_nodes('#articleTitle') %>%;"
				    + "html_text());"
				    + "Sys.sleep(time = 0.5);"   
				    + "}");
			conn.eval("title <- as.data.frame(Title)");
			conn.eval("article_url <- as.data.frame(news_links)");
			conn.eval("news <- cbind(title,article_url)");
			RList news = conn.eval("news").asList();
			for(int x = 0; x < news.size(); x++) {
				String [] val = news.at(x).asStrings();
				for(String v : val) {
					System.out.println(v+" ");
				}
				System.out.println();
			} */
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

}

