package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmployeeCommand;


public class EmployeeCommandValidator implements Validator{ // Validator를 상속받아와야지 EmployeeCommandValidator가 Validator가 된다. 상속받았으므로 재정의는 자동add해준다.

	public boolean supports(Class<?> clazz) {
		return false;
	}
	public void validate(Object target, Errors errors) { // EmployeeCommand를 전달받기 위해 만들어진 매개변수가 Object target
		EmployeeCommand employeeCommand = (EmployeeCommand)target; // 매개변수인 target이 EmployeeCommand입니다.
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			errors.rejectValue("empPwCon", "noMatch"); // 에러메시지를 생성함, userPwCon 자리에다가 noMatch에 해당하는 오류메시지 줄것이다.
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "required"); // rejectIfEmptyOrWhitespace: 비었거나, 공백이 있거나 (에러, 뷰페이지에서의 name, 에러코드)
		ValidationUtils.rejectIfEmpty(errors, "empUserId", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPwCon", "required");
		ValidationUtils.rejectIfEmpty(errors, "empName", "required");
		ValidationUtils.rejectIfEmpty(errors, "hireDate", "required");
		ValidationUtils.rejectIfEmpty(errors, "jobId", "required");
		ValidationUtils.rejectIfEmpty(errors, "PhNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "officeNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "empEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "empAddress", "required");
	} 

}
