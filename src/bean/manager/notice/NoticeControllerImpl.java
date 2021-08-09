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
	public String board(Model model) {
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
	public String writeFormPro(NoticeDTO dto, Model model) {
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		int result = noticeImpl.insertNotice(dto);
		model.addAttribute("result", result);
		return "/notice/writeFormPro";
	}

	// 공지사항 게시글 작성 or 수정 처리 페이지
	@Override
	@RequestMapping("/updateForm.do")
	public String updateForm(int num, Model model) {
		dto = noticeImpl.selectForm(num);
		model.addAttribute("dto",dto);
		return "/notice/updateForm";
	}
	
	// 공지사항 게시글 작성 or 수정 처리 페이지 
	@Override
	@RequestMapping("/updateFormPro.do")
	public String updatePro(NoticeDTO dto, Model model) {
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		int result = noticeImpl.updateNotice(dto);
		model.addAttribute("result", result);
		return "/notice/updateFormPro";
	}

	// 공지사항 게시글 삭제 페이지
	@Override
	@RequestMapping("/deleteForm.do")
	public String deleteForm(Model model, int num) {
		model.addAttribute("num", num);
		return "/notice/deleteForm";
	}

	// 공지사항 게시글 삭제 처리 페이지
	@Override
	@RequestMapping("/deleteFormPro.do")
	public String deleteFormPro(Model model, int num, String id, String password) {
		ManagerDTO dto = new ManagerDTO();
		dto.setId(id);
		dto.setPassword(password);
		int result = noticeImpl.checkAcount(dto);
		if(result == 1) {
			result = noticeImpl.deleteNotice(num);
		}
		model.addAttribute("result", result);
		return "/notice/deletePro";
	}


	

	

}
