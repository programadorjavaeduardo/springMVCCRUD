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
import beans.Curso;
import beans.Formacion;
import beans.Instructor;
import beans.InstructorValidator;
import beans.LoginValidator;
import service.AlumnoService;
import service.FormacionService;
import service.InstructorService;

@Controller
@RequestMapping("instructor")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@Autowired
	MessageSource messageSource;

	private String titulo;

	private String mensaje;
	
	private String mensajeConfirmacion;

	private String textoBoton;
	
	private List<Curso> cursos;

	
	private static String TITULO_NUEVO_INSTRUCTOR="title.newInstructor";
	private static String TITULO_CURSOS_MATRICULADOS="title.deliveredCourses";
	private static String TITULO_CURSOS_RESTANTES_SIN_IMPARTIR="title.otherCourses";
	
	private static String BOTON_AGREGAR="button.add";
	private static String MENSAJE_BORRADO_OK="message.delete.ok";
	private static String MENSAJE_BORRADO_NOOK="message.delete.nook";
	private static String MENSAJE_INSERT_OK="message.insert.ok";
	private static String MENSAJE_INSERT_NOOK="message.insert.nook"; 
	private static String MENSAJE_UPDATE_OK="message.update.ok"; 
	private static String MENSAJE_UPDATE_NOOK="message.update.nook"; 
	private static String TITULO_EDIT_INSTRUCTOR="title.editInstructor";
	private static String BOTON_EDITAR="button.edit";
	private static String TITULO_ACCESO_INSTRUCTOR="title.loginInstructor";
	private static String LOGIN_NOOK="login.incorrect";
	private static String MESSAGE_STOP_PROVIDING="mensajeConfirmacion.stopProviding";
	
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new InstructorValidator()); // registramos el validador de alumno
        
    }
	
	@RequestMapping(value="/abrirVentanaLogin")
	public ModelAndView abrirVentanaLogin(Locale locale) {
		ModelAndView m= new ModelAndView("login");
		String objetoLogin="instructor";
		String titulo=messageSource.getMessage(TITULO_ACCESO_INSTRUCTOR, null, locale);
		m.addObject("objetoLogin", objetoLogin);
		m.addObject("titulo", titulo);
		return m;
		
	}
	
	
	
	@RequestMapping(value="/gestionInstructores")
	public ModelAndView gestionInstructores(Locale locale) {
		List<Instructor> instructores= instructorService.findAll();
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.instructor", null, locale);
		//Alumnos= geti18nTexts(Alumnos,locale);
		ModelAndView m = new ModelAndView("gestionInstructores");
		
		m.addObject("instructores", instructores);
		m.addObject("mensajeConfirmacion",mensajeConfirmacion);
		return m;
	}

	
	@RequestMapping(value="/borrarInstructorAJAX")
	@ResponseBody
	public String borrarInstructorAJAX(@RequestParam(value="id_instructor")int idInstructor, Locale locale) {

		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("IdInstructor a borrar:"+idInstructor);
		boolean realizado=instructorService.deleteInstructor(idInstructor);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/nuevoInstructor")
	public ModelAndView nuevoInstructor(Locale locale){
		ModelAndView m= new ModelAndView("detalleInstructor");
		titulo=messageSource.getMessage(TITULO_NUEVO_INSTRUCTOR, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		m.addObject("instructor", new Instructor());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/insertarInstructor", method=RequestMethod.POST)
	public ModelAndView agregarInstructor(@Valid Instructor instructor, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detalleInstructor");
			titulo=messageSource.getMessage(TITULO_NUEVO_INSTRUCTOR, null, locale);
			textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
			m.addObject("instructor", new Instructor());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
		}else {
			int id=instructorService.getNextId();
			instructor.setId_instructor(id);
			boolean realizado=instructorService.insertarInstructor(instructor);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_INSERT_NOOK, null, locale);
			}
			m= new ModelAndView("gestionInstructores");
			List<Instructor> instructores=instructorService.findAll();
			m.addObject("instructores", instructores);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping(value="/obtenerInstructor")
	public ModelAndView getAlumno(@RequestParam("id_instructor") int idInstructor, Locale locale ){
		ModelAndView m= new ModelAndView("detalleInstructor");
		titulo=messageSource.getMessage(TITULO_EDIT_INSTRUCTOR, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);

		Instructor instructor=instructorService.getInstructorById(idInstructor);
		
		m.addObject("instructor", instructor);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		return m;
	}

	@RequestMapping(value="/editarInstructor")
	public ModelAndView editarInstructor(@Valid Instructor instructor, BindingResult bindingResult, Locale locale){
		ModelAndView m;
		
		if(bindingResult.hasErrors()) {
			m = new ModelAndView("detalleInstructor");
			titulo=messageSource.getMessage(TITULO_EDIT_INSTRUCTOR, null, locale);
			textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);
			m.addObject("instructor", new Instructor());
			m.addObject("titulo", titulo);
			m.addObject("textoBoton", textoBoton);
			
		}else {
			boolean realizado=instructorService.updateInstructor(instructor);
			if(realizado) {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_OK, null, locale);
			}else {
				mensaje=messageSource.getMessage(MENSAJE_UPDATE_NOOK, null, locale);
			}
			m= new ModelAndView("gestionInstructores");
			List<Instructor> instructores=instructorService.findAll();
			m.addObject("instructores", instructores);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}
	
	@RequestMapping("/comprobarLogin")
	public ModelAndView comprobarLogin(@RequestParam("email") String email, @RequestParam("password") String password,  HttpServletRequest req, Locale locale) {
		ModelAndView m= new ModelAndView();
		Instructor i=instructorService.comprobarLogin(email,password);
		if(i!=null) {
			String objetoLogin= "instructor";
			m.addObject("objetoLogin", objetoLogin);
			m.setViewName("welcome");
			HttpSession ses=req.getSession();
			ses.setAttribute("id", i.getId_instructor());
			ses.setAttribute("nombre", i.getNombre());
		}else {
			mensaje= messageSource.getMessage(LOGIN_NOOK,null,locale);
			m.addObject("mensaje", mensaje);
			m.setViewName("login");
		}
		return m;
	}
	
	@RequestMapping(value="/verCursosImpartidos")
	public ModelAndView verCursosImpartidos(@RequestParam("id_instructor") int idInstructor, Locale locale){
		ModelAndView m= new ModelAndView();
		cursos= instructorService.getCursosByIdInstructor(idInstructor);
		titulo= messageSource.getMessage(TITULO_CURSOS_MATRICULADOS,null,locale);
		mensajeConfirmacion= messageSource.getMessage(MESSAGE_STOP_PROVIDING, null, locale);
		boolean cursosImpartidos=true;
		m.setViewName("gestionCursos");
		m.addObject("titulo", titulo);
		m.addObject("cursos", cursos);
		m.addObject("cursosImpartidos", cursosImpartidos);
		m.addObject(mensajeConfirmacion, mensajeConfirmacion);
		return m;
		
	}
	
	@RequestMapping(value="/verCursosRestantes")
	public ModelAndView verCursosRestantes(Locale locale){
		ModelAndView m= new ModelAndView();
		cursos= instructorService.getCursosNoImpartidos();
		titulo= messageSource.getMessage(TITULO_CURSOS_RESTANTES_SIN_IMPARTIR,null,locale);
		boolean cursosRestantesPorImpartir=true;
		m.setViewName("gestionCursos");
		m.addObject("titulo", titulo);
		m.addObject("cursos", cursos);
		m.addObject("cursosRestantesPorImpartir", cursosRestantesPorImpartir);
		return m;
		
	}
	
	@RequestMapping(value="/desvincularCursoAJAX")
	@ResponseBody
	public String desvincularCursoAJAX(@RequestParam("id_instructor") int idInstructor, @RequestParam("id_curso") int idCurso, Locale locale) {
		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("Desvinculando "+idInstructor+ " del curso "+idCurso+"...");
		boolean realizado=instructorService.desvincularCurso(idCurso);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/impartirCursoAJAX")
	@ResponseBody
	public String impartirCursoAJAX(@RequestParam("id_instructor") int idInstructor, @RequestParam("id_curso") int idCurso, Locale locale) {
		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("Vinculando Instructor "+idInstructor+ " al curso "+idCurso+"...");
		boolean realizado=instructorService.vincularCurso(idInstructor,idCurso);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping("/generarExcel")
	public ModelAndView generarExcel(@RequestParam("id_instructor") int idInstructor, Locale locale){
		ModelAndView m;
		m= new ModelAndView("excelView");
		cursos= instructorService.getCursosByIdInstructor(idInstructor);
		m.addObject("cursos", cursos);
		m.addObject("source", "instructor");
		// return a view which will be resolved by an excel view resolver
        return m;
		
	}

	










}
