package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import command.MemberCommand;
import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;

public class MemMypageInfoModifyOkService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void memMypageInfoModifyOk(HttpSession session, MemberCommand memberCommand, Errors errors) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String memId = authInfo.getUserId();		
		memberRepository.memMypageInfo(memId);
		
		if(bcryptPasswordEncoder.matches(memberCommand.getMemPw(), authInfo.getUserPw())) {	
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setPostNumber(memberCommand.getPostNumber());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemId(memberCommand.getMemId());
		memberRepository.memMypageInfoModifyOk(dto);		
		}else {
			errors.rejectValue("memPw", "notPw");
			
		}
		
	}
}
