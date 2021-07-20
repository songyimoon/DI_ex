package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class IdFindFinishService {
	@Autowired
	MemberRepository memberRepository;
	public void inFind(MemberCommand memberCommand, Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemName(memberCommand.getMemName());
		String rpadMemId = memberRepository.idFind(dto);
		model.addAttribute("rpadMemId", rpadMemId);
	}
}
