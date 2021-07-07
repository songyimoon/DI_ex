package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmployeeCommand;

public class EmployeePasswordValidator implements Validator {

	public boolean supports(Class<?> clazz) {	
		return false;
	}

	public void validate(Object target, Errors errors) {
		EmployeeCommand pwCommand = (EmployeeCommand)target;
		ValidationUtils.rejectIfEmpty(errors, "oldEmpPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPwCon", "required");
		if(!pwCommand.getEmpPw().isEmpty()) {
			if(!pwCommand.isEmpPwEqualsEmpPwCon()) {
				errors.rejectValue("empPwCon", "noMatch");
			}
		}
	}

}
