package beans;

import org.springframework.stereotype.Component;

@Component
public class Admin {

	private Integer id_admin;
	
	private String nombre;
	
	private String email;
	
	private String password;
	
	
	
	public Admin() {
		
	}
	

	


	public Admin(Integer id_admin, String nombre, String email, String password) {
		super();
		this.id_admin = id_admin;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}





	public Integer getId_admin() {
		return id_admin;
	}



	public void setId_admin(Integer id_admin) {
		this.id_admin = id_admin;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", nombre=" + nombre + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
	
	


	
	
	
	
	
	
	
	

	
	
}
