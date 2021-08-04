package bean.manager.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.manager.ManagerDTO;
import bean.manager.ManagerService;

@Controller
@RequestMapping("/manager")
public class NoticeControllerImpl implements NoticeControllerInter{

	@Autowired
	private NoticeServiceImpl noticeImpl = null;
	
	NoticeDTO dto = new NoticeDTO();
	
	// 공지사항 게시글 확인 페이지
	@Override
	@RequestMapping("/board.do")
	public String board(Model model, HttpServletRequest request) {
		// String result = "/managerLogin";
		// HttpSession session = request.getSession();
		// ManagerDTO mem = (ManagerDTO)session.getAttribute("mem");

		List list = new ArrayList();
		list = noticeImpl.selectList();
		int count = noticeImpl.selectCount();
		model.addAttribute("count",count);
		model.addAttribute("list", list);
		
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
	public String form(Model model, int num) {
		dto = noticeImpl.selectForm(num);
		model.addAttribute("dto", dto);
		return "/notice/form";
	}
	
	// 공지사항 게시글 작성 폼 페이지
	@Override
	@RequestMapping("/writeForm.do")
	public String writeForm(Model model) {
		
		return "/notice/writeForm";
	}
	
	// 공지사항 게시글 처리 페이지
	@Override
	@RequestMapping("/writeFormPro.do")
	public String writeFormPro(NoticeDTO dto, Model model, HttpServletRequest request) {
		System.out.println(1);
		int result = noticeImpl.insertNotice(dto);
		String url = board(model, request);
		return url;
	}

	// 공지사항 게시글 작성 or 수정 처리 페이지
	@Override
	@RequestMapping("/updateForm.do")
	public String updateForm(int num) {
		dto = noticeImpl.selectForm(num);
		return "/notice/updateForm";
	}

	@Override
	@RequestMapping("/deleteForm.do")
	public String deleteForm(int num) {
		// TODO Auto-generated method stub
		return "/notice/deleteForm";
	}

	@Override
	public String updatePro() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
