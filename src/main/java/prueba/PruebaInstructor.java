package prueba;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Alumno;
import beans.Formacion;
import beans.Instructor;
import service.AlumnoServiceImpl;
import service.InstructorServiceImpl;


public class PruebaInstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory beanFactory= ctx;
		InstructorServiceImpl instructorServiceImpl=(InstructorServiceImpl) beanFactory.getBean("instructorServiceImpl");
		
		//Bateria de pruebas de la gestion de instructores
		
		//listar
		
		List<Instructor> instructores=instructorServiceImpl.findAll();
		System.out.println("Lista de instructores...");
		for(Instructor instructor: instructores) {
			System.out.println(instructor.toString());
		}
		
		//insertar
		
		int id=instructorServiceImpl.getNextId();
		System.out.println("ID Siguiente:"+id);
		Instructor i= new Instructor(id,"Instructor","r","r","r","r","1234", 1);
		System.out.println("Intructor a insertar:"+ i.toString());
		boolean insertado=instructorServiceImpl.insertarInstructor(i);
		if(insertado) {
			System.out.println("Insertado correctamente el id:"+id);
		}else {
			System.out.println("No insertado");
		}
		
		
		//get by id
		
		Instructor instructor=instructorServiceImpl.getInstructorById(id);
		System.out.println("Instructor obtenido:"+instructor.toString());
		
		//borrar
		
		boolean borrado=instructorServiceImpl.deleteInstructor(id);
		System.out.println("Instructor a borrar:"+instructor.toString());
		if(borrado) {
			System.out.println("Borrado correctamente el instructor de id:"+id);
		}else {
			System.out.println("Instructor no borrado");
		}
		
		//listar
		
		instructores=instructorServiceImpl.findAll();
		System.out.println("Lista instructores despues de los cambios...");
		for(Instructor in: instructores) {
			System.out.println(in.toString());
		}

		
		
	}

}
