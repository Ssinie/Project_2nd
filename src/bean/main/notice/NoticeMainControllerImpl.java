package bean.main.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.manager.notice.NoticeDTO;
import bean.manager.notice.NoticeServiceImpl;

@Controller
public class NoticeMainControllerImpl implements NoticeMainControllerInter{

	@Autowired
	private NoticeServiceImpl noticeImpl = null;
	
	NoticeDTO dto = new NoticeDTO();
	
	
	// 공지사항 게시글 확인 View 페이지
	@Override
	@RequestMapping("/notice.ns")
	public String board(Model model) {
		
		List list = new ArrayList();
		list = noticeImpl.selectList();
		int count = noticeImpl.selectCount();
		model.addAttribute("count",count);
		model.addAttribute("list", list);
		return "/notice/main_notice";
	}

	// 공지사항 게시글 확인 폼 페이지
	@Override
	@RequestMapping("/form.ns")
	public String form(Model model, int num) {
		dto = noticeImpl.selectForm(num);
		model.addAttribute("dto", dto);
		return "/notice/main_noticeForm";
	}

}
