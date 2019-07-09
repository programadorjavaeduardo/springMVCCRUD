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
import service.UsuarioAccesoService;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory beanFactory= ctx;
		UsuarioAccesoService usuarioAccesoService=(UsuarioAccesoService) beanFactory.getBean("usuarioAccesoServiceImpl");
		List<UsuarioAcceso> usuarios=usuarioAccesoService.getUsuariosAccesoByIdPersona(71);
		for(UsuarioAcceso u: usuarios) {
			System.out.println(u.toString());
		}
		
		
		
	}

}
