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
	
	
	Validator validator;
	
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
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AlumnoValidator()); // registramos el validador de alumno
        //binder.setValidator(new LoginValidator()); //registramos el validador de login
    }
	
	@RequestMapping(value="/gestionAlumnos")
	public ModelAndView mostrargestionAlumnos(Locale locale) {
		List<Alumno> Alumnos= alumnoService.findAll();
		mensajeConfirmacion= messageSource.getMessage("mensajeConfirmacion.Alumno", null, locale);
		//Alumnos= geti18nTexts(Alumnos,locale);
		ModelAndView m = new ModelAndView("gestionAlumnos");
		
		m.addObject("Alumnos", Alumnos);
		m.addObject("mensajeConfirmacion",mensajeConfirmacion);
		return m;
	}

//	private List<Alumno> geti18nTexts(List<Alumno> Alumnos,Locale locale) {
//		for(Alumno p: Alumnos) {
//			String descFormacion= p.getFormacion().getDescripcion();
//			//messageSource.getMessage(code, args, locale)
//		}
//	}

	
	@RequestMapping(value="/deleteAlumnoAJAX")
	@ResponseBody
	public String borrarAlumnoAJAX(@RequestParam(value="idAlumno")int idAlumno, Locale locale) {

		JSONObject jsonRespuesta= new JSONObject();
		System.out.println("IdAlumno a borrar:"+idAlumno);
		boolean realizado=alumnoService.deleteAlumno(idAlumno);
		
		jsonRespuesta.put("realizado", realizado);
		
		return jsonRespuesta.toString();
	}
	
	@RequestMapping(value="/newAlumno")
	public ModelAndView nuevaAlumno(Locale locale){
		ModelAndView m= new ModelAndView("detalleAlumno");
		titulo=messageSource.getMessage(TITULO_NUEVO_ALUMNO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_AGREGAR, null, locale);
		formaciones=formacionService.getFormaciones();
		m.addObject("Alumno", new Alumno());
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		return m;
	}

	@RequestMapping(value="/addAlumno", method=RequestMethod.POST)
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
			List<Alumno> Alumnos=alumnoService.findAll();
			m.addObject("Alumnos", Alumnos);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}

	@RequestMapping(value="/getAlumno")
	public ModelAndView getAlumno(@RequestParam("idAlumno") int idAlumno, Locale locale ){
		ModelAndView m= new ModelAndView("detalleAlumno");
		titulo=messageSource.getMessage(TITULO_EDIT_ALUMNO, null, locale);
		textoBoton= messageSource.getMessage(BOTON_EDITAR, null, locale);

		Alumno Alumno=alumnoService.getAlumnoById(idAlumno);
		formaciones=formacionService.getFormaciones();
		int seleccionado= Alumno.getFormacion().getId_formacion();
		m.addObject("Alumno", Alumno);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		m.addObject("formacionSeleccionada",seleccionado);
		return m;
	}

	@RequestMapping(value="/editAlumno")
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
			List<Alumno> Alumnos=alumnoService.findAll();
			m.addObject("Alumnos", Alumnos);
			m.addObject("mensaje",mensaje);
			
		}
		
		return m;
		
	}
	
	@RequestMapping("/comprobarLogin")
	public ModelAndView comprobarLogin(Alumno a, HttpServletRequest req) {
		ModelAndView m= new ModelAndView();
		String email= a.getEmail();
		String password=a.getPassword();
		
		if(alumnoService.comprobarLogin(email,password)) {
			
			m.setViewName("welcome");
			HttpSession ses=req.getSession();
			ses.setAttribute("email", email );
		}else {
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
