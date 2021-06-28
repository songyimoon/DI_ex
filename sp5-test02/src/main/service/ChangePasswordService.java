package main.service;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class ChangePasswordService {
	public void changePassword(String email, String oldPw, String newPw) {
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		// 현재 패스워드가 일치하면 변경되고, 일치하지 않으면 현재 패스워드가 틀렸다고 출력되면서 변경되지 않음
		dto.changePassword(oldPw, newPw);
		dao.update(dto);
		
	}
}
