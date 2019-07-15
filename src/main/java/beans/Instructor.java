package beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Instructor {

	private Integer id_instructor;
	
	
	private String nombre;
	
	
	private String ape_paterno;
	
	
	private String ape_materno;
	
	
	private String email;
	
	
	private String password;
	
	
	private String telefono;
	
	
	private int es_instructor;
	
	
	public Instructor() {
		
	}
	
	
	
	public Instructor(Integer id_instructor, String nombre, String ape_paterno, String ape_materno, String email,
			String password, String telefono, int es_instructor) {
		super();
		this.id_instructor = id_instructor;
		this.nombre = nombre;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.es_instructor = es_instructor;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_paterno() {
		return ape_paterno;
	}

	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}

	public String getApe_materno() {
		return ape_materno;
	}

	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "Instructor [id_instructor=" + id_instructor + ", nombre=" + nombre + ", ape_paterno=" + ape_paterno
				+ ", ape_materno=" + ape_materno + ", email=" + email + ", password=" + password + ", telefono="
				+ telefono + ", es_instructor=" + es_instructor + "]";
	}



	public Integer getId_instructor() {
		return id_instructor;
	}



	public void setId_instructor(Integer id_instructor) {
		this.id_instructor = id_instructor;
	}



	public int getEs_instructor() {
		return es_instructor;
	}



	public void setEs_instructor(int es_instructor) {
		this.es_instructor = es_instructor;
	}



	
	
	
	
	

	
	
}
