package dao;

import java.util.List;

import beans.Curso;

public interface CursoDao {
	public List<Curso> findAll();
	public boolean deleteCurso(int idCurso);
	public boolean insertarCurso(Curso c);
	public Curso getCursoById(int idCurso);
	public boolean updateCurso(Curso c);
	public int getNextId();
}
