package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MessageSource messageSource;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, HttpServletRequest req) {
		ModelAndView m=null;
		String textoBoton= messageSource.getMessage("button.login", null, locale);
		HttpSession session = req.getSession();
		String lang=(String) session.getAttribute("lang");
		if(lang==null) {
			session.setAttribute("lang", "es");
		}
		
		if(session.getAttribute("id_persona")!=null) {
			m= new ModelAndView("welcome");
		}else {
			m= new ModelAndView("login");
			m.addObject("textoBoton",textoBoton);
		}
		
		
		return m;
	}
	
	
	
}
	

