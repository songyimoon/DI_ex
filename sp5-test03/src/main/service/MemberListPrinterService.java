package main.service;

import java.util.Collection;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberListPrinterService {
	
	MemberDAO MemberDao;
	MemberPrinter print;
	
	public void setMemberDao(MemberDAO memberDao) {
		MemberDao = memberDao;
	}
	public void setPrint(MemberPrinter print) {
		this.print = print;
	}

	public void printAll() {	
		Collection<MemberDTO> list = MemberDao.selectAll();
		for(MemberDTO dto : list) {
			print.print(dto);
		}
	}
}
