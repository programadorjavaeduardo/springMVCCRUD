package beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FormacionValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Formacion.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		Formacion formacion = (Formacion) target;
		
		// la descripcion es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.descripcion.required", "La descripcion es obligatoria");
		
		
		
	}

}
