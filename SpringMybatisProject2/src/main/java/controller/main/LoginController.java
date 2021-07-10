package controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import service.main.LoginService;
import validator.LoginCommandValidator;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "redirect:/";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String login(LoginCommand loginCommand, Errors errors, HttpSession session) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) { // 이 에러는 로그인 창에서 내용을 입력 했느냐 아니냐의 문제 * Validator에서 찾기
			return "main/main";
		}
		loginService.login1(loginCommand, errors, session);
		if(errors.hasErrors()) { // 이 에러는 회원정보에 ID가 있는지, 비밀번호가 일치하는지의 문제 * LoginService에서 찾기
			return "main/main";
		}
		return "redirect:/";
	} 
	
	@RequestMapping("logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
