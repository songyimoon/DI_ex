package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemMypageInfoModifyOkService;
import service.member.MemberMyPageInfoService;
import service.member.MemberOutService;
import service.member.MemberPwUpdateService;
import service.member.MemberPwConfirmService;
import validator.MemberPasswordValidator;

@Controller
@RequestMapping("edit")
public class MemberMyPageController {

	@Autowired
	MemberMyPageInfoService memberMyPageInfoService;
	@Autowired
	MemMypageInfoModifyOkService memMypageInfoModifyOkService;
	@Autowired
	MemberPwConfirmService memberPwConfirmService;
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
	@Autowired
	MemberOutService memberOutService;
	
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memMyPage";
	}	
	@RequestMapping("memMyPageInfo")
	public String memMyPageInfo(HttpSession session, Model model) {
		memberMyPageInfoService.memberMyPageInfo(model, session);
		return "member/memMyPageInfo";
	}
	@RequestMapping("memMypageInfoModify")
	public String memMypageInfoModify(HttpSession session, Model model, @ModelAttribute MemberCommand memberCommand) {
		memberMyPageInfoService.memberMyPageInfo(model, session);
		return "member/memMypageInfoModify";
	}
	@RequestMapping(value = "memMypageInfoModifyOk", method = RequestMethod.POST)
	public String memMypageInfoModifyOk(HttpSession session, MemberCommand memberCommand, Errors errors) {
		memMypageInfoModifyOkService.memMypageInfoModifyOk(session, memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memMypageInfoModify";
		}
		return "member/memMyPageInfo";		
	}
	@RequestMapping("memPwChange")
	public String memPwChange() { 
		return "member/memPwChange"; // memPwChange -> 현재 비밀번호를 확인하는 페이지로 이동시킨다.
	}
	@RequestMapping("memPwChangeOk")
	public String memPwChangeOk(@RequestParam (value = "memPw") String memPw, HttpSession session, Model model, @ModelAttribute MemberCommand memberCommand) { //@ModelAttribute()가 붙은 객체는 Model객체에 자동으로 추가된다.
		String path = memberPwConfirmService.memPw(memPw,session,model); // 컨펌 서비스에서 비밀번호가 틀리는지 여부에 따라 return을 다르게 해주는 메서드를 실행한다.
		// 비밀번호가 일치하면 현재비밀번호와 변경비밀번호, 변경비밀번호확인을 입력할 수 있는 2번 페이지로 이동시키고, 일치하지 않으면 다시 현재 비밀번호 확인하는 1번 페이지로 이동
		return path;
	}
	@RequestMapping("memPwChangeOk2")
	public String memPwChangeOk2(MemberCommand memberCommand, Errors errors, HttpSession session) {
		new MemberPasswordValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memPwChangeOk";
		}
		memberPwUpdateService.memPwUpdate(session, memberCommand, errors);
		
		if(errors.hasErrors()) {
			return "member/memPwChangeOk";
		}
		return "redirect:/";
	}
	
	@RequestMapping("memOut")
	public String memOut() {
		return "member/memOut";
	}
	@RequestMapping("memOutOk")
	public String memOutOk(@RequestParam (value = "memPw") String memPw, HttpSession session, Model model) {
		String path=memberOutService.memDel(memPw, session, model);
		return path;
	}
	
	
}
