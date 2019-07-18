package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@RequestMapping("lenguaje")
public class LenguajeController {

	private String objetoLogin;
	
    @RequestMapping("/lenguajeSelector")
    public ModelAndView languageSelector(HttpServletRequest req)
    {
    	ModelAndView m= new ModelAndView(); 
        HttpSession ses= req.getSession();
        String language=(String) req.getParameter("locale");
        ses.setAttribute("lang", language);
        if (ses.getAttribute("id_alumno")!=null  || ses.getAttribute("id_instructor")!=null) {
        	if(ses.getAttribute("id_alumno")!=null) {
        		objetoLogin="alumno";
        	}else {
        		objetoLogin="instructor";
        	}
        	m.setViewName("welcome");
        	m.addObject("objetoLogin", objetoLogin);
        	
        }else {
        	m.setViewName("index");
        	 
        }
        return m;
        
    }
    
    @RequestMapping(value="/unLogin")
    public String unLogin(Locale locale, HttpServletRequest req) {
    	HttpSession ses=req.getSession();
    	ses.removeAttribute("user");
    	return "index";
    }
    
}