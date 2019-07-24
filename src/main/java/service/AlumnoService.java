package service;

import java.util.List;

import beans.Alumno;
import beans.Curso;

public interface AlumnoService {
	public List<Alumno> findAll();
	public boolean deleteAlumno(int idAlumno);
	public boolean insertarAlumno(Alumno p);
	public Alumno getAlumnoById(int idAlumno);
	public boolean updateAlumno(Alumno Alumno);
	public Alumno comprobarLogin(String email, String password);
	public int getMaxId();
	public List<Curso> getCursosMatriculados(int idAlumno);
	public List<Curso> getCursosRestantes(int idAlumno);
	public boolean desmatricularCurso(int idAlumno, int idCurso);
	public boolean matricularCurso(int idAlumno, int idCurso);

}
