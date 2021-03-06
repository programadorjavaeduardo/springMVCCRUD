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
	
	private Connection con;
	
	private static String SQL_GET_ALL="SELECT i.id_instructor, i.nombre, i.apellido_paterno, i.apellido_materno, i.telefono, i.email, i.password FROM Instructor i";
	
	private static String SQL_DELETE_INSTRUCTOR="DELETE FROM Instructor where id_instructor=?";
	private static String SQL_INSERT_INSTRUCTOR="INSERT INTO Instructor(id_instructor,nombre, apellido_paterno, apellido_materno, telefono, email, password) VALUES(?,?,?,?,?,?,?)";
	private static String SQL_GET_INSTRUCTOR_BY_ID=SQL_GET_ALL + " WHERE i.id_instructor=?";
	private static String SQL_UPDATE_INSTRUCTOR="UPDATE Instructor SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, email=?, password=? where id_instructor=?";
	private static String SQL_UPDATE_DESMATRICULACION_CURSO="Update Curso SET id_instructor=null where id_curso=?";
	private static String SQL_UPDATE_MATRICULACION_CURSO="Update Curso SET id_instructor=? where id_curso=?";
	private static String SQL_GET_INSTRUCTOR_BY_USER_PASS= SQL_GET_ALL + " WHERE i.email=? AND i.password=?";
	private static String SQL_GET_LIST_CURSOS_BY_ID_INSTRUCTOR= "SELECT c.id_curso, c.nombre, c.descripcion, c.precio, c.id_instructor from Curso c WHERE c.id_instructor=?";
	private static String SQL_GET_NEXT_ID= "SELECT MAX(id_instructor)+1 from Instructor";
	private static String SQL_GET_LIST_OTHER_COURSES="SELECT c.id_curso, c.nombre, c.descripcion, c.precio from curso c WHERE c.id_instructor IS NULL"; 
	
	public List<Instructor> findAll() {
		// TODO Auto-generated method stub
		List<Instructor> instructores= null;
		List<Curso> cursos=null;
		
		try {
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_ALL);
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
				
				//cursos
				cursos=getCursosByIdInstructor(i.getId_instructor());
				i.setCursos(cursos);
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
			
			con=(Connection) dataSource.getConnection();
			
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
			
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_INSTRUCTOR);
			pstmt.setInt(1, i.getId_instructor());
			pstmt.setString(2, i.getNombre());
			pstmt.setString(3, i.getApe_paterno());
			pstmt.setString(4, i.getApe_materno());
			pstmt.setString(5, i.getTelefono());
			pstmt.setString(6, i.getEmail());
			pstmt.setString(7, i.getPassword());
			
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
		List<Curso> cursos=null;
		try {
			con=(Connection) dataSource.getConnection();
			
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
				cursos=getCursosByIdInstructor(i.getId_instructor());
				i.setCursos(cursos);
				
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
			
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_INSTRUCTOR);
			pstmt.setString(1, i.getNombre());
			pstmt.setString(2, i.getApe_paterno());
			pstmt.setString(3, i.getApe_materno());
			pstmt.setString(4, i.getTelefono());
			pstmt.setString(5, i.getEmail());
			pstmt.setString(6, i.getPassword());
			pstmt.setInt(7, i.getId_instructor());
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



	public Instructor comprobarLogin(String email, String password) {
		
		Instructor i=null;
		try {
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_INSTRUCTOR_BY_USER_PASS);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
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
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion deL instructor de user=" + email + " y password=" +password+ "ha fallado");
			e.printStackTrace();
		}
		
		return i;
	}



	public List<Curso> getCursosByIdInstructor(int idInstructor) {
		//cursos
		List<Curso> cursos=null;
		try{
			PreparedStatement pstmt2=con.prepareStatement(SQL_GET_LIST_CURSOS_BY_ID_INSTRUCTOR);
			pstmt2.setInt(1, idInstructor);
			ResultSet rs2=pstmt2.executeQuery();
			cursos= new ArrayList<Curso>();
			while(rs2.next()) {
				
				Curso c= new Curso();
				c.setId_curso(rs2.getInt(1));
				c.setNombre(rs2.getString(2));
				c.setDescripcion(rs2.getString(3));
				c.setPrecio(rs2.getFloat(4));
				Instructor i= new Instructor();
				i.setId_instructor(idInstructor);
				c.setInstructor(i);
				cursos.add(c);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de cursos del instructor por id:" +idInstructor + " ha fallado");
			e.printStackTrace();
	 	}
		
		return cursos;
	}



	public int getNextId() {
		int id=-1;
		try {
			
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_NEXT_ID);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion del siguiente id ha fallado");
			e.printStackTrace();
	 	}
	
		return id;
	}



	public boolean desvincularCurso(int idCurso) {
		boolean realizado=false;
		try {
			
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_DESMATRICULACION_CURSO);
			pstmt.setInt(1, idCurso);
			
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de desmatriculacion curso " + idCurso + " ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}



	public List<Curso> getCursosNoImpartidos() {
		//cursos
				List<Curso> cursos=null;
				try{
					pstmt=con.prepareStatement(SQL_GET_LIST_OTHER_COURSES);
					
					rs=pstmt.executeQuery();
					cursos= new ArrayList<Curso>();
					while(rs.next()) {
						
						Curso c= new Curso();
						c.setId_curso(rs.getInt(1));
						c.setNombre(rs.getString(2));
						c.setDescripcion(rs.getString(3));
						c.setPrecio(rs.getFloat(4));
						cursos.add(c);
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("La consulta de obtencion de cursos sin instructor ha fallado");
					e.printStackTrace();
			 	}
				
				return cursos;
	}



	public boolean vincularCurso(int idInstructor, int idCurso) {
		boolean realizado=false;
		try {
			
			con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_MATRICULACION_CURSO);
			pstmt.setInt(1, idInstructor);
			pstmt.setInt(2, idCurso);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de matriculacion curso " + idCurso + " al instructor " + idInstructor + "ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


}
