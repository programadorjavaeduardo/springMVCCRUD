package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@RequestMapping("language")
public class LanguageController {

    @RequestMapping("/esp")
    public String setEsp(HttpServletRequest req, HttpServletResponse res,SessionLocaleResolver session)
    {
        HttpSession ses= req.getSession();
        ses.setAttribute("lang", "es");
        return "index";
    }

    @RequestMapping("/eng")
    public String setEng(HttpServletRequest req, HttpServletResponse res,SessionLocaleResolver session)
    {
    	HttpSession ses= req.getSession();
        ses.setAttribute("lang", "en");
        return "index";
    }
}