package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.MemberCommand;
import service.member.MemberMyPageInfoModifyService;
import service.member.MemberMyPageInfoService;

@Controller
@RequestMapping("MemMyPage")
public class MemberMyPageController {

	@Autowired
	MemberMyPageInfoService memberMyPageInfoService;
	@Autowired
	MemberMyPageInfoModifyService memberMyPageInfoModifyService;
	
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memMyPage";
	}
	
	@RequestMapping("memMyPageInfo")
	public String memMyPageInfo(Model model, HttpSession session) {
		memberMyPageInfoService.memMyPageInfo(model,session);
		return "member/memMyPageInfo";
	}
	@RequestMapping("memMyPageInfoModify")
	public String memMyPageInfoModify(Model model, HttpSession session, @ModelAttribute MemberCommand memberCommand) {
		memberMyPageInfoService.memMyPageInfo(model,session);
		return "member/memMyPageModify";
	}
	@RequestMapping("memMyPageInfoModifyOk")
	public String memMyPageInfoModifyOk() {
		memberMyPageInfoModifyService.memMypageInfoUpdate();
		return "";
	}
}
