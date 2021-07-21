package bean.myPage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageDAOImpl implements MyPageDAOInter {

	@Autowired
	private SqlSessionTemplate dao = null;
	
}
