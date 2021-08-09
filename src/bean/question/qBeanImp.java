package bean.question;

import bean.healthy.Criteria;
import bean.item.name.ItemNameDTO;
import bean.item.name.ItemTypeDTO;
import bean.item.name.ItemTypeValueDTO;
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
	
	@Autowired
	private SqlSessionTemplate mybatis = null ;
	// DAO 지정.
	@Resource(name = "qBean")
    private qBean qBean ;
	
    // 개인정보 입력.
    @Override
    public void pInsert(pDTO dto) throws Exception{
    	mybatis.insert("question.pInsert", dto) ;	
    }
	
	public Object aResult(pDTO dto){
		return mybatis.selectList("question.aResult", dto) ;
	}

	public Object pResult(ItemTypeDTO dto) {
		return mybatis.selectList("question.pResult", dto);
	}
	
	@Override
	public Object nResult(Object result) {
		return mybatis.selectOne("question.nResult", result) ;
	}
	
	@Override
    public List<qDTO> qSelect() throws Exception{return qBean.qSelect();}
    @Override
    public List<qDTO> qSelect02() throws Exception{return qBean.qSelect02();}
    @Override
    public List<qDTO> qSelect03() throws Exception{return qBean.qSelect03();}
    @Override
    public List<qDTO> qSelect04() throws Exception{return qBean.qSelect04();}
    @Override
    public List<qDTO> qSelect05() throws Exception{return qBean.qSelect05();}
    @Override
    public List<qDTO> qSelect06() throws Exception{return qBean.qSelect06();}
    @Override
    public List<qDTO> qSelect07() throws Exception{return qBean.qSelect07();}
    @Override
    public List<qDTO> qSelect08() throws Exception{return qBean.qSelect08();}
    @Override
    public List<qDTO> qSelect09() throws Exception{return qBean.qSelect09();}
    @Override
    public List<qDTO> qSelect10() throws Exception{return qBean.qSelect10();}
    @Override
    public List<qDTO> qSelect11() throws Exception{return qBean.qSelect11();}
    @Override
    public List<qDTO> qSelect12() throws Exception{return qBean.qSelect12();}
    @Override
    public List<qDTO> qSelect13() throws Exception{return qBean.qSelect13();}
    @Override
    public List<qDTO> qSelect14() throws Exception{return qBean.qSelect14();}
    @Override
    public List<qDTO> qSelect15() throws Exception{return qBean.qSelect15();}
    @Override
    public List<qDTO> qSelect16() throws Exception{return qBean.qSelect16();}
    @Override
    public List<qDTO> qSelect17() throws Exception{return qBean.qSelect17();}
    @Override
    public List<qDTO> qSelect18() throws Exception{return qBean.qSelect18();}
    @Override
    public List<qDTO> qSelect19() throws Exception{return qBean.qSelect19();}
    @Override
    public List<qDTO> qSelect20() throws Exception{return qBean.qSelect20();}
    @Override
    public List<qDTO> qSelect21() throws Exception{return qBean.qSelect21();}
    
    public List<qDTO> getBoardList(qDTO dto) {
    	return mybatis.selectList("question.getBoardList", dto);
    }
    
    public qDTO getBoard(qDTO dto) {
    	return mybatis.selectOne("question.getBoard", dto);
    }
	
	public void updateBoard(qDTO dto) {
		mybatis.update("question.updateBoard", dto);
		
	}
	
	public List<vDTO> getValueList(vDTO dto) {
		return mybatis.selectList("question.getValueList", dto);
	}
	
	public vDTO getValue(vDTO dto) {
		return mybatis.selectOne("question.getValue", dto);
	}
	
	public void updateValue(vDTO dto) {
		mybatis.update("question.updateValue", dto);
		
	}
	
	public int qCount() {
		return mybatis.selectOne("question.qCount");
	}
	
	public List<qDTO> qList(Criteria cri) {
		return mybatis.selectList("question.qList", cri);
	}
	
	public int vCount() {
		return mybatis.selectOne("question.vCount");
	}
	
	public List<vDTO> vList(Criteria cri) {
		return mybatis.selectList("question.vList", cri);
	}

	@Override
	public ItemTypeValueDTO resultItemSearch(String no) {
		return mybatis.selectOne("question.resultItemSearch", no);
	}

	@Override
	public int count() {
		return mybatis.selectOne("question.count") ;
	}

	@Override
	public String countOne() {
		return mybatis.selectOne("question.countOne") ;
	}

	@Override
	public List countList() {
		return mybatis.selectList("question.countList") ;
	}

	@Override
	public String countOne02() {
		return mybatis.selectOne("question.countOne02") ;
	}

	@Override
	public List countList02() {
		return mybatis.selectList("question.countList02") ;
	}

	@Override
	public String countOne03() {
		return mybatis.selectOne("question.countOne03") ;
	}

	@Override
	public List countList03() {
		return mybatis.selectList("question.countList03") ;
	}

	@Override
	public String countOne04() {
		return mybatis.selectOne("question.countOne04") ;
	}

	@Override
	public List countList04() {
		return mybatis.selectList("question.countList04") ;
	}

	@Override
	public String countOne05() {
		return mybatis.selectOne("question.countOne05") ;
	}

	@Override
	public List countList05() {
		return mybatis.selectList("question.countList05") ;
	}

	@Override
	public String countOne06() {
		return mybatis.selectOne("question.countOne06") ;
	}

	@Override
	public List countList06() {
		return mybatis.selectList("question.countList06") ;
	}

	@Override
	public String countOne07() {
		return mybatis.selectOne("question.countOne07") ;
	}

	@Override
	public List countList07() {
		return mybatis.selectList("question.countList07") ;
	}

	@Override
	public String countOne08() {
		return mybatis.selectOne("question.countOne08") ;
	}

	@Override
	public List countList08() {
		return mybatis.selectList("question.countList08") ;
	}

	@Override
	public String countOne09() {
		return mybatis.selectOne("question.countOne09") ;
	}

	@Override
	public List countList09() {
		return mybatis.selectList("question.countList09") ;
	}

	@Override
	public String countOne10() {
		return mybatis.selectOne("question.countOne10") ;
	}

	@Override
	public List countList10() {
		return mybatis.selectList("question.countList10") ;
	}
}
