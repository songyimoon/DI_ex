package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeMyPageInfoService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empMyPageInfo(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empUserId = authInfo.getUserId();
		EmployeeDTO dto = employeeRepository.empMyPageInfo(empUserId);
		model.addAttribute("employeeCommand",dto);
	}
}
