package beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AlumnoValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Alumno.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	public void validate(Object target, Errors errors) {
		Alumno Alumno = (Alumno) target;
		
		if(Alumno.getNombre().equals("")) {
			errors.rejectValue("nombre", "field.nombre.required", "*El nombre no puede estar vacio");
		}
		
		if(Alumno.getApe_paterno().equals("")) {
			errors.rejectValue("ape_paterno", "field.apePaterno.required", "*El apellido paterno no puede estar vacio");
		}
		
		if(Alumno.getApe_materno().equals("")) {
			errors.rejectValue("ape_materno", "field.apeMaterno.required", "*El apellido materno no puede estar vacio");
		}
		
		if(Alumno.getEmail().equals("")) {
			errors.rejectValue("email", "field.email.required", "*El email no puede estar vacio");
		}
		
		if(Alumno.getTelefono().equals("")) {
			errors.rejectValue("telefono", "field.telefono.required", "*El telefono no puede estar vacio");
		}
		
		if(Alumno.getFormacion().getId_formacion()==-1) {
			errors.rejectValue("formacion.id_formacion", "field.id_formacion.required", "*Debe seleccionar alguna formacion");
		}

	}

}
