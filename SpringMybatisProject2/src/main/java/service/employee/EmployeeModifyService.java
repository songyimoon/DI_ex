package service.employee;

import org.springframework.beans.factory.annotation.Autowired;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empModify(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmployeeId(employeeCommand.getEmployeeId()); // 변경할 내용이 아니라, 조건임
		dto.setJobId(employeeCommand.getJobId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setPhNumber(employeeCommand.getPhNumber());
		employeeRepository.empModify(dto);
		
	}
}
