package bean.healthy;


import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("crawling")
@RequestMapping("/healthy/")
public class CrawlingController {
	@Autowired
	private CrawlingService crawlingService;
	
	@RequestMapping("crawling.ns")
	public String insertNaver() {

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
			conn.eval(" sysdate_url <- paste(base_url, '&page=', sep=format(Sys.Date()-2,'%Y%m%d'))");
			conn.eval(" urls <- NULL ");
			conn.eval(" for (x in 0:10){ "
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
			
			
			conn.eval(" naverImage <- NULL ");
			conn.eval(" for(url in news_links){ "
					+ " htmlz <- read_html(url); "
					+ " a <- html_nodes(htmlz, '.end_photo_org > img:nth-child(1)')[1]; "
					+ " if(length(a) == 0){ "
					+ " naverImage <- c(naverImage, '이미지없음'); "
					+ " } "
					+ " else if(length(a) > 0){ "
					+ " naverImage <- c(naverImage, html_attr(a , 'src')); "
					+ " } "
					+ " }"); 
			
			conn.eval(" Title <- NULL ");
			conn.eval(" for (link in news_links){ "
					+ " html <- read_html(link); "
				    + " Title <- c(Title, html %>% html_nodes('#articleTitle') %>% "  //여기 연결 연산자는 ; 세미콘론 하지마. ^^ 종료한다는 뜻이라서
				    + " html_text()); "
				    + " } ");
			conn.eval(" title <- as.data.frame(Title) ");
			conn.eval(" article_url <- as.data.frame(news_links) ");
			conn.eval(" naverImage_url <- as.data.frame(naverImage) ");
			conn.eval(" news <- cbind(title,article_url,naverImage_url) ");
			RList news = conn.eval("news").asList();
			
			String [] title = news.at(0).asStrings();
			String [] url = news.at(1).asStrings();
			String [] imageUrl = news.at(2).asStrings();
			
			CrawlingDTO a = new CrawlingDTO();
			crawlingService.deleteAll(a);
			CrawlingDTO dto = new CrawlingDTO();
			for(int x = 0; x < title.length; x++) {
				dto.setNaverTitle(title[x]);
				dto.setNaverUrl(url[x]);
				dto.setImageUrl(imageUrl[x]);
				crawlingService.insertTitleUrl(dto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		//return "/healthy/getBoardList";
		return "redirect:/healthy/getBoardList.ns"; 
	}
	
	@RequestMapping("deleteAll.ns")
	public String deleteAll(CrawlingDTO dto) {
		crawlingService.deleteAll(dto);
		System.out.println("삭제버튼 눌름" + dto);
		return "redirect:/healthy/getBoardList.ns";
	}

	
}
