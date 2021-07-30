package bean.manager;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("manager")
@RequestMapping("/manager/")
public class ManagerController {
   @Autowired
   private ManagerService managerService;
   
   @RequestMapping("hello.ns")
   public String test() {
	   return"/manager/test";
   }
   
   
    @RequestMapping("register.ns")
    public String getRegister() { 
       return "/manager/register";
   }
    
   
   @RequestMapping("registerPro.ns")
   public String postRegister(ManagerDTO dto, HttpServletRequest request) {
      managerService.register(dto);
      request.setAttribute("setmanager", dto);
      System.out.println("registerPro.ns 실행" + dto);
      
      return "/manager/registerPro";
      //return "redirect:/managerLogin.ns";
      //return "redirect:/registerPro.ns";
   }
   
   
   @RequestMapping("managerLogin.ns")
   public String managerLogin( ) {
      return "/manager/managerLogin";
   }
      
   @RequestMapping("loginCheck.ns")
   public String loginCheck(ManagerDTO dto, Model model, HttpServletRequest request) {
	  HttpSession session = request.getSession();
	  ManagerDTO loginCheck = managerService.loginCheck(dto);
	  System.out.println("입력 데이터" + dto);
	  System.out.println("null판단" + loginCheck);
	  if(loginCheck == null) {
		  session.setAttribute("mem", null);
		  session.setAttribute("msg", false);	
		  return "redirect:/manager/managerLogin.ns";
	  }else {
		  session.setAttribute("mem", loginCheck);
		  session.setMaxInactiveInterval(1000);
		  return "redirect:/manager/getManagerList.ns";
	  }
	  
	  
   
   }
   
   @RequestMapping("managerlogout.ns")
   public String managerlogout(HttpSession session) {   
      session.invalidate();
      return "redirect:/manager/getManagerList.ns";
   }
   
   @RequestMapping("getManager.ns")
   public String getManager(ManagerDTO dto, Model model) {
      System.out.println(dto+"1번");
      model.addAttribute("manager", managerService.getManager(dto));
      System.out.println(dto+"2번");
      return "/manager/getBoard";
   }
   
   @RequestMapping("getManagerList.ns")
   public String getBoardList(ManagerDTO dto, Model model) {
      model.addAttribute("boardList", managerService.getBoardList(dto));
      return "/manager/getBoardList";
   }
   
   @RequestMapping("updateManagerV.ns")
   public String updateManagerV(ManagerDTO dto) {
      return "/manager/updateManager";
   }
   
   @RequestMapping("updateManager.ns")
   public String updateManager(@ModelAttribute("manager") ManagerDTO dto)   {
      managerService.updateManager(dto);
      return "redirect:/manager/getManagerList.ns";
   }
   
   @RequestMapping("exManager.ns")
   public String ex(@Param("id") String id, ManagerDTO dto, HttpSession session) {
	   managerService.exUpdate(dto); //99 -> 90
	   System.out.println("ex업데이트!!!!" + dto);
	   managerService.exInsert(dto); 
	   System.out.println("테이블복사" + dto);
	   managerService.exDelete(dto);
	   System.out.println("기존데이터삭제" + dto);
	   session.invalidate();
	   return "redirect:/manager/getManagerList.ns";
   }
   
   //아이디중복체크 결과가 1이면 중복아이디있음(현재 admin 아이디만 있음), 0이면 중복아이디 없음
   // @ResponseBody 는 String 만 리턴 가능.. 오카이? 넵!!ㅜㅜ 감사합니다ㅜ
   
   @RequestMapping("idChk.ns")
   public @ResponseBody String idChk(ManagerDTO dto ,HttpServletRequest request) {
	   System.out.println(dto.getId());
	   int result = managerService.idChk(dto);
	   System.out.println(result);
	   return result+"";
   }
   
   
   @RequestMapping("pwUpdateV.ns")
   public String pwupdateV(ManagerDTO dto) {
	   System.out.println(dto);
	   return "/manager/pwUpdate";
   }
   
   
   @RequestMapping("pwUdate.ns")
   public String pwUdate(ManagerDTO dto, HttpSession session) {
	   System.out.println(dto.getId());
	   managerService.pwUdate(dto);
	   System.out.println("비밀번호 변경" + dto);
	   session.invalidate();
	   return "/manager/managerLogin";
   }
   
   

}