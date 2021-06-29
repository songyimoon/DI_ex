package main.service;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.MemberDAO;
import main.model.MemberDTO;

public class ChangePasswordService {
	
	@Autowired
	MemberDAO memberDao; 

	public void changePassword(String email, String oldPw, String newPw) {
		
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
		
	}
}
