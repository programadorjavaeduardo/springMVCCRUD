package controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import beans.Formacion;
import beans.FormacionValidator;
import beans.Persona;
import beans.PersonaValidator;
import service.FormacionService;
import service.PersonaService;
import org.json.*;

@Controller
@RequestMapping("person")
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@Autowired
	FormacionService formacionService;
	
	@Autowired
	Validator validator;
	
	@Autowired
	MessageSource messageSource;

	private String titulo;

	private String mensaje;
	
	private String mensajeConfirmacion;

	private String textoBoton;

	private List<Formacion> formaciones;
	
	private static String TITULO_NUEVA_PERSONA="title.newPerson";
	private static String BOTON_AGREGAR="button.add";
	private static String MENSAJE_BORRADO_OK="message.delete.ok";
	private static String MENSAJE_BORRADO_NOOK="message.delete.nook";
	private static String MENSAJE_INSERT_OK="message.insert.ok";
	private static String MENSAJE_INSERT_NOOK="message.insert.nook"; 
	private static String MENSAJE_UPDATE_OK="message.update.ok"; 
	private static String MENSAJE_UPDATE_NOOK="message.update.nook"; 
	private static String TITULO_EDIT_PERSONA="title.editPerson";
	private static String BOTON_EDITAR="button.edit";
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonaValidator()); // registramos el validador
    }
	
	@RequestMapping(value="/gestionPersonas")
	public ModelAndView mostrargestionPersonas(Locale locale) {
		List<Persona> personas= personaService.findAll();
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.persona", null, locale);
		//personas= geti18nTexts(personas,locale);
		ModelAndView m = new ModelAndView("gestionPersonas");
		
		m.addObject("personas", personas);
		m.addObject("mensajeConfirmacion",mensajeConfirmacion);
		return m;
	}

//	private List<Persona> geti18nTexts(List<Persona> personas,Locale locale) {
//		for(Persona p: personas) {
//			String descFormacion= p.getFormacion().getDescripcion();
//			//messageSource.getMessage(code, args, locale)
//		}
//	}

	@RequestMapping(value="/deletePerson")
	public ModelAndView borrarPersona(@RequestParam(value="idPersona")int idPersona, Locale locale) {


		System.out.println("IdPersona a borrar:"+idPersona);
		boolean realizado=personaService.deletePersona(idPersona);
		ModelAndView m= new ModelAndView("gestionPersonas");

		//carga de las personas
		List<Persona> personas= personaService.findAll();
		m.addObject("personas", personas);


		if(realizado) {
			
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_OK, null, locale);
			m.addObject("mensaje",mensaje);
		}else {
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_NOOK, null, locale);
			m.addObject("mensaje",mensaje);
		}

		return m;
	}
	
	@RequestMapping(value="/deletePersonAJAX")
	@ResponseBody
	public String borrarPersonaAJAX(@RequestParam(value="idPersona")int idPersona, Locale locale) {

		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("IdPersona a borrar:"+idPersona);
		//boolean realizado=personaService.deletePersona(idPersona);
		boolean realizado=true;
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/newPerson")
	public ModelAndView nuevaPersona(Locale locale){
		ModelAndView m= new ModelAndView("detallePersona");
		titulo=messageSource.getMessage(TITULO_NUEVA_PERSONA, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		formaciones=formacionService.getFormaciones();
		m.addObject("persona", new Persona());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		return m;
	}

	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public ModelAndView agregarPersona(@Valid Persona persona, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detallePersona");
			titulo=messageSource.getMessage(TITULO_NUEVA_PERSONA, null, locale);
			textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
			formaciones=formacionService.getFormaciones();
			m.addObject("persona", new Persona());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=personaService.insertarPersona(persona);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_NOOK, null, locale);
			}
			m= new ModelAndView("gestionPersonas");
			List<Persona> personas=personaService.findAll();
			m.addObject("personas", personas);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping(value="/getPerson")
	public ModelAndView getPersona(@RequestParam("idPersona") int idPersona, Locale locale ){
		ModelAndView m= new ModelAndView("detallePersona");
		titulo=messageSource.getMessage(TITULO_EDIT_PERSONA, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);

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
	public ModelAndView editarPersona(@Valid Persona persona, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detallePersona");
			titulo=messageSource.getMessage(TITULO_EDIT_PERSONA, null, locale);
			textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
			formaciones=formacionService.getFormaciones();
			m.addObject("persona", new Persona());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=personaService.updatePersona(persona);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_NOOK, null, locale);
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
