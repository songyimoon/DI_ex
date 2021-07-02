package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@RequestMapping ("agree")
	public String agree() {
		return "member/agree";
	}
	
	@RequestMapping (value = "memRegist", method = RequestMethod.POST)
	public String memRegist(
				@RequestParam (value="agree", defaultValue = "false") Boolean agree) {
		if(!agree) return "member/agree"; // 변화는 없지만 url은 바뀜
		return "member/memberForm";
	}	
	@RequestMapping (value = "memJoin", method = RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand) {
		memberJoinService.memJoin(memberCommand);
		return "redirect:main";
	}
	
}
