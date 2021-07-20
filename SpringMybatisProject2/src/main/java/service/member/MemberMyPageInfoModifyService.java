package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.MemberCommand;
import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberMyPageInfoModifyService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void memMypageInfoUpdate(HttpSession session, MemberCommand memberCommand, Errors errors) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUesrId();
 
		if(bcryptPasswordEncoder.matches(memberCommand.getMemPw(), authInfo.getUserPw())) {		
			MemberDTO dto = new MemberDTO();
			dto.setPostNumber(memberCommand.getPostNumber());
			dto.setMemAddress(memberCommand.getMemAddress());
			dto.setDetailAdd(memberCommand.getDetailAdd());
			dto.setMemPhone(memberCommand.getMemPhone());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemEmailCk(memberCommand.getMemEmailCk());
			dto.setMemAccount(memberCommand.getMemAccount());
			dto.setMemId(memId);
			memberRepository.memMyPageInfoUpdate(dto);
			
		}else {
			errors.reject("memPw", "notPw");
		}
		 
	}
}
