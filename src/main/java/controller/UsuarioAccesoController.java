package controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
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
import beans.UsuarioAcceso;
import beans.UsuarioAccesoValidator;
import service.FormacionService;
import service.UsuarioAccesoService;


@Controller
@RequestMapping("usuarioAcceso")
public class UsuarioAccesoController {

	@Autowired
	UsuarioAccesoService usuarioAccesoService;
	
//	@Autowired
//    private Validator validator;
	
	private String titulo;

	private String mensaje;

	private String textoBoton;
	
	private String mensajeConfirmacion;
	
	
	
	@Autowired
	private MessageSource messageSource;
	
	private static String TITULO_NUEVO_USUARIO_ACCESO="title.newUsuario";
	private static String BOTON_AGREGAR="button.add";
	private static String MENSAJE_BORRADO_OK="message.delete.ok";
	private static String MENSAJE_BORRADO_NOOK="message.delete.nook";
	private static String MENSAJE_INSERT_OK="message.insert.ok";
	private static String MENSAJE_INSERT_NOOK="message.insert.nook"; 
	private static String MENSAJE_UPDATE_OK="message.update.ok"; 
	private static String MENSAJE_UPDATE_NOOK="message.update.nook"; 
	private static String TITULO_EDIT_USUARIO="title.editUsuario";
	private static String BOTON_EDITAR="button.edit";
	
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new UsuarioAccesoValidator()); // registramos el validador
//    }
	
	@RequestMapping(value="/comprobarLogin")
	public ModelAndView comprobarLogin(UsuarioAcceso u, Locale locale) {
		ModelAndView m=null;
		
		
		boolean correcto= usuarioAccesoService.comprobarLogin(u);
		if(correcto) {
			mensaje= messageSource.getMessage("login.correct", null, locale);
			m= new ModelAndView("welcome");
		}else {
			mensaje= messageSource.getMessage("login.incorrect", null, locale);
			m= new ModelAndView("login");
		}
		m.addObject("mensaje",mensaje);
			
		
		
		return m;
		
	}
	
	@RequestMapping(value="/gestionUsuarios")
	public ModelAndView mostrarUsuariosAccesoByIdPersona(@RequestParam("id_persona") Integer id_persona,Locale locale) {
		List<UsuarioAcceso> usuarios= usuarioAccesoService.getUsuariosAccesoByIdPersona(id_persona);
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.usuario", null, locale);
		ModelAndView m = new ModelAndView("gestionUsuarios");
		m.addObject("usuarios", usuarios);
		m.addObject("mensajeConfirmacion", mensajeConfirmacion);
		return m;
	}

	/*@RequestMapping(value="/deleteFormacion")
	public ModelAndView borrarFormacion(@RequestParam(value="id_formacion")int idFormacion, Locale locale) {


		System.out.println("IdFormacion a borrar:"+idFormacion);
		boolean realizado=formacionService.deleteFormacion(idFormacion);
		ModelAndView m= new ModelAndView("gestionFormaciones");
		if(realizado) {
			
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_OK, null, locale);
			m.addObject("mensaje",mensaje);
		}else {
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_NOOK, null, locale);
			m.addObject("mensaje",mensaje);
		}
		
		//carga de las formaciones
		List<Formacion> formaciones= formacionService.getFormaciones();
		m.addObject("formaciones", formaciones);

		return m;
	}
	@RequestMapping(value="/newFormacion")
	public ModelAndView nuevaFormacion(Locale locale){
		ModelAndView m= new ModelAndView("detalleFormacion");
		titulo=messageSource.getMessage(TITULO_NUEVA_FORMACION, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		m.addObject("formacion", new Formacion());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/addFormacion", method=RequestMethod.POST)
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

	@RequestMapping(value="/getFormacion")
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

	@RequestMapping(value="/editFormacion")
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

	*/










}
