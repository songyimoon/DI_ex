package controller.employee;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import model.AuthInfoDTO;
import service.employee.EmployeeDeleteService;
import service.employee.EmployeeInfoService;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeListService;
import service.employee.EmployeeModifyService;
import service.employee.EmployeeNumService;
import service.main.LoginService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "empList", method = RequestMethod.GET )
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/employeeList"; // 복사해옴
	}@RequestMapping(value = "empRegist", method = RequestMethod.GET) // 새로 등록
	public String empRegist(Model model, EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model, employeeCommand);
		return "employee/employeeForm";
	}
	@RequestMapping(value = "empJoin", method = RequestMethod.POST ) // POST를 사용함으로써 다른 사용자의 불법적인 접근을 막는다.
	public String empJoin(EmployeeCommand employeeCommand, Errors errors, Model model) { // command객체를 매개변수로 선언 (뷰 페이지에서 사용자가 등록한 정보 받아옴)
		// requsetParam을 활용하게 되면 받아오는 모든 정보에 대해 계속해서 set, get 받아와야 함 - 비효율
		// @RequestParam(value = "hireDate") Date hireDate)
		new EmployeeCommandValidator().validate(employeeCommand, errors); // 필수항목 체크해주는 에러
		if(errors.hasErrors()) {
			return "employee/employeeForm";
		}
		AuthInfoDTO authInfo = loginService.login(employeeCommand.getEmpUserId(),employeeCommand.getEmpPw()); // jsp페이지를 통해 등록된(command로 받아온) 아이디와 비밀번호를 받음
		if(authInfo != null) { // 사용중인 아이디가 있다면
			errors.rejectValue("empUserId", "duplicate"); // jsp의 name을 따라서
			return "employee/employeeForm";
		}employeeJoinService.empInsert(employeeCommand); // 위에서 오류 확인 모두 한 후에, return하기 전에 입력해주는걸로 한다.
		return "redirect:empList"; // 회원등록을 모두 완료한 후에, 리스트 페이지로 
	}
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value = "empId") String empId, Model model) { // value에 url에 있는 empId 가져온다. 이 받아온 값 저장하는 변수 String empId
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeInfo";
	}
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value = "empId") String empId, Model model) {
		employeeInfoService.empInfo(empId, model); // 상세정보가져오는건 Info 써먹음
		return "employee/employeeModify";
	}
	@RequestMapping(value = "empModifyOk", method = RequestMethod.POST)
	public String empModifyOk(EmployeeCommand employeeCommand) {
		employeeModifyService.empModify(employeeCommand);
		return "redirect:empList";
	}
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value = "empId") String empId) {
		employeeDeleteService.empDelete(empId);
		return "redirect:empList";
	}
	
}
