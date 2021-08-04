package bean.manager.notice;

import java.util.List;

public interface NoticeServiceInter {
	
	/* 관리 페이지의 공지사항에서 사용할 쿼리문을 처리하기 위한 파일
	 * 
	 */
	
	// 공지사항의 모든 게시글을 리스트로 리턴
	public List selectList();
	
	// 공지사항의 게시글을 눌럿을 때의 게시글 내용 리턴
	public NoticeDTO selectForm(int num); // 리턴 DTO
	
	// 공지사항의 게시글을 작성했을 때의 insert
	public int insertNotice(NoticeDTO dto);
	
	// 공지사항의 게시글을 수정했을 때의 update
	public int updateNotice(NoticeDTO dto);
	
	// 공지사항의 게시글을 삭제했을 때의 delete
	public int deleteNotice(int num);
	
}