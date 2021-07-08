package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import repository.EmployeeRepository;

public class EmployeeOutService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public String empDel(String empPw, HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		if(bcryptPasswordEncoder.matches(empPw, authInfo.getUserPw())) {
			String empUserId=authInfo.getUserId();
			employeeRepository.empOutDel(empUserId);
			return "redirect:/login/logOut";
		}else {
			model.addAttribute("pwFail","비밀번호가 틀립니다.");
			return "employee/empOut";
		}		
	}
}
