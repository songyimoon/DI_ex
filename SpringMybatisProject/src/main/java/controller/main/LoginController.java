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
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "redirect:/";
	}

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public String login(LoginCommand loginCommand, Errors errors, HttpSession session) { // 로그인: 세션 필요
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) { // 에러가 있다면 에러를 출력하도록 메인으로 보냄
			return "main/main";
		}
		loginService.login1(loginCommand, errors, session);
		if (errors.hasErrors()) { // 에러가 있다면 에러를 출력하도록 메인으로 보냄
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