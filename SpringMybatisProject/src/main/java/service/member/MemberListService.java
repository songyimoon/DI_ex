package service.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.MemberDTO;
import model.StartEndPageDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model, String memId, Integer page) { 
		int limit = 5;
		int limitPage = 10;
		
		MemberDTO dto = new MemberDTO();
			if(page!=null) {				
				Long startRow = ((long)page-1)* limit +1;
				Long endRow = startRow + limit - 1;
				StartEndPageDTO sep = new StartEndPageDTO();
				sep.setStartRow(startRow);
				sep.setEndRow(endRow);		
				dto.setStartEndPageDTO(sep);
		}
		dto.setMemId(memId);		
		
		List<MemberDTO> list = memberRepository.memList(dto);
		Integer count = memberRepository.getMemberCount();
		model.addAttribute("lists",list);
		model.addAttribute("count",count); 

		if(page!=null) {
			PageAction pageAction = new PageAction();
			pageAction.page(count, limit, limitPage, page, "memList", model);
		}
	}
}

