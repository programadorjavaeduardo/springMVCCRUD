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

import beans.Admin;
import beans.Alumno;
import beans.Curso;
import beans.Formacion;
import beans.Instructor;

@Repository
public class AdminDaoImpl implements AdminDao {

	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private static String SQL_GET_ADMIN_BY_USER_PASS="Select * from administrador WHERE user=? AND password=?";
	
	public Admin comprobarLogin(String email, String password) {
		Admin a=null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_ADMIN_BY_USER_PASS);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				a= new Admin();
				a.setId_admin(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion del Admin de user=" + email + " y password=" +password+ "ha fallado");
			e.printStackTrace();
		}
		
		return a;
	}



	
	
	


}
