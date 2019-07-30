package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Admin;
import service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	MessageSource messageSource;
	
	String mensaje;

	private static String TITULO_ACCESO_ADMIN="title.loginAdmin";
	private static String LOGIN_NOOK="login.incorrect";
	
	
	
	@RequestMapping(value="/abrirVentanaLogin")
	public ModelAndView abrirVentanaLogin(Locale locale, HttpServletRequest req) {
		HttpSession ses= req.getSession();
		ModelAndView m;
		if(ses.getAttribute("id")!=null && ses.getAttribute("objetoLogin").equals("admin")) {
			m= new ModelAndView("welcome");
		}else {
			ses.removeAttribute("id");
			ses.removeAttribute("name");
			ses.removeAttribute("objetoLogin");
			m= new ModelAndView("login");
			String objetoLogin="admin";
			
			String titulo=messageSource.getMessage(TITULO_ACCESO_ADMIN, null, locale);
			m.addObject("objetoLogin", objetoLogin);
			m.addObject("titulo", titulo);
		}
		
		return m;
		
	}
	
	@RequestMapping("/comprobarLogin")
	public ModelAndView comprobarLogin(@RequestParam("email") String email, @RequestParam("password") String password,  HttpServletRequest req, Locale locale) {
		ModelAndView m= new ModelAndView();
		Admin a=adminService.comprobarLogin(email,password);
		if(a!=null) {
			String objetoLogin= "admin";
			m.setViewName("welcome");
			HttpSession ses=req.getSession();
			ses.setAttribute("id", a.getId_admin() );
			ses.setAttribute("nombre", a.getNombre());
			ses.setAttribute("objetoLogin", objetoLogin);
			
		}else {
			mensaje= messageSource.getMessage(LOGIN_NOOK,null,locale);
			m.addObject("mensaje", mensaje);
			m.setViewName("login");
		}
		return m;
	}
	
	
	
	










}
