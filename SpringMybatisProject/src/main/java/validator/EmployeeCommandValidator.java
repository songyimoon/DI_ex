package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmployeeCommand;


// 서버단에서 유효성 검사하기
public class EmployeeCommandValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	public void validate(Object target, Errors errors) {
		EmployeeCommand employeeCommand = (EmployeeCommand)target;
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) { 
			errors.rejectValue("empPwCon", "noMatch"); // userPwCon는 비밀번호확인 인풋박스의 name
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "required"); // 비어있거나 공백문자 있으면
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
