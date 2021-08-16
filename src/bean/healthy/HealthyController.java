package bean.healthy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



//http://localhost:8080/Project_2nd/healthyTip.ns
@Controller
@SessionAttributes("board")
@RequestMapping("/healthy/")
public class HealthyController {	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("healthyTip.ns")
	public String home() {
		//System.out.println("main()");
		return "/healthy/home";
	}
	
	@RequestMapping("insertBoardV.ns")
	public String insertBoardView() {
		//System.out.println("main()");
		return "/healthy/insertBoardPro";
	}
	
	@RequestMapping("insertBoard.ns")
	public String insertBoard(HealthyDTO dto) {
		boardService.insertBoard(dto);
		System.out.println("입력"+ dto);
		//return "/healthy/getBoardList";
		return "redirect:/healthy/healthyBoardList.ns"; 
	}
	
	
	@RequestMapping("updateBoardV.ns")
	public String updateBoardView(HealthyDTO dto) {
		return "/healthy/updateBoardPro";
	}
	
	
	@RequestMapping("updateBoard.ns")
	public String updateBoard(@ModelAttribute("board") HealthyDTO dto) {
		boardService.updateBoard(dto);
		//return "getBoardList.ns";
		return "redirect:/healthy/healthyBoardList.ns";
	}
	
	@RequestMapping("deleteBoard.ns")
	public String deleteBoard(HealthyDTO dto) {
		boardService.deleteBoard(dto);
		System.out.println("삭제버튼 눌름" + dto);
		return "redirect:/healthy/healthyBoardList.ns";
	}
	
	@RequestMapping("getBoard.ns")
	public String getBoard(HealthyDTO dto, Model model) {
		model.addAttribute("board", boardService.getBoard(dto));
		System.out.println("get보드클릭" + dto);
		return "/healthy/getBoard";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> serchConditionMap()	{
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	/*
	@RequestMapping("getBoardList.ns")
	public String getBoardList(HealthyDTO dto, Model model)	{
		model.addAttribute("boardList", boardService.getBoardList(dto));
		return "/healthy/getBoardList";
	}
	*/
	
	@RequestMapping("getBoardList.ns")
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) {
		List<HealthyDTO> list = boardService.listPage(cri);
		model.addAttribute("boardList", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.count());
		model.addAttribute("pageMaker", pageMaker);
		return "/healthy/getBoardList";
	}
	
	@RequestMapping("healthyBoardList.ns")
	public String healthyBoardList(@ModelAttribute("cri") Criteria cri, Model model) {
		List<HealthyDTO> list = boardService.listPage(cri);
		model.addAttribute("boardList", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.count());
		model.addAttribute("pageMaker", pageMaker);
		return "/healthy/healthyBoardList";
	}
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping("getlist.ns")
	public String getList(Model model) throws Exception {
		List<HealthyDTO> allList = healthydao.selectBoard();
		model.addAttribute("allList", allList);
		System.out.println(allList);
		return "/healthy/list";
	}
	*/
	
}
