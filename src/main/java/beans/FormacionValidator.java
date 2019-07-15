package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FormacionValidator implements Validator {

	@Autowired
	MessageSource messageSource;
	
	public boolean supports(Class<?> clazz) {
		return Formacion.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		
		// la descripcionEsp es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcionEsp", "field.descripcionEsp.required");
		
		// la descripcionEng es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcionEng", "field.descripcionEng.required");
		
	}

}
