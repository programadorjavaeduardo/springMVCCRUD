package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuarioAccesoValidator implements Validator {

	@Autowired
	MessageSource messageSource;
	
	public boolean supports(Class<?> clazz) {
		return UsuarioAcceso.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.descripcionEsp.required");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.descripcionEng.required");
		
	}

}
