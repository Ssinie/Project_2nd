package bean.healthy;

import java.util.HashMap;
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
		//return "/healthy/getBoardList";
		return "redirect:/getBoardList.ns"; 
	}
	
	
	@RequestMapping("updateBoardV.ns")
	public String updateBoardView(HealthyDTO dto) {
		return "/healthy/updateBoardPro";
	}
	
	
	@RequestMapping("updateBoard.ns")
	public String updateBoard(HealthyDTO dto) {
		boardService.updateBoard(dto);
		//return "getBoardList.ns";
		return "redirect:/getBoardList.ns";
	}
	
	@RequestMapping("deleteBoard.ns")
	public String deleteBoard(HealthyDTO dto) {
		boardService.deleteBoard(dto);
		return "redirect:/getBoardList.ns";
	}
	
	@RequestMapping("getBoard.ns")
	public String getBoard(HealthyDTO dto, Model model) {
		model.addAttribute("board", boardService.getBoard(dto));
		return "/healthy/getBoard";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> serchConditionMap()	{
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("getBoardList.ns")
	public String getBoardList(HealthyDTO dto, Model model)	{
		model.addAttribute("boardList", boardService.getBoardList(dto));
		return "/healthy/getBoardList";
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
