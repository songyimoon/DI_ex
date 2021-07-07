package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.EmployeeCommand;
import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void empPwUpdate(HttpSession session, EmployeeCommand employeeCommand, Errors errors) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO emp = employeeRepository.empMyPageInfo(authInfo.getUserId());
		
		if(bcryptPasswordEncoder.matches(employeeCommand.getOldEmpPw(), emp.getEmpPw())) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpUserId(authInfo.getUserId());
			dto.setEmpPw(bcryptPasswordEncoder.encode(employeeCommand.getEmpPw()));
			employeeRepository.empPwUpdate(dto);
		}else {
			errors.rejectValue("oldEmpPw", "notPw");;
		}
	}
}
