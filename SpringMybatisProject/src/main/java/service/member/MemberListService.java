package service.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model, String memId) { //jsp페이지에 전달하기 위해 model받아오기
		List<MemberDTO> list = memberRepository.memList(memId);
		model.addAttribute("lists",list);
	}
}

