package controller.member;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberListService;
import service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberInfoController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	
	
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model,null);
		return "member/memberList";
	}
	@RequestMapping("memInfo/{memId}") // 주소는 뒤에 아이디값 가져오므로 특정할 수 없음
	public String memInfo(@PathVariable(value = "memId") String memId, Model model) { // variable한 aaaaa값을 memId에 저장하자
		memberListService.memList(model,memId);
		return "member/memberInfo";
	}
	@RequestMapping("memMod/{memId}")
	public String memMod(@PathVariable(value = "memId") String memId, Model model) {
		memberListService.memList(model,memId);
		return "member/memberModify";
	}
	@RequestMapping(value = "memModifyOk", method = RequestMethod.POST )
	public String memUpdate(MemberCommand memberCommand) {
		memberUpdateService.memUpdate(memberCommand);
		
		
		String encodedParam = "";
		try {
			encodedParam = URLEncoder.encode(memberCommand.getMemId(),"utf-8");
		} catch (UnsupportedEncodingException e) {		
			e.printStackTrace();
		}
		return "redirect:memInfo/"+encodedParam;
	} // 한글 아이디가 넘어가지 않아서 encoding 다시 해주었음
	
	
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value = "memId") String memId) {
		memberDeleteService.memDel(memId);
		return "redirect:/";
	}
}
