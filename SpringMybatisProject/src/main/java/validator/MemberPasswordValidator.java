package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberPasswordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void validate(Object target, Errors errors) { // 검사할때 커맨드를 새로 만들어서 3개의 필드만 가지는 것을 사용해도 됨.
		MemberCommand pwCommand = (MemberCommand) target;
		ValidationUtils.rejectIfEmpty(errors, "oldPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPwCon", "required");
		if(!pwCommand.getMemPw().isEmpty()) {
			if(!pwCommand.isMemPwEqualsMemPwCon()) {
				errors.rejectValue("memPwCon", "noMatch");
			}
		}
	}
}
