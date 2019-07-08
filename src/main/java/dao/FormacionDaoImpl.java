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

@Repository
public class FormacionDaoImpl implements FormacionDao {
	
	public static String SQL_GET_FORMACIONES="SELECT * FROM formacion";
	
	public static String SQL_GET_FORMACION_BY_ID="SELECT * FROM Formacion WHERE id_formacion=?";
	
	public static String SQL_INSERT_FORMACION="INSERT INTO Formacion(descripcionEsp,descripcionEng) VALUES (?,?)";
	
	public static String SQL_UPDATE_FORMACION="UPDATE Formacion SET descripcionEsp=?, descripcionEng=? where id_formacion=?";
	
	public static String SQL_DELETE_FORMACION="DELETE FROM Formacion where id_formacion=?";
	
	@Autowired
	private DataSource dataSource;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;

	public List<Formacion> getFormaciones() {
		List<Formacion> formaciones=null;
		
		try {
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_GET_FORMACIONES);
			rs= pstmt.executeQuery();
			formaciones= new ArrayList<Formacion>();
			
			while(rs.next()) {
				Formacion f= new Formacion();
				f.setId_formacion(rs.getInt(1));
				f.setDescripcionEsp(rs.getString(2));
				f.setDescripcionEng(rs.getString(3));
				formaciones.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de formaciones ha fallado");
			e.printStackTrace();
		}
		
		return formaciones;
	}
	
	public Formacion getFormacionById(int id_formacion) {
		Formacion f= null;
		try {
			Connection con=(Connection) dataSource.getConnection();
			pstmt=con.prepareStatement(SQL_GET_FORMACION_BY_ID);
			pstmt.setInt(1, id_formacion);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				f= new Formacion();
				f.setId_formacion(rs.getInt(1));
				f.setDescripcionEsp(rs.getString(2));
				f.setDescripcionEng(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de obtencion de formaciones por id ha fallado");
			e.printStackTrace();
		}
		
		return f;
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

	public boolean addFormacion(Formacion f) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_INSERT_FORMACION);
			pstmt.setString(1, f.getDescripcionEsp());
			pstmt.setString(2, f.getDescripcionEng());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de insercion de formaciones ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}

	public boolean updateFormacion(Formacion f) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_UPDATE_FORMACION);
			pstmt.setString(1, f.getDescripcionEsp());
			pstmt.setString(2, f.getDescripcionEng());
			pstmt.setInt(3, f.getId_formacion());
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de modificacion de formaciones ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}

	public boolean deleteFormacion(int id_formacion) {
		boolean realizado=false;
		try {
			
			Connection con=(Connection) dataSource.getConnection();
			
			pstmt=con.prepareStatement(SQL_DELETE_FORMACION);
			pstmt.setInt(1, id_formacion);
			int registros=pstmt.executeUpdate();
			if(registros>0) {
				realizado=true;
			}
			
		}
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La consulta de borrado de formaciones ha fallado");
			e.printStackTrace();
	 	}
	
		return realizado;
	}

	
	
	

}
