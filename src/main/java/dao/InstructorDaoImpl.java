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
public class InstructorDaoImpl implements InstructorDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_FIND_ALL="SELECT i.id_instructor, i.nombre, i.apellido_paterno, i.apellido_materno, i.telefono, i.email, i.password, i.es_instructor, c.id_curso, c.nombre FROM Instructor i LEFT JOIN Curso c ON i.id_instructor=c.id_instructor";
	private static String SQL_DELETE_INSTRUCTOR="DELETE FROM Instructor where id_instructor=?";
	private static String SQL_INSERT_INSTRUCTOR="INSERT INTO Instructor(id_instructor,nombre, apellido_paterno, apellido_materno, telefono, email, password, es_instructor) VALUES(?,?,?,?,?,?,?,?)";
	private static String SQL_GET_INSTRUCTOR_BY_ID="SELECT i.id_instructor, i.nombre, i.apellido_paterno, i.apellido_materno, i.telefono, i.email, i.password, i.es_instructor, c.nombre FROM Instructor i LEFT JOIN Curso c ON i.id_instructor=c.id_instructor WHERE i.id_instructor=?";
	private static String SQL_UPDATE_INSTRUCTOR="UPDATE Alumno SET id_instructor=?, nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, email=?, password=? where id_instructor=?";
	private static String SQL_GET_INSTRUCTOR_BY_USER_PASS="SELECT i.id_instructor, i.nombre, i.apellido_paterno, i.apellido_materno, i.telefono, i.email, i.password, i.es_instructor, c.nombre FROM Instructor i LEFT JOIN Curso c ON i.id_instructor=c.id_instructor WHERE i.email=? AND i.password=?";
	
	public List<Instructor> findAll() {
		// TODO Auto-generated method stub
		List<Instructor> instructores= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_FIND_ALL);
			rs= pstmt.executeQuery();
			instructores= new ArrayList<Instructor>();
			
			while(rs.next()) {
				Instructor i= new Instructor();
				i.setId_instructor(rs.getInt(1));
				i.setNombre(rs.getString(2));
				i.setApe_paterno(rs.getString(3));
				i.setApe_materno(rs.getString(4));
				i.setTelefono(rs.getString(5));
				i.setEmail(rs.getString(6));
				i.setPassword(rs.getString(7));
				i.setEs_instructor(rs.getInt(8));
				instructores.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de Instructores ha fallado");
			e.printStackTrace();
		}
		
		return instructores;
	}
	
	

	public boolean deleteInstructor(int idInstructor) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_INSTRUCTOR);
			pstmt.setInt(1, idInstructor);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de Instructor por id ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public boolean insertarInstructor(Instructor i) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_INSTRUCTOR);
			pstmt.setInt(1, i.getId_instructor());
			pstmt.setString(2, i.getNombre());
			pstmt.setString(3, i.getApe_paterno());
			pstmt.setString(4, i.getApe_materno());
			pstmt.setString(5, i.getTelefono());
			pstmt.setString(6, i.getEmail());
			pstmt.setString(7, i.getPassword());
			pstmt.setInt(8, 1);
			
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de Instructores ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public Instructor getInstructorById(int idInstructor) {
		Instructor i= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_INSTRUCTOR_BY_ID);
			pstmt.setInt(1, idInstructor);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				i= new Instructor();
				i.setId_instructor(rs.getInt(1));
				i.setNombre(rs.getString(2));
				i.setApe_paterno(rs.getString(3));
				i.setApe_materno(rs.getString(4));
				i.setTelefono(rs.getString(5));
				i.setEmail(rs.getString(6));
				i.setPassword(rs.getString(7));
				i.setId_instructor(rs.getInt(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de instructor de id=" + idInstructor + " ha fallado");
			e.printStackTrace();
		}
		
		return i;
	}


	public boolean updateInstructor(Instructor i) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_INSTRUCTOR);
			pstmt.setString(1, i.getNombre());
			pstmt.setString(2, i.getApe_paterno());
			pstmt.setString(3, i.getApe_materno());
			pstmt.setString(4, i.getTelefono());
			pstmt.setString(5, i.getEmail());
			pstmt.setString(6, i.getPassword());
			pstmt.setInt(9, i.getId_instructor());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de instructores ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}



	public boolean comprobarLogin(String email, String password) {
		boolean correcto= false;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_INSTRUCTOR_BY_USER_PASS);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				correcto=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion deL instructor de user=" + email + " y password=" +password+ "ha fallado");
			e.printStackTrace();
		}
		
		return correcto;
	}



	public List<Curso> getCursosByIdInstructor(int idInstructor) {
		// TODO Auto-generated method stub
		return null;
	}


}
