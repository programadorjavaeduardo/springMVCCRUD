package controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import service.PersonaService;
import service.UsuarioAccesoService;


@Controller
@RequestMapping("usuarioAcceso")
public class UsuarioAccesoController {

	@Autowired
	UsuarioAccesoService usuarioAccesoService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
    private Validator validator;
	
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
	
	@InitBinder
   protected void initBinder(WebDataBinder binder) {
       binder.setValidator(new UsuarioAccesoValidator()); // registramos el validador
   }
	
	@RequestMapping(value="/comprobarLogin")
	public ModelAndView comprobarLogin(UsuarioAcceso u, Locale locale, HttpServletRequest req) {
		ModelAndView m=null;
		
		u=usuarioAccesoService.getUsuarioAccesoByUserPass(u.getUsername(), u.getPassword());
		if(u!=null) {
			
			mensaje= messageSource.getMessage("login.correct", null, locale);
			m= new ModelAndView("welcome");
			HttpSession ses=req.getSession();
			ses.setAttribute("id_persona", u.getId_persona());
				
			
		}else {
			mensaje= messageSource.getMessage("login.incorrect", null, locale);
			m= new ModelAndView("login");
		}
		
		m.addObject("mensaje",mensaje);
			
		
		
		return m;
		
	}
	
	@RequestMapping(value="/gestionUsuarios")
	public ModelAndView mostrarUsuariosAccesoByIdPersona(Locale locale, HttpServletRequest req) {
		HttpSession ses= req.getSession();
		Integer idPersona=(Integer) ses.getAttribute("id_persona");
		List<UsuarioAcceso> usuarios=personaService.obtenerUsuariosByIdPersona(idPersona);
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.usuario", null, locale);
		ModelAndView m = new ModelAndView("gestionUsuarios");
		m.addObject("usuarios", usuarios);
		m.addObject("mensajeConfirmacion", mensajeConfirmacion);
		return m;
	}

	@RequestMapping(value="/deleteUsuario")
	public ModelAndView borrarUsuario(@RequestParam(value="id_usuario")int idUsuario, Locale locale,HttpServletRequest req) {


		System.out.println("IdUsuario a borrar:"+idUsuario);
		boolean realizado=usuarioAccesoService.deleteUsuarioAcceso(idUsuario);
		ModelAndView m= new ModelAndView("gestionUsuarios");
		if(realizado) {
			
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_OK, null, locale);
			m.addObject("mensaje",mensaje);
		}else {
			mensaje=messageSource.getMessage(MENSAJE_BORRADO_NOOK, null, locale);
			m.addObject("mensaje",mensaje);
		}
		
		//carga de los usuarios acceso de esa persona
		HttpSession ses=req.getSession();
		Integer id_persona=(Integer) ses.getAttribute("id_persona");
		List<UsuarioAcceso> usuarios= personaService.obtenerUsuariosByIdPersona(id_persona);
		m.addObject("usuarios", usuarios);

		return m;
	}
	@RequestMapping(value="/newUsuario")
	public ModelAndView nuevoUsuario(Locale locale, HttpServletRequest req){
		ModelAndView m= new ModelAndView("detalleUsuario");
		titulo=messageSource.getMessage(TITULO_NUEVO_USUARIO_ACCESO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		UsuarioAcceso u= new UsuarioAcceso();
		HttpSession ses=req.getSession();
		Integer id_persona=(Integer) ses.getAttribute("id_persona");
		u.setId_persona(id_persona);
		m.addObject("usuario", u);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/addUsuario", method=RequestMethod.POST)
	public ModelAndView agregarUsuario(@Valid UsuarioAcceso usuarioAcceso, BindingResult bindingResult, Locale locale, HttpServletRequest req){
		ModelAndView m = null;
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleUsuario");
			titulo=messageSource.getMessage(TITULO_NUEVO_USUARIO_ACCESO, null, locale);
			textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}else {
			m= new ModelAndView("gestionUsuarios");
			HttpSession ses=req.getSession();
			Integer id_persona=(Integer) ses.getAttribute("id_persona");
			usuarioAcceso.setId_persona(id_persona);
			boolean realizado=usuarioAccesoService.addUsuarioAcceso(usuarioAcceso);
			
			if(realizado) {
				
				mensaje=messageSource.getMessage(MENSAJE_INSERT_OK, null, locale);
				m.addObject("mensaje",mensaje);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_NOOK, null, locale);
				m.addObject("mensaje",mensaje);
			}
			
			

			List<UsuarioAcceso> usuarios= personaService.obtenerUsuariosByIdPersona(id_persona);
			m.addObject("usuarios", usuarios);
			m.addObject("mensaje",mensaje);
		}
		
		return m;
	}

	@RequestMapping(value="/getUsuario")
	public ModelAndView getUsuario(@RequestParam("id_usuario") int idUsuario, Locale locale ){
		ModelAndView m= new ModelAndView("detalleUsuario");
		titulo=messageSource.getMessage(TITULO_EDIT_USUARIO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
		UsuarioAcceso usuario=usuarioAccesoService.getUsuarioByIdUsuario(idUsuario);
		
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("usuario", usuario);
		return m;
	}

	@RequestMapping(value="/editUsuario")
	public ModelAndView editarUsuario(@Valid UsuarioAcceso usuario, BindingResult bindingResult, Locale locale){
		ModelAndView m= new ModelAndView("gestionUsuarios");
		if(bindingResult.hasErrors()) {
			m= new ModelAndView("detalleUsuario");
			titulo=messageSource.getMessage(TITULO_EDIT_USUARIO, null, locale);
			textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}
		else {
			boolean realizado=usuarioAccesoService.updateUsuarioAcceso(usuario);
			
			if(realizado) {
				
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_OK, null, locale);
				m.addObject("mensaje",mensaje);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_NOOK, null, locale);
				m.addObject("mensaje",mensaje);
			}
			
			UsuarioAcceso u=usuarioAccesoService.getUsuarioByIdUsuario(usuario.getId_usuario());
			List<UsuarioAcceso> usuarios= personaService.obtenerUsuariosByIdPersona(u.getId_persona());
			m.addObject("usuarios", usuarios);
		}
		

		return m;
	}

	










}
