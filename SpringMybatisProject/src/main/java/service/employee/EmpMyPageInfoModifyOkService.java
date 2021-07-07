package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.EmployeeCommand;
import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmpMyPageInfoModifyOkService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public void empMyPageInfoUpdate(HttpSession session, EmployeeCommand employeeCommand, Errors errors) {

		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String empUserId = authInfo.getUserId();
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			
			EmployeeDTO dto = new EmployeeDTO();
			dto.setJobId(employeeCommand.getJobId());
			dto.setPhNumber(employeeCommand.getPhNumber());
			dto.setOfficeNumber(employeeCommand.getOfficeNumber());
			dto.setEmpEmail(employeeCommand.getEmpEmail());
			dto.setEmpAddress(employeeCommand.getEmpAddress());
			dto.setEmpUserId(empUserId);
			employeeRepository.empMyPageInfoModify(dto);
			
			} else {
				errors.rejectValue("empPw", "notPw");
		}
	}
}
