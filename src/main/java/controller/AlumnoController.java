package controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import beans.Alumno;
import beans.AlumnoValidator;
import beans.Formacion;
import beans.LoginValidator;
import service.AlumnoService;
import service.FormacionService;

@Controller
@RequestMapping("alumno")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	@Autowired
	FormacionService formacionService;
	
	
	@Autowired
	MessageSource messageSource;

	private String titulo;

	private String mensaje;
	
	private String mensajeConfirmacion;

	private String textoBoton;

	private List<Formacion> formaciones;
	
	private static String TITULO_NUEVO_ALUMNO="title.newAlumno";
	private static String BOTON_AGREGAR="button.add";
	private static String MENSAJE_BORRADO_OK="message.delete.ok";
	private static String MENSAJE_BORRADO_NOOK="message.delete.nook";
	private static String MENSAJE_INSERT_OK="message.insert.ok";
	private static String MENSAJE_INSERT_NOOK="message.insert.nook"; 
	private static String MENSAJE_UPDATE_OK="message.update.ok"; 
	private static String MENSAJE_UPDATE_NOOK="message.update.nook"; 
	private static String TITULO_EDIT_ALUMNO="title.editAlumno";
	private static String BOTON_EDITAR="button.edit";
	private static String TITULO_ACCESO_ALUMNO="title.loginAlumno";
	private static String LOGIN_NOOK="login.incorrect";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AlumnoValidator()); // registramos el validador de alumno
        
    }
	
	@RequestMapping(value="/abrirVentanaLogin")
	public ModelAndView abrirVentanaLogin(Locale locale) {
		ModelAndView m= new ModelAndView("login");
		String objetoLogin="alumno";
		String titulo=messageSource.getMessage(TITULO_ACCESO_ALUMNO, null, locale);
		m.addObject("objetoLogin", objetoLogin);
		m.addObject("titulo", titulo);
		return m;
		
	}
	
	
	
	@RequestMapping(value="/gestionAlumnos")
	public ModelAndView mostrargestionAlumnos(Locale locale) {
		List<Alumno> alumnos= alumnoService.findAll();
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.alumno", null, locale);
		//Alumnos= geti18nTexts(Alumnos,locale);
		ModelAndView m = new ModelAndView("gestionAlumnos");
		
		m.addObject("alumnos", alumnos);
		m.addObject("mensajeConfirmacion",mensajeConfirmacion);
		return m;
	}

	
	@RequestMapping(value="/borrarAlumnoAJAX")
	@ResponseBody
	public String borrarAlumnoAJAX(@RequestParam(value="idAlumno")int idAlumno, Locale locale) {

		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("IdAlumno a borrar:"+idAlumno);
		boolean realizado=alumnoService.deleteAlumno(idAlumno);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/nuevoAlumno")
	public ModelAndView nuevoAlumno(Locale locale){
		ModelAndView m= new ModelAndView("detalleAlumno");
		titulo=messageSource.getMessage(TITULO_NUEVO_ALUMNO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		formaciones=formacionService.getFormaciones();
		m.addObject("alumno", new Alumno());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		return m;
	}

	@RequestMapping(value="/insertarAlumno", method=RequestMethod.POST)
	public ModelAndView agregarAlumno(@Valid Alumno Alumno, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detalleAlumno");
			titulo=messageSource.getMessage(TITULO_NUEVO_ALUMNO, null, locale);
			textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
			formaciones=formacionService.getFormaciones();
			m.addObject("Alumno", new Alumno());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=alumnoService.insertarAlumno(Alumno);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_NOOK, null, locale);
			}
			m= new ModelAndView("gestionAlumnos");
			List<Alumno> alumnos=alumnoService.findAll();
			m.addObject("alumnos", alumnos);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping(value="/obtenerAlumno")
	public ModelAndView getAlumno(@RequestParam("idAlumno") int idAlumno, Locale locale ){
		ModelAndView m= new ModelAndView("detalleAlumno");
		titulo=messageSource.getMessage(TITULO_EDIT_ALUMNO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);

		Alumno alumno=alumnoService.getAlumnoById(idAlumno);
		formaciones=formacionService.getFormaciones();
		int seleccionado= alumno.getFormacion().getId_formacion();
		m.addObject("alumno", alumno);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		m.addObject("formacionSeleccionada",seleccionado);
		return m;
	}

	@RequestMapping(value="/editarAlumno")
	public ModelAndView editarAlumno(@Valid Alumno Alumno, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detalleAlumno");
			titulo=messageSource.getMessage(TITULO_EDIT_ALUMNO, null, locale);
			textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
			formaciones=formacionService.getFormaciones();
			m.addObject("Alumno", new Alumno());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			m.addObject("formaciones", formaciones);
		}else {
			boolean realizado=alumnoService.updateAlumno(Alumno);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_NOOK, null, locale);
			}
			m= new ModelAndView("gestionAlumnos");
			List<Alumno> alumnos=alumnoService.findAll();
			m.addObject("alumnos", alumnos);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}
	
	@RequestMapping("/comprobarLogin")
	public ModelAndView comprobarLogin(@RequestParam("email") String email, @RequestParam("password") String password,  HttpServletRequest req, Locale locale) {
		ModelAndView m= new ModelAndView();
		Alumno a=alumnoService.comprobarLogin(email,password);
		if(a!=null) {
			String objetoLogin= "alumno";
			m.setViewName("welcome");
			m.addObject("objetoLogin", objetoLogin);
			HttpSession ses=req.getSession();
			ses.setAttribute("email", email );
			ses.setAttribute("user", a.getNombre());
		}else {
			mensaje= messageSource.getMessage(LOGIN_NOOK,null,locale);
			m.addObject("mensaje", mensaje);
			m.setViewName("login");
		}
		return m;
	}

	@RequestMapping("/downloadPDFFormat")
	public ModelAndView downloadPDF(Model model){
		List<Alumno> Alumnos= alumnoService.findAll();
		ModelAndView m = new ModelAndView("pdfView");
		m.addObject("Alumnos", Alumnos);
		return m;
	}

	@RequestMapping("/downloadXLSFormat")
	public String downloadXLS(Model model){
		return "xlsView";
	}










}
