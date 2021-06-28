package main.service;

import java.util.Collection;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberListPrinterService {
	public void printAll() {
		MemberDAO dao = new MemberDAO();
		MemberPrinter print = new MemberPrinter();
		Collection<MemberDTO> list = dao.selectAll();
		for(MemberDTO dto : list) {
			print.print(dto);
		}
	}
}
