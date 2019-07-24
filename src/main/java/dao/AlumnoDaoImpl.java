package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Alumno;
import beans.Curso;
import beans.Formacion;
import beans.Instructor;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_JOIN_ALUMNO_FORMACION="SELECT a.id_alumno, a.nombre, a.apellido_paterno, a.apellido_materno, a.telefono, a.email, a.password, a.id_formacion, f.descripcionEsp, f.descripcionEng FROM Alumno a LEFT JOIN Formacion f ON a.id_formacion=f.id_formacion";
	private static String SQL_DELETE_ALUMNO="DELETE FROM Alumno where id_alumno=?";
	private static String SQL_INSERT_ALUMNO="INSERT INTO Alumno(nombre, apellido_paterno, apellido_materno, telefono, email, password, id_formacion) VALUES(?,?,?,?,?,?,?)";
	private static String SQL_GET_ALUMNO_BY_ID=SQL_JOIN_ALUMNO_FORMACION +" WHERE a.id_alumno=?";
	private static String SQL_UPDATE_ALUMNO="UPDATE Alumno SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, email=?, password=?, id_formacion=? where id_alumno=?";
	private static String SQL_GET_ALUMNO_BY_USER_PASS=SQL_JOIN_ALUMNO_FORMACION + " WHERE a.email=? AND a.password=?";
	private static String SQL_GET_MAX_ID= "SELECT MAX(id_alumno) from Alumno";
	private static String SQL_GET_CURSOS_MATRICULADOS= "SELECT c.id_curso, c.nombre, c.descripcion, c.precio, c.id_instructor from Curso c INNER JOIN alumno_curso ac ON c.id_curso= ac.id_curso INNER JOIN Alumno al ON al.id_alumno=ac.id_alumno where al.id_alumno=?";
	private static String SQL_GET_CURSOS_RESTANTES= "SELECT c.id_curso, c.nombre, c.descripcion, c.precio, c.id_instructor from Curso c LEFT JOIN alumno_curso ac ON c.id_curso=ac.id_curso where (ac.id_alumno <> ? OR ac.id_alumno IS NULL)";
	private static String SQL_DESMATRICULACION_CURSO="DELETE from alumno_curso WHERE id_alumno=? and id_curso=?";
	private static String SQL_INSERT_MATRICULACION_CURSO="INSERT INTO alumno_curso(id_alumno,id_curso,fecha_matr) VALUES(?,?,?)";
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		List<Alumno> Alumnos= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_JOIN_ALUMNO_FORMACION);
			rs= pstmt.executeQuery();
			Alumnos= new ArrayList<Alumno>();
			
			while(rs.next()) {
				Alumno a= new Alumno();
				a.setId_alumno(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApe_paterno(rs.getString(3));
				a.setApe_materno(rs.getString(4));
				a.setTelefono(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setPassword(rs.getString(7));
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(8));
				f.setDescripcionEsp(rs.getString(9));
				f.setDescripcionEng(rs.getString(10));
				a.setFormacion(f);
				Alumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de Alumnos ha fallado");
			e.printStackTrace();
		}
		
		return Alumnos;
	}
	
	

	public boolean deleteAlumno(int idAlumno) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_ALUMNO);
			pstmt.setInt(1, idAlumno);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de Alumno por id ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public boolean insertarAlumno(Alumno a) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_ALUMNO);
			pstmt.setString(1, a.getNombre());
			pstmt.setString(2, a.getApe_paterno());
			pstmt.setString(3, a.getApe_materno());
			pstmt.setString(4, a.getTelefono());
			pstmt.setString(5, a.getEmail());
			pstmt.setString(6, a.getPassword());
			pstmt.setInt(7, a.getFormacion().getId_formacion());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de Alumnos ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public Alumno getAlumnoById(int idAlumno) {
		Alumno a= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_ALUMNO_BY_ID);
			pstmt.setInt(1, idAlumno);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				a= new Alumno();
				a.setId_alumno(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApe_paterno(rs.getString(3));
				a.setApe_materno(rs.getString(4));
				a.setTelefono(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setPassword(rs.getString(7));
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(8));
				f.setDescripcionEsp(rs.getString(9));
				f.setDescripcionEsp(rs.getString(10));
				a.setFormacion(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion del Alumno de id=" + idAlumno + " ha fallado");
			e.printStackTrace();
		}
		
		return a;
	}


	public boolean updateAlumno(Alumno alumno) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_ALUMNO);
			pstmt.setString(1, alumno.getNombre());
			pstmt.setString(2, alumno.getApe_paterno());
			pstmt.setString(3, alumno.getApe_materno());
			pstmt.setString(4, alumno.getTelefono());
			pstmt.setString(5, alumno.getEmail());
			pstmt.setString(6, alumno.getPassword());
			pstmt.setInt(7, alumno.getFormacion().getId_formacion());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, alumno.getId_alumno());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de Alumnos ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}



	public Alumno comprobarLogin(String email, String password) {
		Alumno a=null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_ALUMNO_BY_USER_PASS);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				a= new Alumno();
				a.setId_alumno(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApe_paterno(rs.getString(3));
				a.setApe_materno(rs.getString(4));
				a.setTelefono(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setPassword(rs.getString(7));
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(8));
				f.setDescripcionEsp(rs.getString(9));
				f.setDescripcionEsp(rs.getString(10));
				a.setFormacion(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion del Alumno de user=" + email + " y password=" +password+ "ha fallado");
			e.printStackTrace();
		}
		
		return a;
	}



	public int getMaxId() {
		int id=-1;
		try {
			Connection con=(Connection) dataSource.getConnection();
			pstmt=con.prepareStatement(SQL_GET_MAX_ID);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getInt(1);
			}
		}catch(SQLException ex) {
			System.out.println("La consulta de obtencion del max id de Alumno ha fallado");
			ex.printStackTrace();
		}
		return id;
	}



	public List<Curso> getCursosMatriculados(int idAlumno) {
		List<Curso> cursos= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_CURSOS_MATRICULADOS);
			pstmt.setInt(1, idAlumno);
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
			System.out.println("La consulta de obtencion de cursos matriculados por el alumno de id=" + idAlumno + " ha fallado");
			e.printStackTrace();
		}
		
		return cursos;
	}



	public List<Curso> getCursosRestantes(int idAlumno) {
		List<Curso> cursos= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_CURSOS_RESTANTES);
			pstmt.setInt(1, idAlumno);
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
			System.out.println("La consulta de obtencion de cursos restantes por el alumno de id=" + idAlumno + " ha fallado");
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	public boolean desmatricularCurso(int idAlumno, int idCurso) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DESMATRICULACION_CURSO);
			pstmt.setInt(1, idAlumno);
			pstmt.setInt(2, idCurso);
			
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de desmatriculacion del alumno " + idAlumno + "del curso " + idCurso + " ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}



	public boolean matricularCurso(int idAlumno, int idCurso) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_MATRICULACION_CURSO);
			pstmt.setInt(1, idAlumno);
			pstmt.setInt(2, idCurso);
			pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de matriculacion del alumno "+ idAlumno +  " al curso " + idCurso + " ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}

	
	


}
