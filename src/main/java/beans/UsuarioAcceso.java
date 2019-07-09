package beans;

import org.springframework.stereotype.Component;

@Component
public class UsuarioAcceso {
	
	private Integer id_usuario;
	
	private Integer id_persona;
	
	private String user;
	
	private String password;
	
	

	public UsuarioAcceso(Integer id_usuario, Integer id_persona, String user, String password) {
		super();
		this.id_usuario = id_usuario;
		this.id_persona = id_persona;
		this.user = user;
		this.password = password;
	}

	public UsuarioAcceso() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
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

	@Override
	public String toString() {
		return "UsuariosAcceso [id_usuario=" + id_usuario + ", id_persona=" + id_persona + ", user=" + user
				+ ", password=" + password + "]";
	}
	
	
}
