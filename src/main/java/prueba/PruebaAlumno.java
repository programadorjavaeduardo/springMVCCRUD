package prueba;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Alumno;
import beans.Formacion;
import service.AlumnoServiceImpl;


public class PruebaAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory beanFactory= ctx;
		AlumnoServiceImpl alumnoServiceImpl=(AlumnoServiceImpl) beanFactory.getBean("alumnoServiceImpl");
		
		//Bateria de pruebas de la gestion de alumnos
		
		//listar
		
		List<Alumno> alumnos=alumnoServiceImpl.findAll();
		
		for(Alumno alumno: alumnos) {
			System.out.println(alumno.toString());
		}
		
		//insertar
		Formacion f= new Formacion(1,"ESO","ESO");
		Alumno a= new Alumno("Jaimito","r","r","r","r","1234",f,0);
		boolean insertado=alumnoServiceImpl.insertarAlumno(a);
		if(insertado) {
			System.out.println("Insertado correctamente");
		}else {
			System.out.println("No insertado");
		}
		
		//get max id
		
		int id=alumnoServiceImpl.getMaxId();
		System.out.println("MAX ID:"+id);
		
		//get by id
		
		Alumno alumno=alumnoServiceImpl.getAlumnoById(id);
		System.out.println("Alumno obtenido:"+alumno.toString());
		
		//borrar
		
		boolean borrado=alumnoServiceImpl.deleteAlumno(id);
		if(borrado) {
			System.out.println("Borrado correctamente:"+id);
		}else {
			System.out.println("Alumno no borrado:"+id);
		}
		
		//listar
		
		alumnos=alumnoServiceImpl.findAll();
		System.out.println("Lista de alumnos...");		
	    for(Alumno al: alumnos) {
				System.out.println(al.toString());
		}

		
		
	}

}
