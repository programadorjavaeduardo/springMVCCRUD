package service;

import java.util.List;

import beans.Curso;
import beans.Instructor;

public interface InstructorService {
	public List<Instructor> findAll();

	public boolean deleteInstructor(int idInstructor);

	public boolean insertarInstructor(Instructor i);

	public Instructor getInstructorById(int idInstructor);

	public boolean updateInstructor(Instructor instructor);

	public List<Curso> getCursosByIdInstructor(int idInstructor);
	
	public int getNextId();

	public boolean comprobarLogin(String email, String password);
}
