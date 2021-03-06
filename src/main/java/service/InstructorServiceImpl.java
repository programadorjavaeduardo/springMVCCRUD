package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Curso;
import beans.Instructor;
import dao.InstructorDao;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	InstructorDao instructorDao;

	public List<Instructor> findAll() {
		return instructorDao.findAll();
	}

	public boolean deleteInstructor(int idInstructor) {
		return instructorDao.deleteInstructor(idInstructor);
	}

	public boolean insertarInstructor(Instructor i) {
		return instructorDao.insertarInstructor(i);
	}

	public Instructor getInstructorById(int idInstructor) {
		return instructorDao.getInstructorById(idInstructor);
	}

	public boolean updateInstructor(Instructor instructor) {
		return instructorDao.updateInstructor(instructor);
	}

	public List<Curso> getCursosByIdInstructor(int idInstructor) {
		return instructorDao.getCursosByIdInstructor(idInstructor);
	}

	public int getNextId() {
		return instructorDao.getNextId();
	}

	public Instructor comprobarLogin(String email, String password) {
		return instructorDao.comprobarLogin(email,password);
	
	}

	public boolean desvincularCurso(int idCurso) {
		return instructorDao.desvincularCurso(idCurso);
	}

	public List<Curso> getCursosNoImpartidos() {
		return instructorDao.getCursosNoImpartidos();
	}

	public boolean vincularCurso(int idInstructor, int idCurso) {
		return instructorDao.vincularCurso(idInstructor,idCurso);
	}

}
