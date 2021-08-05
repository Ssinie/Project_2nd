package bean.manager.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import bean.manager.ManagerDTO;

public interface NoticeControllerInter {
	
	/* 관리 페이지의 공지사항의 인터페이스 구축을 위한 파일
	 * 
	 */
	
	// 공지사항 게시글 확인 페이지
	public String board(Model model);
	
	// 공지사항 게시글 확인 폼 페이지
	public String form(Model model, int num);
	
	// 공지사항 게시글 작성 폼 페이지
	public String writeForm(Model model);
	
	// 공지사항 게시글 처리 페이지
	public String writeFormPro(NoticeDTO dto, Model model);
	
	// 공지사항 게시글 수정 페이지
	public String updateForm(int num);
	
	// 공지사항 게시글 작성 or 수정 처리 페이지 
	public String updatePro(NoticeDTO dto, Model model);
	
	// 공지사항 게시글 삭제 페이지
	public String deleteForm(int num);
	
	// 공지사항 게시글 삭제 처리 페이지
	public String deleteFormPro(Model model, int num, String id, String password);
}
