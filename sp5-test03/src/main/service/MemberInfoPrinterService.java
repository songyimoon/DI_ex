package main.service;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberInfoPrinterService {
	
	MemberPrinter print;
	MemberDAO MemberDao;
	
	public void setPrint(MemberPrinter print) {
		this.print = print;
	}
	public void setMemberDao(MemberDAO memberDao) {
		MemberDao = memberDao;
	}

	public void printMemberInfo(String email) {
		
		MemberDTO dto = MemberDao.selectByEmail(email);
		if(dto!=null) {
			print.print(dto);
		}else {
			System.out.println("데이터 없음 \n");
			return;
		}
	}
}
