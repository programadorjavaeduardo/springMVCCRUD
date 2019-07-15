package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Alumno;
import beans.Curso;
import beans.Formacion;
import beans.Instructor;

@Repository
public class CursoDaoImpl implements CursoDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_FIND_ALL="SELECT c.id_curso, c.nombre, c.descripcion, c.precio, c.id_instructor, i.nombre FROM curso c LEFT JOIN Instructor i ON c.id_instructor=i.id_instructor";
	private static String SQL_DELETE_CURSO="DELETE FROM Curso where id_curso=?";
	private static String SQL_INSERT_CURSO="INSERT INTO Curso(id_curso, nombre, descripcion, precio, id_instructor) VALUES(?,?,?,?,?)";
	private static String SQL_GET_CURSO_BY_ID="SELECT C.id_curso, c.nombre, c.descripcion, c.precio, c.id_instructor from Curso c WHERE c.id_curso=?";
	private static String SQL_UPDATE_CURSO="UPDATE Curso SET id_curso=?, nombre=?, descripcion=?, precio=?, id_instructor=? where id_curso=?";

	
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		List<Curso> cursos= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_FIND_ALL);
			rs= pstmt.executeQuery();
			cursos= new ArrayList<Curso>();
			
			while(rs.next()) {
				Curso c= new Curso();
				c.setId_curso(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setPrecio(rs.getFloat(4));
				Instructor i= new Instructor();
				i.setId_instructor(rs.getInt(5));
				c.setInstructor(i);
				cursos.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de Cursos ha fallado");
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	

	public boolean deleteCurso(int idCurso) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_CURSO);
			pstmt.setInt(1, idCurso);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de Curso por id ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public boolean insertarCurso(Curso c) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_CURSO);
			pstmt.setInt(1, c.getId_curso());
			pstmt.setString(2, c.getNombre());
			pstmt.setString(3, c.getDescripcion());
			pstmt.setFloat(4, c.getPrecio());
			pstmt.setInt(5, c.getInstructor().getId_instructor());
			
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de cursos ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public Curso getCursoById(int idCurso) {
		Curso c= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_CURSO_BY_ID);
			pstmt.setInt(1, idCurso);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				c= new Curso();
				c.setId_curso(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setPrecio(rs.getFloat(4));
				Instructor i= new Instructor();
				i.setId_instructor(rs.getInt(5));
				c.setInstructor(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de Curso de id=" + idCurso + " ha fallado");
			e.printStackTrace();
		}
		
		return c;
	}


	public boolean updateCurso(Curso c) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_CURSO);
			pstmt=con.prepareStatement(SQL_INSERT_CURSO);
			pstmt.setInt(1, c.getId_curso());
			pstmt.setString(2, c.getNombre());
			pstmt.setString(3, c.getDescripcion());
			pstmt.setFloat(4, c.getPrecio());
			pstmt.setInt(5, c.getInstructor().getId_instructor());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de Cursos ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}
}
