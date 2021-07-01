package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeJoinService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void empInsert(EmployeeCommand employeeCommand) { // insert하려면 employeeCommand를 받아와야함. 매개변수 넣어주기.
		// service에서 repository로 전달하기 위해서는 dto가 필요하다.
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPw(bCryptPasswordEncoder.encode(employeeCommand.getEmpPw())); // 비밀번호 암호화
		dto.setEmpUserId(employeeCommand.getEmpUserId());
		dto.setHireDate(employeeCommand.getHireDate());
		dto.setJobId(employeeCommand.getJobId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setPhNumber(employeeCommand.getPhNumber());
		employeeRepository.empInsert(dto);
	}
}
