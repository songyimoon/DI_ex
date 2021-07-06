package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberMyPageInfoService {
	@Autowired
	MemberRepository memberRepository;
	public void memberMyPageInfo(Model model, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		MemberDTO dto = memberRepository.memMypageInfo(memId);
		model.addAttribute("memberCommand",dto);
	}
}
