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
import beans.Formacion;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_FIND_ALL="SELECT a.id_alumno, a.nombre, a.apellido_paterno, a.apellido_materno, a.telefono, a.email, a.password, a.id_formacion, a.es_instructor, f.descripcionEsp, f.descripcionEng FROM Alumno a LEFT JOIN Formacion f ON a.id_formacion=f.id_formacion";
	private static String SQL_DELETE_ALUMNO="DELETE FROM Alumno where id_alumno=?";
	private static String SQL_INSERT_ALUMNO="INSERT INTO Alumno(nombre, apellido_paterno, apellido_materno, telefono, email, password, id_formacion, es_instructor) VALUES(?,?,?,?,?,?,?,?)";
	private static String SQL_GET_ALUMNO_BY_ID="SELECT a.id_alumno, a.nombre, a.apellido_paterno, a.apellido_materno, a.telefono, a.email, a.password, a.id_formacion, a.es_instructor, f.descripcionEsp, f.descripcionEng FROM Alumno a LEFT JOIN Formacion f ON a.id_formacion=f.id_formacion WHERE a.id_alumno=?";
	private static String SQL_UPDATE_ALUMNO="UPDATE Alumno SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, email=?, password=?, id_formacion=?, a.es_instructor=? where id_alumno=?";
	private static String SQL_GET_ALUMNO_BY_USER_PASS="SELECT a.id_alumno, a.nombre, a.apellido_paterno, a.apellido_materno, a.telefono, a.email, a.password, a.id_formacion, a.es_instructor, f.descripcionEsp, f.descripcionEng FROM Alumno a LEFT JOIN Formacion f ON a.id_formacion=f.id_formacion WHERE a.email=? AND a.password=?";
	private static String SQL_GET_MAX_ID= "SELECT MAX(id_alumno) from Alumno";
	
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		List<Alumno> Alumnos= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_FIND_ALL);
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
				a.setEs_instructor(rs.getInt(9));
				f.setDescripcionEsp(rs.getString(10));
				f.setDescripcionEng(rs.getString(11));
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
			pstmt.setInt(8,0);
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
				a.setEs_instructor(rs.getInt(9));
				f.setDescripcionEsp(rs.getString(10));
				f.setDescripcionEsp(rs.getString(11));
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



	public boolean comprobarLogin(String email, String password) {
		boolean correcto= false;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_ALUMNO_BY_USER_PASS);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				correcto=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion del Alumno de user=" + email + " y password=" +password+ "ha fallado");
			e.printStackTrace();
		}
		
		return correcto;
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
	
	


}
