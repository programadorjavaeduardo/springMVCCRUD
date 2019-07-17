package beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class InstructorValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Instructor.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		Instructor instructor = (Instructor) target;
		
		if(instructor.getNombre().equals("")) {
			errors.rejectValue("nombre", "field.nombre.required", "*El nombre no puede estar vacio");
		}
		
		if(instructor.getApe_paterno().equals("")) {
			errors.rejectValue("ape_paterno", "field.apePaterno.required", "*El apellido paterno no puede estar vacio");
		}
		
		if(instructor.getApe_materno().equals("")) {
			errors.rejectValue("ape_materno", "field.apeMaterno.required", "*El apellido materno no puede estar vacio");
		}
		
		if(instructor.getEmail().equals("")) {
			errors.rejectValue("email", "field.email.required", "*El email no puede estar vacio");
		}
		
		if(instructor.getPassword().equals("")) {
			errors.rejectValue("password", "field.password.required", "*El password no puede estar vacio");
		}
		
		if(instructor.getTelefono().equals("")) {
			errors.rejectValue("telefono", "field.telefono.required", "*El telefono no puede estar vacio");
		}
		
	
	}

}
