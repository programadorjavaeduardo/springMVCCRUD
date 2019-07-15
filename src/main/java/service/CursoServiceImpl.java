package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Alumno;
import beans.Curso;
import dao.AlumnoDao;
import dao.CursoDao;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoDao cursoDao;

	public List<Curso> findAll() {
		return cursoDao.findAll();
	}

	public boolean deleteCurso(int idCurso) {
		return cursoDao.deleteCurso(idCurso);
	}

	public boolean insertarCurso(Curso c) {
		return cursoDao.insertarCurso(c);
	}

	public Curso getCursoById(int idCurso) {
		return cursoDao.getCursoById(idCurso);
	}

	public boolean updateCurso(Curso c) {
		return cursoDao.updateCurso(c);
	}
	
	

}
