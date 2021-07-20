package bean.main;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAOImpl implements MemberDAOInter {
	
	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public int checkId(MemberDTO dto) throws Exception {
		return dao.selectOne("member.checkId", dto);
	}
	
	@Override
	public void join(MemberDTO dto) throws Exception {	
		dao.insert("member.insert", dto);
	}

	@Override
	public void loginLog(MemberDTO dto) throws Exception {
		dao.update("member.loginLog", dto);
		
	}

	@Override
	public void deleteInfo(MemberDTO dto) throws Exception {
		dao.update("member.deleteInfo", dto);
		
	}
}