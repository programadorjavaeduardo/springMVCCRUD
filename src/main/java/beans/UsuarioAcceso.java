package beans;

import org.springframework.stereotype.Component;

@Component
public class UsuarioAcceso {
	
	private Integer id_usuario;
	
	private Integer id_persona;
	
	private String username;
	
	private String password;
	
	

	public UsuarioAcceso(Integer id_usuario, Integer id_persona, String username, String password) {
		super();
		this.id_usuario = id_usuario;
		this.id_persona = id_persona;
		this.username = username;
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

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UsuariosAcceso [id_usuario=" + id_usuario + ", id_persona=" + id_persona + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
