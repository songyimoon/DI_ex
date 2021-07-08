package controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmpMyPageInfoModifyOkService;
import service.employee.EmployeeMyPageInfoService;
import service.employee.EmployeeOutService;
import service.employee.EmployeePwConfirmService;
import service.employee.EmployeePwUpdateService;
import validator.EmployeeCommandValidator;
import validator.EmployeePasswordValidator;

@Controller
@RequestMapping("empMenu")
public class EmployeeMyPageController {
	
	@Autowired
	EmployeeMyPageInfoService employeeMyPageInfoService;
	@Autowired
	EmpMyPageInfoModifyOkService empMyPageInfoModifyOkService;
	@Autowired
	EmployeePwConfirmService employeePwConfirmService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	@Autowired
	EmployeeOutService employeeOutService;
	@RequestMapping("myPage")
	public String myPage() {
		return "employee/empMyPage";
	}
	@RequestMapping("empMyPageInfo") 
	public String empMyPageInfo(HttpSession session, Model model) {
		employeeMyPageInfoService.empMyPageInfo(session, model);		
		return "employee/empMyPageInfo";
	}
	@RequestMapping("empMyPagInfoeModify")
	public String empMyPageModify(HttpSession session, Model model, @ModelAttribute EmployeeCommand employeeCommand) {
		employeeMyPageInfoService.empMyPageInfo(session, model);
		return "employee/empMyPageInfoModify";
	}
	@RequestMapping(value = "empMyPageModifyOk", method = RequestMethod.POST)
	public String empMyPageModifyOk(HttpSession session, EmployeeCommand employeeCommand, Errors errors) {
		empMyPageInfoModifyOkService.empMyPageInfoUpdate(session, employeeCommand, errors);
		
		if(errors.hasErrors()) {
			return "employee/empMyPageInfoModify";
		}
		return "employee/empMyPageInfo";
	}
	@RequestMapping("empPwChange") 
	public String empPwChange() {
		return "employee/empPwChange";
	}

	@RequestMapping("empPwChangeOk") 
	public String empPwChangeOk(@RequestParam(value = "empPw") String empPw, HttpSession session, Model model, @ModelAttribute EmployeeCommand employeeCommand) {
		String path = employeePwConfirmService.empPw(empPw,session,model);
		return path;
	}
	@RequestMapping("empPwChangeOk2")
	public String empPwChangeOk2(EmployeeCommand employeeCommand, Errors errors, HttpSession session) { // 에러는 커맨드 뒤에
		new EmployeePasswordValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/empPwChangeOk";
		}
		employeePwUpdateService.empPwUpdate(session,employeeCommand,errors);
		
		if(errors.hasErrors()) {
			return "employee/empPwChangeOk";
		}
		return "redirect:/";
	}
	
	@RequestMapping("empOut") 
	public String empOut() {
		return "employee/empOut";
	}
	@RequestMapping("empOutOk")
	public String empOutOk(@RequestParam(value = "empPw") String empPw, HttpSession session, Model model) {
		String path = employeeOutService.empDel(empPw, session, model);
		return path;
	}
	
}
