package controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import beans.Formacion;
import beans.FormacionValidator;
import service.FormacionService;


@Controller
@RequestMapping("formacion")
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	private String titulo;

	private String mensaje;

	private String textoBoton;
	
	private String mensajeConfirmacion;
	
	private List<Formacion> formaciones;
	
	@Autowired
	private MessageSource messageSource;
	
	private static String TITULO_NUEVA_FORMACION="title.newFormacion";
	private static String BOTON_AGREGAR="button.add";
	private static String MENSAJE_BORRADO_OK="message.delete.ok";
	private static String MENSAJE_BORRADO_NOOK="message.delete.nook";
	private static String MENSAJE_INSERT_OK="message.insert.ok";
	private static String MENSAJE_INSERT_NOOK="message.insert.nook"; 
	private static String MENSAJE_UPDATE_OK="message.update.ok"; 
	private static String MENSAJE_UPDATE_NOOK="message.update.nook"; 
	private static String TITULO_EDIT_FORMACION="title.editFormacion";
	private static String BOTON_EDITAR="button.edit";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new FormacionValidator()); // registramos el validador
    }
	
	@RequestMapping(value="/gestionFormaciones")
	public ModelAndView mostrargestionFormaciones(Locale locale) {
		formaciones= formacionService.getFormaciones();
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.formacion", null, locale);
		ModelAndView m = new ModelAndView("gestionFormaciones");
		m.addObject("formaciones", formaciones);
		m.addObject("mensajeConfirmacion", mensajeConfirmacion);
		return m;
	}

	@RequestMapping(value="/borrarFormacionAJAX")
	@ResponseBody
	public String borrarInstructorAJAX(@RequestParam(value="id_formacion")int idFormacion, Locale locale) {

		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("IdFormacion a borrar:"+idFormacion);
		boolean realizado=formacionService.deleteFormacion(idFormacion);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/nuevaFormacion")
	public ModelAndView nuevaFormacion(Locale locale){
		ModelAndView m= new ModelAndView("detalleFormacion");
		titulo=messageSource.getMessage(TITULO_NUEVA_FORMACION, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		m.addObject("formacion", new Formacion());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/insertarFormacion", method=RequestMethod.POST)
	public ModelAndView agregarFormacion(@ModelAttribute("formacion") @Valid Formacion formacion, BindingResult bindingResult, Locale locale){
		ModelAndView m = null;
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleFormacion");
			titulo=messageSource.getMessage(TITULO_NUEVA_FORMACION, null, locale);
			textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}else {
			m= new ModelAndView("gestionFormaciones");
			
			boolean realizado=formacionService.addFormacion(formacion);
			
			if(realizado) {
				
				mensaje=messageSource.getMessage(MENSAJE_INSERT_OK, null, locale);
				m.addObject("mensaje",mensaje);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_NOOK, null, locale);
				m.addObject("mensaje",mensaje);
			}
			
			List<Formacion> formaciones=formacionService.getFormaciones();
			m.addObject("formaciones", formaciones);
			m.addObject("mensaje",mensaje);
		}
		
		
		return m;
	}

	@RequestMapping(value="/obtenerFormacion")
	public ModelAndView getFormacion(@RequestParam("id_formacion") int idFormacion, Locale locale ){
		ModelAndView m= new ModelAndView("detalleFormacion");
		titulo=messageSource.getMessage(TITULO_EDIT_FORMACION, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
		Formacion formacion=formacionService.getFormacionById(idFormacion);
		
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formacion", formacion);
		return m;
	}

	@RequestMapping(value="/editarFormacion")
	public ModelAndView editarFormacion(@Valid Formacion formacion, BindingResult bindingResult, Locale locale){
		ModelAndView m= new ModelAndView("gestionFormaciones");
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleFormacion");
			titulo=messageSource.getMessage(TITULO_EDIT_FORMACION, null, locale);
			textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}
		else {
			boolean realizado=formacionService.updateFormacion(formacion);
			
			if(realizado) {
				
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_OK, null, locale);
				m.addObject("mensaje",mensaje);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_NOOK, null, locale);
				m.addObject("mensaje",mensaje);
			}
			
			List<Formacion> formaciones= formacionService.getFormaciones();

			m.addObject("formaciones", formaciones);
		}
		

		return m;
	}

	










}
