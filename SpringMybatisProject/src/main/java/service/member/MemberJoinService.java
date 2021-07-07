package service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.MemberCommand;
import controller.MailService;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	MailService mailService;
	
	public void memJoin(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(bCryptPasswordEncoder.encode(memberCommand.getMemPw()));
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memInsert(dto);
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		String subject = "가입환영인사";
		String content = "<html><body>"
						+ " 안녕하세요. " + dto.getMemId() + "님 가입을 축하드립니다."
						+ " 아래 링크를 눌러야 가입이 완료됩니다. <br/> "
						+ " <a href='http://192.168.253.1:8080/SpringMybatisProject/register/memberMail?num="+num+"&reciver="+dto.getMemEmail()+"'>가입을 완료하시려면 클릭하세요</a> "
						+ "</body></html>";
		
		try {
			mailService.sendMail(dto.getMemEmail(), content, subject);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
