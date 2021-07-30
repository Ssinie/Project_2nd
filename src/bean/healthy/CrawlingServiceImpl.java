package bean.healthy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("crawlingService")
public class CrawlingServiceImpl implements CrawlingService{
	
	@Autowired
	private CrawlingDAOMybatis crawlingDAOmybatis;

	public void insertTitleUrl(CrawlingDTO dto) {
		crawlingDAOmybatis.insertTitleUrl(dto);
	}

	public void deleteAll(CrawlingDTO dto) {
		crawlingDAOmybatis.deleteAll(dto);
		
	}

	
	
}
