package main.service;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberInfoPrinterService {
	public void printMemberInfo(String email) {
		// 프린트하기 위해서는 꼭 필요한 객체이므로, MemberPrinter와 MemberDAO 둘 다 의존객체임
		MemberPrinter print = new MemberPrinter();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectByEmail(email);
		if(dto!=null) {
			print.print(dto);
		}else {
			System.out.println("데이터 없음 \n");
			return;
		}
	}
}
