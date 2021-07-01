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
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	
	@RequestMapping(value = "empList", method = RequestMethod.GET )
	public String empList() {
		return "employee/employeeList"; // 복사해옴
	}
	@RequestMapping(value = "empRegist", method = RequestMethod.GET) // 새로 등록
	public String empRegist(Model model, EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model, employeeCommand);
		return "employee/employeeForm";
	}
	@RequestMapping(value = "empJoin", method = RequestMethod.POST ) // POST를 사용함으로써 다른 사용자의 불법적인 접근을 막는다.
	public String empJoin(EmployeeCommand employeeCommand, Errors errors, Model model) { // command객체를 매개변수로 선언 (뷰 페이지에서 사용자가 등록한 정보 받아옴)
		// requsetParam을 활용하게 되면 받아오는 모든 정보에 대해 계속해서 set, get 받아와야 함 - 비효율
		// @RequestParam(value = "hireDate") Date hireDate)
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/employeeForm";
		}
		employeeJoinService.empInsert(employeeCommand); // 위에서 오류 확인 모두 한 후에, return하기 전에 입력해주는걸로 한다.
		return "redirect:empList"; // 회원등록을 모두 완료한 후에, 리스트 페이지로 
	}
}
