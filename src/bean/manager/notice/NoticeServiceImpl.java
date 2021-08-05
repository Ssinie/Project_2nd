package bean.manager.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import bean.manager.ManagerDTO;

public class NoticeServiceImpl implements NoticeServiceInter{

	@Autowired
	private SqlSessionTemplate mybatis = null;
	
	// 공지사항의 모든 게시글을 리스트로 리턴
	@Override
	public List selectList() {
		List list = mybatis.selectList("noticeSQL.selectNotice");
		return list;
	}
	
	// 공지사항의 게시글 수를 int로 리턴
	@Override
	public int selectCount() {
		int count = mybatis.selectOne("noticeSQL.selectCount");
		return count;
	}
	
	// 공지사항의 게시글을 눌럿을 때의 게시글 내용 리턴
	@Override
	public NoticeDTO selectForm(int num) {
		NoticeDTO dto = mybatis.selectOne("noticeSQL.selectNum",num);
		return dto;
	}

	// 공지사항의 게시글을 작성했을 때의 insert (성공 1, 실패 0)
	@Override
	public int insertNotice(NoticeDTO dto) {
		int result = mybatis.insert("noticeSQL.insertNotice",dto);
		return result;
	}

	// 공지사항의 게시글을 수정했을 때의 update (성공 1, 실패 0)
	@Override
	public int updateNotice(NoticeDTO dto) {
		int result = mybatis.update("noticeSQL.updateNotice", dto);
		return result;
	}

	// 공지사항의 게시글을 삭제했을 때의 delete (성공 1, 실패 0)
	@Override
	public int deleteNotice(int num) {
		int result = mybatis.delete("noticeSQL.deleteNotice",num);
		return result;
	}

	@Override
	public int checkAcount(ManagerDTO dto) {
		int result = mybatis.selectOne("ManagerDTOResult.loginCheck",dto);
		return result;
	}



	

}
