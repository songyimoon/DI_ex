package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwConfirmService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public String empPw(String empPw, HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO dto = employeeRepository.empMyPageInfo(authInfo.getUserId());
		
		if(bcryptPasswordEncoder.matches(empPw, dto.getEmpPw())) {
			return "employee/empPwChangeOk";
		}else {
			model.addAttribute("pwFail", "비밀번호가 틀립니다.");
			return "employee/empPwChange";
		}	
	}
}
