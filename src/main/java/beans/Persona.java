package beans;

public class Persona {

	private Integer id_persona;
	
	
	private String nombre;
	
	
	private String ape_paterno;
	
	
	private String ape_materno;
	
	
	private String email;
	
	
	private String telefono;
	
	
	private Formacion formacion;

	public Persona() {
		
	}
	
	public Persona(Integer idPersona,String nombre, String ape_paterno, String ape_materno, String email,
			String telefono, Formacion formacion) {
		super();
		this.id_persona= idPersona;
		this.nombre = nombre;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.email = email;
		this.telefono = telefono;
		this.formacion = formacion;
	}

	

	

	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nombre=" + nombre + ", ape_paterno=" + ape_paterno
				+ ", ape_materno=" + ape_materno + ", email=" + email + ", telefono=" + telefono + ", formacion="
				+ formacion + "]";
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
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

	

	
	
}
