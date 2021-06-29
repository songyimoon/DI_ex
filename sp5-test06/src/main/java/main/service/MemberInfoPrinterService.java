package main.service;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberInfoPrinterService {
	@Autowired
	MemberPrinter print;
	@Autowired
	MemberDAO MemberDao;
	
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
