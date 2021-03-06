package rjava;

import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class ConnR {

	public static void main(String[] args) {
		RConnection conn = null;
		try {
			conn = new RConnection();
			System.out.println(conn); 
			conn.eval(".libPaths('e:\\\\library\\\\r')");
			conn.eval(" library(hflights) ");
			conn.eval(" library(httr) ");
			conn.eval(" library(rvest) ");
			conn.eval(" library(RSelenium) ");
			conn.eval(" library(dplyr) ");
			conn.eval(" library(stringr) ");
			conn.eval(" base_url <- 'https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=241&sid1=103&date=' ");
			conn.eval(" sysdate_url <- paste(base_url, '&page=', sep=format(Sys.Date(),'%Y%m%d'))");
			conn.eval(" urls <- NULL ");
			conn.eval(" for (x in 0:6){ "
					+ " urls <- c(urls, paste(sysdate_url,x+1,sep = '')); "
					+ " } ");
			conn.eval(" news_links <- NULL ");
			conn.eval(" for(url in urls){ "
					+ " html <- read_html(url); "
					+ " news_links <- c(news_links, html %>% "
					+ " html_nodes('ul>li>dl>dt>a') %>% "
					+ " html_attr('href')); "
					+ " } ");
			conn.eval(" news_links <- unique(news_links) ");
			conn.eval(" Title <- NULL ");
			conn.eval(" for (link in news_links){ "
					+ " html <- read_html(link); "
				    + " Title <- c(Title, html %>% html_nodes('#articleTitle') %>% "  //여기 연결 연산자는 ; 세미콘론 하지마. ^^ 종료한다는 뜻이라서
				    + " html_text()); "
				    + " } ");
			conn.eval(" title <- as.data.frame(Title) ");
			conn.eval(" article_url <- as.data.frame(news_links) ");
			conn.eval(" news <- cbind(title,article_url) ");
			RList news = conn.eval("news").asList();
			for(int x = 0; x < news.size(); x++) {
				String [] val = news.at(x).asStrings();
				for(String v : val) {
					System.out.println(v+" ");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

}

