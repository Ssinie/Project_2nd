package bean.manager.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class NoticeServiceImpl implements NoticeServiceInter{

	private SqlSessionTemplate mybatis = null;
	
	// 공지사항의 모든 게시글을 리스트로 리턴
	@Override
	public List selectList() {
		List list = mybatis.selectList("");
		return list;
	}
	
	// 공지사항의 게시글을 눌럿을 때의 게시글 내용 리턴
	@Override
	public NoticeDTO selectForm(int num) {
		NoticeDTO dto = mybatis.selectOne("",num);
		return dto;
	}

	// 공지사항의 게시글을 작성했을 때의 insert (성공 1, 실패 0)
	@Override
	public int insertNotice(NoticeDTO dto) {
		int result = mybatis.insert("",dto);
		return result;
	}

	// 공지사항의 게시글을 수정했을 때의 update (성공 1, 실패 0)
	@Override
	public int updateNotice(NoticeDTO dto) {
		int result = mybatis.update("", dto);
		return result;
	}

	// 공지사항의 게시글을 삭제했을 때의 delete (성공 1, 실패 0)
	@Override
	public int deleteNotice(int num) {
		int result = mybatis.delete("",num);
		return result;
	}

}
