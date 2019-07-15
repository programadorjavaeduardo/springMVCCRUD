package beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Alumno {

	private Integer id_alumno;
	
	
	private String nombre;
	
	
	private String ape_paterno;
	
	
	private String ape_materno;
	
	
	private String email;
	
	
	private String password;
	
	
	private String telefono;
	
	@Autowired
	private Formacion formacion;
	
	private boolean es_instructor;
	
	
	
	public Alumno() {
		
	}
	
	
	
	public Alumno(Integer id_alumno, String nombre, String ape_paterno, String ape_materno, String email,
			String password, String telefono, Formacion formacion, boolean es_instructor) {
		super();
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.formacion = formacion;
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

	public Formacion getFormacion() {
		return formacion;
	}

	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}

	public Integer getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEs_instructor() {
		return es_instructor;
	}


	public void setEs_instructor(boolean es_instructor) {
		this.es_instructor = es_instructor;
	}



	@Override
	public String toString() {
		return "Alumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", ape_paterno=" + ape_paterno
				+ ", ape_materno=" + ape_materno + ", email=" + email + ", password=" + password + ", telefono="
				+ telefono + ", formacion=" + formacion + ", es_instructor=" + es_instructor + "]";
	}
	
	
	
	

	
	
}
