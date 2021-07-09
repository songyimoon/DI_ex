package controller.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import model.AuthInfoDTO;
import service.main.LoginService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import validator.MemberCommandValidator;

@Controller
@RequestMapping("register")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping(value = "memRegist", method = RequestMethod.POST) // jsp에 post방식으로 되어있음
	public String memRegist(@RequestParam (value = "agree", defaultValue = "false") Boolean agree, MemberCommand memberCommand) { // agree를 체크했으면 agree값이 날아오고, 아니면 false가 날아옴, 파라미터는 O,X개념이므로 boolean을 사용한다.
		if(!agree) return "member/agree"; // false이면 다시 agree페이지로 보내고
		return "member/memberForm"; // 그렇지 않으면 (true) memberForm으로 보낸다.
	}
	
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "memJoin", method = RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand, Errors errors, Model model) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
		AuthInfoDTO authInfo = loginService.login(memberCommand.getMemId(), memberCommand.getMemPw());
		if(authInfo != null) {
			errors.rejectValue("memId", "duplicate");
			return "member/memberForm";
		}				
		memberJoinService.memJoin(memberCommand);
		return "redirect:memList";

	}
}
