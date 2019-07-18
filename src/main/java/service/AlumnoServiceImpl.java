package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Alumno;
import dao.AlumnoDao;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoDao alumnoDao;	
	
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return alumnoDao.findAll();
	}

	public boolean deleteAlumno(int idAlumno) {
		// TODO Auto-generated method stub
		return alumnoDao.deleteAlumno(idAlumno);
	}

	public boolean insertarAlumno(Alumno p) {
		return alumnoDao.insertarAlumno(p);
	}

	public Alumno getAlumnoById(int idAlumno) {
		return alumnoDao.getAlumnoById(idAlumno);
	}

	public boolean updateAlumno(Alumno Alumno) {
		return alumnoDao.updateAlumno(Alumno);
	}

	public Alumno comprobarLogin(String email, String password) {
		return alumnoDao.comprobarLogin(email,password);
	}

	public int getMaxId() {
		return alumnoDao.getMaxId();
	}

	

}
