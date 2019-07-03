package controller;

import java.util.List;
import java.util.Map;

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
import beans.PersonaValidator;
import service.FormacionService;
import service.PersonaService;


@Controller
@RequestMapping("person")
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@Autowired
	FormacionService formacionService;
	
	@Autowired
	Validator validator;

	private String titulo;

	private String mensaje;

	private String textoBoton;

	private List<Formacion> formaciones;

	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonaValidator()); // registramos el validador
    }
	
	@RequestMapping(value="/gestionPersonas")
	public ModelAndView mostrargestionPersonas() {
		List<Persona> personas= personaService.findAll();
		ModelAndView m = new ModelAndView("gestionPersonas");
		m.addObject("personas", personas);
		return m;
	}

	@RequestMapping(value="/deletePerson")
	public ModelAndView borrarPersona(@RequestParam(value="idPersona")int idPersona) {


		System.out.println("IdPersona a borrar:"+idPersona);
		boolean realizado=personaService.deletePersona(idPersona);
		ModelAndView m= new ModelAndView("gestionPersonas");

		//carga de las personas
		List<Persona> personas= personaService.findAll();
		m.addObject("personas", personas);


		if(realizado) {
			mensaje="Borrado realizado correctamente";
			m.addObject("mensaje",mensaje);
		}else {
			mensaje="Borrado no realizado";
			m.addObject("mensaje",mensaje);
		}

		return m;
	}
	@RequestMapping(value="/newPerson")
	public ModelAndView nuevaPersona(){
		ModelAndView m= new ModelAndView("detallePersona");
		titulo="Nueva Persona";
		textoBoton= "Agregar";
		formaciones=formacionService.getFormaciones();
		m.addObject("persona", new Persona());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		return m;
	}

	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public ModelAndView agregarPersona(@Valid Persona persona, BindingResult bindingResult){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detallePersona");
			titulo="Nueva Persona";
			textoBoton= "Agregar";
			formaciones=formacionService.getFormaciones();
			m.addObject("persona", new Persona());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=personaService.insertarPersona(persona);
			if(realizado) {
				mensaje="Insercion realizada correctamente";
			}else {
				mensaje="Insercion no realizada";
			}
			m= new ModelAndView("gestionPersonas");
			List<Persona> personas=personaService.findAll();
			m.addObject("personas", personas);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping(value="/getPerson")
	public ModelAndView getPersona(@RequestParam("idPersona") int idPersona ){
		ModelAndView m= new ModelAndView("detallePersona");
		titulo="Edicion Persona";
		textoBoton= "Editar";

		Persona persona=personaService.getPersonaById(idPersona);
		formaciones=formacionService.getFormaciones();
		int seleccionado= persona.getFormacion().getId_formacion();
		m.addObject("persona", persona);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		m.addObject("formacionSeleccionada",seleccionado);
		return m;
	}

	@RequestMapping(value="/editPerson")
	public ModelAndView editarPersona(@Valid Persona persona, BindingResult bindingResult){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detallePersona");
			titulo="Edicion Persona";
			textoBoton= "Modificar";
			formaciones=formacionService.getFormaciones();
			m.addObject("persona", new Persona());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=personaService.updatePersona(persona);
			if(realizado) {
				mensaje="Modificacion realizada correctamente";
			}else {
				mensaje="Modificacion no realizada";
			}
			m= new ModelAndView("gestionPersonas");
			List<Persona> personas=personaService.findAll();
			m.addObject("personas", personas);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping("/downloadPDFFormat")
	public ModelAndView downloadPDF(Model model){
		List<Persona> personas= personaService.findAll();
		ModelAndView m = new ModelAndView("pdfView");
		m.addObject("personas", personas);
		return m;
	}

	@RequestMapping("/downloadXLSFormat")
	public String downloadXLS(Model model){
		return "xlsView";
	}










}
