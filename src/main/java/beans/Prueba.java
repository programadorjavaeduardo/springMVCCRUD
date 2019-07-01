package beans;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.PersonaController;
import dao.FormacionDao;
import dao.FormacionDaoImpl;
import service.FormacionService;
import service.PersonaService;
import service.PersonaServiceImpl;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory beanFactory= ctx;
		PersonaService personaService=(PersonaService) beanFactory.getBean("personaServiceImpl");
		List<Persona> personas=personaService.findAll();
		for(Persona p: personas) {
			System.out.println(p.toString());
		}
		
		
		
	}

}
