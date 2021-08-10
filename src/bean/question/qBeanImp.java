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
	public int count(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.count", resultDto) ;
	}

	@Override
	public String countOne(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne", resultDto) ;
	}

	@Override
	public List countList(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList", resultDto) ;
	}

	@Override
	public String countOne02(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne02", resultDto) ;
	}

	@Override
	public List countList02(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList02",resultDto) ;
	}

	@Override
	public String countOne03(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne03", resultDto) ;
	}

	@Override
	public List countList03(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList03", resultDto) ;
	}

	@Override
	public String countOne04(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne04", resultDto) ;
	}

	@Override
	public List countList04(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList04", resultDto) ;
	}

	@Override
	public String countOne05(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne05", resultDto) ;
	}

	@Override
	public List countList05(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList05", resultDto) ;
	}

	@Override
	public String countOne06(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne06", resultDto) ;
	}

	@Override
	public List countList06(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList06", resultDto) ;
	}

	@Override
	public String countOne07(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne07", resultDto) ;
	}

	@Override
	public List countList07(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList07", resultDto) ;
	}

	@Override
	public String countOne08(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne08", resultDto) ;
	}

	@Override
	public List countList08(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList08", resultDto) ;
	}

	@Override
	public String countOne09(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne09", resultDto) ;
	}

	@Override
	public List countList09(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList09", resultDto) ;
	}

	@Override
	public String countOne10(ItemTypeValueDTO resultDto) {
		return mybatis.selectOne("question.countOne10", resultDto) ;
	}

	@Override
	public List countList10(ItemTypeValueDTO resultDto) {
		return mybatis.selectList("question.countList10", resultDto) ;
	}
}
