package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import repository.MemberRepository;

public class MemberOutService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository;
	public String memDel(String memPw, HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		if(bcryptPasswordEncoder.matches(memPw, authInfo.getUserPw())) {
			memberRepository.memDel(authInfo.getUserId());
			return "redirect:/login/logOut";
		}else {
			model.addAttribute("pwFail","비밀번호가 틀립니다.");
			return "member/memOut";
		}
	}
}
