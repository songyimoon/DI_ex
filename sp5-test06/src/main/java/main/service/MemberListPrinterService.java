package main.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberListPrinterService {
	
	@Autowired
	MemberDAO MemberDao;
	@Autowired
	MemberPrinter print;
	

	public void printAll() {	
		Collection<MemberDTO> list = MemberDao.selectAll();
		for(MemberDTO dto : list) {
			print.print(dto);
		}
	}
}
