package service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import repository.LoginRepository;



public class CookieService {
	@Autowired
	LoginRepository loginRepository;
	public void getCookie(HttpServletRequest request) { // 사용자로부터 쿠키 가져오기 (리퀘스트를 통해서만 가능)
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().startsWith("id")) { // id저장?
					request.setAttribute("isId", cookie.getValue());	
				}
				if(cookie.getName().startsWith("auto")) { // 오토로그인?
					String userId= cookie.getValue();
					AuthInfoDTO authInfo = loginRepository.login(userId);
					HttpSession session = request.getSession();
					session.setAttribute("authInfo",authInfo);
				}
			}
		}
	}
}
