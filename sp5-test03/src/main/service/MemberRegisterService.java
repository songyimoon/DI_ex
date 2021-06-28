package main.service;

import java.util.Date;

import main.command.RegisterRequestCommand;
import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberRegisterService {
	
	MemberDAO MemberDao;
	
	public MemberRegisterService(MemberDAO memberDao) {
		this.MemberDao = memberDao;
	} // setter 대신 생성자로 


	public void regist(RegisterRequestCommand req) {		

		MemberDTO dto = MemberDao.selectByEmail(req.getEmail()); // 이메일이 같은 사람이 있는지 확인할 것
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			MemberDao.insert(dto); // dto는 인자로 사용되므로 의존객체로 보지 않는다.
			System.out.println("사용자 등록이 완료되었습니다.");
			System.out.println();
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
}
