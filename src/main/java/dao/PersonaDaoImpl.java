package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Formacion;
import beans.Persona;





@Repository
public class PersonaDaoImpl implements PersonaDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_FIND_ALL="SELECT p.id_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.telefono, p.email, f.id_formacion, f.descripcion FROM Persona p LEFT JOIN Formacion f ON p.id_formacion=f.id_formacion";
	private static String SQL_DELETE_PERSONA="DELETE FROM Persona where id_persona=?";
	private static String SQL_INSERT_PERSONA="INSERT INTO Persona(nombre, apellido_paterno, apellido_materno, telefono, email, id_formacion) VALUES(?,?,?,?,?,?)";
	private static String SQL_GET_PERSONA="SELECT p.id_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.telefono, p.email, f.id_formacion, f.descripcion FROM Persona p LEFT JOIN Formacion f ON p.id_formacion=f.id_formacion WHERE id_persona=?";
	private static String SQL_UPDATE_PERSONA="UPDATE Persona SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, email=?, id_formacion=? where id_persona=?";
	
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		List<Persona> personas= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_FIND_ALL);
			rs= pstmt.executeQuery();
			personas= new ArrayList<Persona>();
			
			while(rs.next()) {
				Persona p= new Persona();
				p.setId_persona(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApe_paterno(rs.getString(3));
				p.setApe_materno(rs.getString(4));
				p.setTelefono(rs.getString(5));
				p.setEmail(rs.getString(6));
				
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(7));
				f.setDescripcion(rs.getString(8));
				p.setFormacion(f);
				personas.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de personas ha fallado");
			e.printStackTrace();
		}
		
		return personas;
	}
	
	

	public boolean deletePersona(int idPersona) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_PERSONA);
			pstmt.setInt(1, idPersona);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de personas ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public boolean insertarPersona(Persona p) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_PERSONA);
			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getApe_paterno());
			pstmt.setString(3, p.getApe_materno());
			pstmt.setString(4, p.getTelefono());
			pstmt.setString(5, p.getEmail());
			pstmt.setInt(6, p.getFormacion().getId_formacion());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de personas ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}


	public Persona getPersonaById(int idPersona) {
		Persona p= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_PERSONA);
			pstmt.setInt(1, idPersona);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				p= new Persona();
				p.setId_persona(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApe_paterno(rs.getString(3));
				p.setApe_materno(rs.getString(4));
				p.setTelefono(rs.getString(5));
				p.setEmail(rs.getString(6));
				
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(7));
				f.setDescripcion(rs.getString(8));
				p.setFormacion(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de la persona de id=" + idPersona + " ha fallado");
			e.printStackTrace();
		}
		
		return p;
	}


	public boolean updatePersona(Persona persona) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_PERSONA);
			pstmt.setString(1, persona.getNombre());
			pstmt.setString(2, persona.getApe_paterno());
			pstmt.setString(3, persona.getApe_materno());
			pstmt.setString(4, persona.getTelefono());
			pstmt.setString(5, persona.getEmail());
			
			pstmt.setInt(6, persona.getFormacion().getId_formacion());
			pstmt.setInt(7, persona.getId_persona());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de personas ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}
	
	
}
