package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import command.MemberCommand;
import controller.MailService;
import controller.RandomPassword;
import model.MemberDTO;
import repository.MemberRepository;

public class FindPasswordService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MailService mailService;	
	public String findPassword(MemberCommand memberCommand, Model model) {		
		MemberDTO dto = memberRepository.memMypageInfo(memberCommand.getMemId());		
		if(dto!=null) {
			if(memberCommand.getMemEmail().equals(dto.getMemEmail())) {
				String pass = RandomPassword.getRamdomPassword(10);
				String encodePass = bcryptPasswordEncoder.encode(pass);
				dto.setMemPw(encodePass);
				memberRepository.memPwUpdate(dto);
				String content = dto.getMemName()+"님의 임시비밀번호는 '"+pass+"' 입니다.";
				String subject = dto.getMemName()+"님의 비밀번호 변경 메일";
				try {
					mailService.sendMail(dto.getMemEmail(), content, subject);
				} catch (Exception e) {
					e.printStackTrace();
				}				
				model.addAttribute("email", dto.getMemEmail());
				return "main/passView";
			}else {
				model.addAttribute("errEmail", "이메일이 일치하지 않습니다.");
				return "main/findPassword";
			}
		}else { 
			model.addAttribute("errMemId", "아이디가 존재하지 않습니다.");
			return "main/findPassword";
			
		}
	}
}
