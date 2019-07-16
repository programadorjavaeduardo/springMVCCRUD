package dao;

import java.util.List;

import beans.Alumno;
import beans.Curso;
import beans.Instructor;


public interface InstructorDao {
	
	public List<Instructor> findAll();

	public boolean deleteInstructor(int idInstructor);

	public boolean insertarInstructor(Instructor i);

	public Instructor getInstructorById(int idInstructor);

	public boolean updateInstructor(Instructor instructor);

	public List<Curso> getCursosByIdInstructor(int idInstructor);
	
	public int getNextId();

}
