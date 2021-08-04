package bean.manager.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class NoticeControllerImpl implements NoticeControllerInter{

	// 공지사항 게시글 확인 페이지
	@Override
	@RequestMapping("/board.do")
	public String board() {
		// TODO Auto-generated method stub
		return "/notice/board";
	}

	// 공지사항 게시글 내용 확인 페이지
	@Override
	@RequestMapping("/content.do")
	public String content() {
		// TODO Auto-generated method stub
		return "/notice/content";
	}

	// 공지사항 게시글 작성 or 수정 폼 페이지
	@Override
	@RequestMapping("/form.do")
	public String form() {
		// TODO Auto-generated method stub
		return "/notice/form";
	}

	// 공지사항 게시글 작성 or 수정 처리 페이지
	@Override
	@RequestMapping("/updateForm.do")
	public String updatePro() {
		// TODO Auto-generated method stub
		return "/notice/updateForm";
	}

}
