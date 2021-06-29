package main.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import main.command.RegisterRequestCommand;
import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberRegisterService {
	
	MemberDAO MemberDao;
	// 생성자를 활용할 때는 xml에 constructor-arg가 없어도, 생성자 위에 autowired를 이노테이션해서 활용할 수 있다.
	// 사실상 생성자를 굳이 만들 필요가 없으므로 setter를 활용하는 방법을 사용하는 것이 편함.
	@Autowired
	public MemberRegisterService(MemberDAO memberDao) {
		this.MemberDao = memberDao;
	} 
	public void regist(RegisterRequestCommand req) {		

		MemberDTO dto = MemberDao.selectByEmail(req.getEmail());
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			MemberDao.insert(dto);
			System.out.println("사용자 등록이 완료되었습니다.");
			System.out.println();
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
}
