package service.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.LoginCommand;
import model.AuthInfoDTO;
import repository.LoginRepository;

public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public void login1(LoginCommand loginCommand, Errors errors, HttpSession session) { // void로 바꾸고 하나 더 만듦
		String userId = loginCommand.getUserId();
		AuthInfoDTO authInfo = loginRepository.login(userId);
		if (authInfo == null) {
			errors.rejectValue("userId", "notId"); // 정보없음(즉 아이디 없음)
		} else {
			if (bcryptPasswordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo); // 진짜 로그인
			} else {
				errors.rejectValue("userPw", "notPw"); // 비번틀림
			}
		}
	}
	
	public AuthInfoDTO login(String userId, String userPw) { // employeeController에서 empJoin할때 사용하고 있는 메서드라서 그대로 냅둠
	      AuthInfoDTO authInfo = loginRepository.login(userId); 
	      return authInfo;
	}
}
