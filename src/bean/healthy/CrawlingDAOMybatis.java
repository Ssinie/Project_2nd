package bean.healthy;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 데이터베이스 연동을 처리하는 DAO 클래스
public class CrawlingDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void insertTitleUrl(CrawlingDTO dto) {
		mybatis.insert("crawling.insertTitleUrl", dto);
	}
	
}
