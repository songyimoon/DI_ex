package service.main;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import repository.LoginRepository;

public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public AuthInfoDTO login(String userId, String userPw) {
		AuthInfoDTO authInfo = loginRepository.login(userId);
		return authInfo;
	}
}
