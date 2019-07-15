package beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Alumno.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		Alumno Alumno = (Alumno) target;
		
		if(Alumno.getEmail().equals("")) {
			errors.rejectValue("email", "field.email.required", "*El email no puede estar vacio");
		}
		
		if(Alumno.getPassword().equals("")) {
			errors.rejectValue("password", "field.password.required", "*El password no puede estar vacio");
		}
		
		

	}

}
