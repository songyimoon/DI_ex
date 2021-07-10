package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository;
	public void memUpdate(MemberCommand memberCommand) {
		
		MemberDTO dto = new MemberDTO();
		dto.setPostNumber(memberCommand.getPostNumber());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemId(memberCommand.getMemId());
		
		memberRepository.memUpdate(dto);
		
		
	}
}
