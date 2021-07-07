package bean.question;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bean.question.qDTO ;

@Service
public class qBeanImp implements qBeanInter{
	
	@Autowired
	private SqlSessionTemplate mybatis = null ;
	
	@Override
	public void qInsert(qDTO dto) throws Exception {
		mybatis.insert("question.insert", dto) ;
	}
}
