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
	
	;
	private static String SQL_DELETE_USUARIO="DELETE FROM usuarioacceso where id_usuario=?";
	private static String SQL_INSERT_USUARIO="INSERT INTO usuarioacceso(id_persona,username, password) VALUES(?,?,?)";
	private static String SQL_UPDATE_USUARIO="UPDATE usuarioacceso SET username=?, password=? where id_usuario=?";
	private static String SQL_GET_USUARIO_BY_USER_AND_PASS="SELECT u.id_usuario, u.id_persona, u.username, u.password FROM usuarioacceso u where u.username=? and u.password=?";
	private static String SQL_GET_USUARIO_BY_ID_USUARIO=" SELECT u.id_usuario, u.id_persona,u.username,u.password from usuarioacceso u where u.id_usuario=?";
	
	public UsuarioAcceso getUsuarioAccesoByUserPass(String user,String pass) {
		UsuarioAcceso usuario= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			pstmt=con.prepareStatement(SQL_GET_USUARIO_BY_USER_AND_PASS);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				usuario= new UsuarioAcceso();
				usuario.setId_usuario(rs.getInt(1));
				usuario.setId_persona(rs.getInt(2));
				usuario.setUsername(rs.getString(3));
				usuario.setPassword(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de usuario por user y pass ha fallado");
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public boolean addUsuarioAcceso(UsuarioAcceso u) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_USUARIO);
			pstmt.setInt(1, u.getId_persona());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
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
			pstmt.setString(1, u.getUsername());
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
	
	public UsuarioAcceso getUsuarioByIdUsuario(int id_usuario) {
		UsuarioAcceso usuario=null;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_USUARIO_BY_ID_USUARIO);
			pstmt.setInt(1, id_usuario);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				usuario= new UsuarioAcceso();
				usuario.setId_usuario(rs.getInt(1));
				usuario.setId_persona(rs.getInt(2));
				usuario.setUsername(rs.getString(3));
				usuario.setPassword(rs.getString(4));
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de usuario por id_usuario ha fallado");
			e.printStackTrace();
	 	}
	
		return usuario;
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
