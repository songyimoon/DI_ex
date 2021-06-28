package main.service;

import java.util.Date;

import main.command.RegisterRequestCommand;
import main.model.MemberDAO;
import main.model.MemberDTO;

public class MemberRegisterService {
	public void regist(RegisterRequestCommand req) {		
		// dao: 서비스가 가지고 있는 값을 디비에 전달하기 위해 꼭 필요한 객체
		// 의존객체 : dependency object 서비스는 다오없이 의미가 없다.
		
		MemberDAO dao = new MemberDAO(); 
		
		MemberDTO dto = dao.selectByEmail(req.getEmail()); // 이메일이 같은 사람이 있는지 확인할 것
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			dao.insert(dto); // dto는 인자로 사용되므로 의존객체로 보지 않는다.
			System.out.println("사용자 등록이 완료되었습니다.");
			System.out.println();
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
}
