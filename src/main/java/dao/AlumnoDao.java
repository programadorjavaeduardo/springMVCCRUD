package dao;

import java.util.List;

import beans.Alumno;


public interface AlumnoDao {
	public List<Alumno> findAll();

	public boolean deleteAlumno(int idAlumno);

	public boolean insertarAlumno(Alumno p);

	public Alumno getAlumnoById(int idAlumno);

	public boolean updateAlumno(Alumno Alumno);

	public boolean comprobarLogin(String email, String password);

}
