package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Formacion;
import beans.Persona;
import service.FormacionService;
import service.PersonaService;


@Controller
@RequestMapping("person")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@Autowired
	FormacionService formacionService;

	private String titulo;

	private String mensaje;

	private String textoBoton;
	
	private List<Formacion> formaciones;
	
	@RequestMapping(value="/personList")
	public ModelAndView mostrarDatos() {
		List<Persona> personas= personaService.findAll();
		ModelAndView m = new ModelAndView("datos");
		m.addObject("personas", personas);
		return m;
	}

	@RequestMapping(value="/deletePerson")
	public ModelAndView borrarPersona(@RequestParam(value="idPersona")int idPersona) {


		System.out.println("IdPersona a borrar:"+idPersona);
		boolean realizado=personaService.deletePersona(idPersona);
		ModelAndView m= new ModelAndView("datos");

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
	public ModelAndView agregarPersona(@RequestParam("nombre") String nombre,
			@RequestParam("ape_paterno") String apePaterno, @RequestParam("ape_materno") String apeMaterno,
			@RequestParam("email") String email, @RequestParam("telefono") String telefono,
			@RequestParam("formacion") Integer id_formacion){
		
		Persona persona= new Persona();
		persona.setNombre(nombre);
		persona.setApe_materno(apeMaterno);
		persona.setApe_paterno(apePaterno);
		persona.setEmail(email);
		persona.setTelefono(telefono);
		Formacion formacion= new Formacion();
		formacion.setCodigoFormacion(id_formacion);
		persona.setFormacion(formacion);
		
		boolean realizado=personaService.insertarPersona(persona);
		if(realizado) {
			mensaje="Insercion realizada correctamente";
		}else {
			mensaje="Insercion no realizada";
		}
		ModelAndView m= new ModelAndView("datos");
		List<Persona> personas=personaService.findAll();
		m.addObject("personas", personas);
		m.addObject("mensaje",mensaje);
		return m;
	}

	@RequestMapping(value="/getPerson")
	public ModelAndView getPersona(@RequestParam("idPersona") int idPersona ){
		ModelAndView m= new ModelAndView("detallePersona");
		titulo="Edicion Persona";
		textoBoton= "Editar";
		
		Persona persona=personaService.getPersonaById(idPersona);
		formaciones=formacionService.getFormaciones();
		int seleccionado= persona.getFormacion().getCodigoFormacion();
		m.addObject("persona", persona);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		m.addObject("formacionSeleccionada",seleccionado);
		return m;
	}

	@RequestMapping(value="/editPerson")
	public ModelAndView editarPersona(@RequestParam("id_persona") Integer idPersona, @RequestParam("nombre") String nombre,
			@RequestParam("ape_paterno") String apePaterno, @RequestParam("ape_materno") String apeMaterno,
			@RequestParam("email") String email, @RequestParam("telefono") String telefono,
			@RequestParam("formacion") Integer id_formacion){
		ModelAndView m= new ModelAndView("datos");
		Persona persona= new Persona();
		persona.setId_persona(idPersona);
		persona.setNombre(nombre);
		persona.setApe_materno(apeMaterno);
		persona.setApe_paterno(apePaterno);
		persona.setEmail(email);
		persona.setTelefono(telefono);
		Formacion formacion= new Formacion();
		formacion.setCodigoFormacion(id_formacion);
		persona.setFormacion(formacion);
		boolean realizado=personaService.updatePersona(persona);
		if(realizado) {
			mensaje="Modificacion realizada correctamente";
			m.addObject("mensaje",mensaje);
		}else {
			mensaje="Modificacion no realizada";
			m.addObject("mensaje",mensaje);
		}
		List<Persona> personas= personaService.findAll();

		m.addObject("personas", personas);

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
