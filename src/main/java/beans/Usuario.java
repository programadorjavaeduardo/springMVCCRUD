package beans;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	
	private int id_usuario;
	
	private String user;
	
	private String password;
	
	private int id_alumno;
	
	private int id_instructor;
	
	public Usuario() {
		
	}

	public Usuario(int id_usuario, String user, String password, int id_alumno, int id_instructor) {
		super();
		this.id_usuario = id_usuario;
		this.user = user;
		this.password = password;
		this.id_alumno = id_alumno;
		this.id_instructor = id_instructor;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_instructor() {
		return id_instructor;
	}

	public void setId_instructor(int id_instructor) {
		this.id_instructor = id_instructor;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", user=" + user + ", password=" + password + ", id_alumno="
				+ id_alumno + ", id_instructor=" + id_instructor + "]";
	}
	
	
	
	
	
	
}
