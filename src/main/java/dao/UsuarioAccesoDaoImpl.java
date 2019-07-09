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

import beans.Formacion;
import beans.Persona;
import beans.UsuarioAcceso;





@Repository
public class UsuarioAccesoDaoImpl implements UsuarioAccesoDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_FIND_USUARIOS_BY_ID_PERSONA="SELECT u.id_usuario, u.id_persona,u.username,u.password from usuarioacceso u LEFT JOIN Persona p ON p.id_persona=u.id_persona where id_persona=?";
	private static String SQL_DELETE_USUARIO="DELETE FROM usuarioacceso where id_usuario=?";
	private static String SQL_INSERT_USUARIO="INSERT INTO usuarioacceso(username, password) VALUES(?,?)";
	private static String SQL_UPDATE_USUARIO="UPDATE usuarioacceso SET username=?, password=? where id_usuario=?";
	private static String SQL_GET_USUARIO_BY_USER_AND_PASS="SELECT * FROM usuarioacceso u where u.username=? and password=?";
	
	public boolean comprobarLogin(UsuarioAcceso u) {
		boolean existe=false;
		try {
			Connection con=(Connection) dataSource.getConnection();
			pstmt=con.prepareStatement(SQL_GET_USUARIO_BY_USER_AND_PASS);
			pstmt.setString(1, u.getUser());
			pstmt.setString(2, u.getPassword());
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				existe=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de comprobarLogin ha fallado");
			e.printStackTrace();
		}
		return existe;
	}
	
	
	
	public List<UsuarioAcceso> getUsuariosAccesoByIdPersona(int id_persona) {
		List<UsuarioAcceso> usuarios= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			pstmt=con.prepareStatement(SQL_FIND_USUARIOS_BY_ID_PERSONA);
			pstmt.setInt(1, id_persona);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				UsuarioAcceso u= new UsuarioAcceso();
				u.setId_usuario(rs.getInt(1));
				u.setId_persona(rs.getInt(2));
				u.setUser(rs.getString(3));
				u.setPassword(rs.getString(4));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de usuarios por id ha fallado");
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public boolean addUsuarioAcceso(UsuarioAcceso u) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_USUARIO);
			pstmt.setString(1, u.getUser());
			pstmt.setString(2, u.getPassword());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de usuarios ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}
	public boolean updateUsuarioAcceso(UsuarioAcceso u) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_USUARIO);
			pstmt.setString(1, u.getUser());
			pstmt.setString(2, u.getPassword());
			pstmt.setInt(3, u.getId_usuario());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de usuarios ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}
	public boolean deleteUsuarioAcceso(int id_usuario) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_USUARIO);
			pstmt.setInt(1, id_usuario);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de usuarios ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	
	
	
	
	
}
