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
		
		// la descripcionEsp es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcionEsp", "field.descripcionEsp.required", "La descripcion en español es obligatoria");
		
		// la descripcionEng es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcionEng", "field.descripcionEng.required", "La descripcion en ingles es obligatoria");
		
	}

}
