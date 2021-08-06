package bean.main.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import bean.manager.notice.NoticeDTO;
import bean.manager.notice.NoticeServiceImpl;

public interface NoticeMainControllerInter {
	
	// 공지사항 게시글 확인 View 페이지
	public String board(Model model);
	
	// 공지사항 게시글 확인 폼 페이지
	public String form(Model model, int num);
}
