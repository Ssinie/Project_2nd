package bean.manager.notice;

public interface NoticeControllerInter {
	
	/* 관리 페이지의 공지사항의 인터페이스 구축을 위한 파일
	 * 
	 */
	
	// 공지사항 게시글 확인 페이지
	public String board();
	
	// 공지사항 게시글 내용 확인 페이지
	public String content();
	
	// 공지사항 게시글 작성 or 수정 폼 페이지
	public String form();
	
	// 공지사항 게시글 작성 or 수정 처리 페이지 
	public String updatePro();
	 
}
