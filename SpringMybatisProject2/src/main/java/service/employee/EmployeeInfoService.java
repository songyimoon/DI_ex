package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(String empId, Model model) { // empId랑 model을 받아온다.
		EmployeeDTO dto = employeeRepository.empInfo(empId);
		model.addAttribute("emp", dto); // jsp페이지로 emp로 전달했기 때문에 emp로 저장
	}
}
