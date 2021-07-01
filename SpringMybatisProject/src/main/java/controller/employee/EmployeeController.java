package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeNumService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	
	// 직원리스트
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList() {
		return "employee/employeeList";
	}
	// 직원등록페이지
	@RequestMapping(value = "empRegist", method = RequestMethod.GET)
	public String empRegist(Model model, EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model,employeeCommand);
		return "employee/employeeForm";
	}
	
	// 등록페이지 제출 후 DB 추가
	@RequestMapping(value = "empJoin", method = RequestMethod.POST) // url로 노출되지 않도록 (직접 주소로 접근하는 것)
	public String empJoin(EmployeeCommand employeeCommand, Errors errors, Model model) {
		// commamd객체는 html로부터 넘어온 값을 저장한다.
		// 그러므로 @RequestParam을 사용하지 않아도 된다.
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/employeeForm"; // 에러가 발생했다면, empJoin에서 employeeForm 페이지가 보이도록		
		}
		employeeJoinService.empInsert(employeeCommand);
		return "redirect:empList";
	}
}
