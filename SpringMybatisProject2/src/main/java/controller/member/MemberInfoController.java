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
import service.member.MemberDelService;
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
	MemberDelService memberDelService;
	
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model, null);
		return "member/memberList";
	}

	@RequestMapping("memInfo/{memId}")
	public String memInfo(@PathVariable(value = "memId") String memId, Model model) {
		memberListService.memList(model, memId);
		return "member/memberInfo";
	}
	
	@RequestMapping("memModify/{memId}") //수정폼 
	public String memModify(@PathVariable(value = "memId") String memId, Model model) {
		memberListService.memList(model, memId);
		return "member/memberModify";
	}
	@RequestMapping(value = "memModifyOk", method = RequestMethod.POST)
	public String memUpdate(MemberCommand memberCommand) { // jsp에서 수정한 내용가져오기...
		memberUpdateService.memUpdate(memberCommand);	
		// 한글 ID 수정이 안되는 상황을 고려하여, 엔코딩 작업		
		String encodedParam="";		
		try {
			encodedParam = URLEncoder.encode(memberCommand.getMemId(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:memInfo/"+encodedParam;
	}
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value = "memId") String memId) {
		memberDelService.memDel(memId);	
		return "redirect:/";
	}
	
}
