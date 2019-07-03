package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Formacion;
import beans.FormacionValidator;
import beans.Persona;
import service.FormacionService;
import service.PersonaService;


@Controller
@RequestMapping("formacion")
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	@Autowired
    private Validator validator;
	
	private String titulo;

	private String mensaje;

	private String textoBoton;
	
	private List<Formacion> formaciones;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new FormacionValidator()); // registramos el validador
    }
	
	@RequestMapping(value="/gestionFormaciones")
	public ModelAndView mostrargestionFormaciones() {
		List<Formacion> formaciones= formacionService.getFormaciones();
		ModelAndView m = new ModelAndView("gestionFormaciones");
		m.addObject("formaciones", formaciones);
		return m;
	}

	@RequestMapping(value="/deleteFormacion")
	public ModelAndView borrarFormacion(@RequestParam(value="id_formacion")int idFormacion) {


		System.out.println("IdFormacion a borrar:"+idFormacion);
		boolean realizado=formacionService.deleteFormacion(idFormacion);
		ModelAndView m= new ModelAndView("gestionFormaciones");

		//carga de las formaciones
		List<Formacion> formaciones= formacionService.getFormaciones();
		m.addObject("formaciones", formaciones);


		if(realizado) {
			mensaje="Borrado realizado correctamente";
			m.addObject("mensaje",mensaje);
		}else {
			mensaje="Borrado no realizado";
			m.addObject("mensaje",mensaje);
		}

		return m;
	}
	@RequestMapping(value="/newFormacion")
	public ModelAndView nuevaFormacion(){
		ModelAndView m= new ModelAndView("detalleFormacion");
		titulo="Nueva Formacion";
		textoBoton= "Agregar";
		m.addObject("formacion", new Formacion());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/addFormacion", method=RequestMethod.POST)
	public ModelAndView agregarFormacion(@ModelAttribute("formacion") @Valid Formacion formacion, BindingResult bindingResult){
		ModelAndView m;
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleFormacion");
			titulo="Nueva Formacion";
			textoBoton= "Agregar";
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}else {
			Formacion f= new Formacion();
			//formacion.setDescripcion(descripcion);
			boolean realizado=formacionService.addFormacion(f);
			if(realizado) {
				mensaje="Insercion realizada correctamente";
			}else {
				mensaje="Insercion no realizada";
			}
			m= new ModelAndView("gestionFormaciones");
			List<Formacion> formaciones=formacionService.getFormaciones();
			m.addObject("formaciones", formaciones);
			m.addObject("mensaje",mensaje);
		}
		
		
		return m;
	}

	@RequestMapping(value="/getFormacion")
	public ModelAndView getFormacion(@RequestParam("id_formacion") int idFormacion ){
		ModelAndView m= new ModelAndView("detalleFormacion");
		titulo="Edicion Formacion";
		textoBoton= "Editar";
		
		Formacion formacion=formacionService.getFormacionById(idFormacion);
		
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formacion", formacion);
		return m;
	}

	@RequestMapping(value="/editFormacion")
	public ModelAndView editarFormacion(@Valid Formacion formacion, BindingResult bindingResult){
		ModelAndView m= new ModelAndView("gestionFormaciones");
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleFormacion");
			titulo="Nueva Formacion";
			textoBoton= "Agregar";
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}
		else {
			boolean realizado=formacionService.updateFormacion(formacion);
			if(realizado) {
				mensaje="Modificacion realizada correctamente";
				m.addObject("mensaje",mensaje);
			}else {
				mensaje="Modificacion no realizada";
				m.addObject("mensaje",mensaje);
			}
			List<Formacion> formaciones= formacionService.getFormaciones();

			m.addObject("formaciones", formaciones);
		}
		

		return m;
	}

	










}
