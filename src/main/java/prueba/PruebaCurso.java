package prueba;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Alumno;
import beans.Curso;
import beans.Formacion;
import beans.Instructor;
import service.AlumnoServiceImpl;
import service.CursoServiceImpl;
import service.InstructorServiceImpl;


public class PruebaCurso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory beanFactory= ctx;
		CursoServiceImpl cursoServiceImpl=(CursoServiceImpl) beanFactory.getBean("cursoServiceImpl");
		InstructorServiceImpl instructorServiceImpl= (InstructorServiceImpl) beanFactory.getBean("instructorServiceImpl");
		//Bateria de pruebas de la gestion de cursos
		
		//listar
		System.out.println("Lista de cursos...");
		List<Curso> cursos=cursoServiceImpl.findAll();
		
		for(Curso curso: cursos) {
			System.out.println(curso.toString());
		}
		
		//get max id CURSO
		
		int id=cursoServiceImpl.getNextId();
		System.out.println("ID Siguiente:"+id);
		
		
		//insertar
		Instructor i= new Instructor(1);
		i=instructorServiceImpl.getInstructorById(1);
		System.out.println("Instructor obtenido:"+i.toString());
		Curso c= new Curso(id, "Prueba curso", "descripcion", 77, i);
		boolean insertado=cursoServiceImpl.insertarCurso(c);
		if(insertado) {
			System.out.println("Insertado correctamente");
		}else {
			System.out.println("No insertado");
		}
		
		
		//get by id
		
		Curso curso=cursoServiceImpl.getCursoById(id);
		System.out.println("Curso obtenido asociado al instructor:"+curso.toString());
		
		//borrar
		
		boolean borrado=cursoServiceImpl.deleteCurso(id);
		if(borrado) {
			System.out.println("Borrado correctamente");
		}else {
			System.out.println("Curso no borrado");
		}
		
		//listar
		
		cursos=cursoServiceImpl.findAll();
		System.out.println("Lista de cursos...");		
	    for(Curso cu: cursos) {
				System.out.println(cu.toString());
		}

		
		
	}

}
