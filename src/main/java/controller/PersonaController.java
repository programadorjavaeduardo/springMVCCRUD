package controller;

import java.util.List;
import java.util.Map;

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
	public ModelAndView agregarPersona(@RequestParam Map<String,String> params ){

		Persona persona= new Persona();
		persona.setNombre(params.get("nombre"));
		persona.setApe_materno(params.get("ape_materno"));
		persona.setApe_paterno(params.get("ape_paterno"));
		persona.setEmail(params.get("email"));
		persona.setTelefono(params.get("telefono"));
		Formacion formacion= new Formacion();
		int idFormacion=Integer.parseInt(params.get("formacion"));
		formacion.setId_formacion(idFormacion);
		persona.setFormacion(formacion);

		boolean realizado=personaService.insertarPersona(persona);
		if(realizado) {
			mensaje="Insercion realizada correctamente";
		}else {
			mensaje="Insercion no realizada";
		}
		ModelAndView m= new ModelAndView("gestionPersonas");
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
		int seleccionado= persona.getFormacion().getId_formacion();
		m.addObject("persona", persona);
		m.addObject("titulo", titulo);
		m.addObject("textoBoton", textoBoton);
		m.addObject("formaciones", formaciones);
		m.addObject("formacionSeleccionada",seleccionado);
		return m;
	}

	@RequestMapping(value="/editPerson")
	public ModelAndView editarPersona(@RequestParam Map<String,String> params){
		ModelAndView m= new ModelAndView("gestionPersonas");
		Persona persona= new Persona();
		persona.setId_persona(Integer.parseInt(params.get("id_persona")));
		persona.setNombre(params.get("nombre"));
		persona.setApe_materno(params.get("ape_materno"));
		persona.setApe_paterno(params.get("ape_paterno"));
		persona.setEmail(params.get("email"));
		persona.setTelefono(params.get("telefono"));
		Formacion formacion= new Formacion();
		int idFormacion=Integer.parseInt(params.get("formacion"));
		formacion.setId_formacion(idFormacion);
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
