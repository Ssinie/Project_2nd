package bean.question;

import bean.question.pDTO;
import bean.question.qDTO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("qBeanInter")
@Repository
public class qBeanImp implements qBeanInter{
	
	// DAO 지정.
	@Resource(name = "qBean")
    private qBean qBean ;
	
	@Override
    public List<qDTO> qSelect() throws Exception{
        return qBean.qSelect();
    }
}
