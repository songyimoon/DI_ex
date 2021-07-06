package service.member;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.MemberCommand;
import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;


public class MemberPwUpdateService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void memPwUpdate(HttpSession session, MemberCommand memberCommand, Errors errors) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");	
		
		if(bcryptPasswordEncoder.matches(memberCommand.getOldPw(), authInfo.getUserPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setMemId(authInfo.getUserId());
			dto.setMemPw(bcryptPasswordEncoder.encode(memberCommand.getMemPw()));
			memberRepository.memPwUpdate(dto);	
		}else {
			errors.rejectValue("oldPw", "notPw");			
		}
	}
}
