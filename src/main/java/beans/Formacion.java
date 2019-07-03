package beans;

public class Formacion {
	
	private int id_formacion;
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_formacion() {
		return id_formacion;
	}

	public void setId_formacion(int id_formacion) {
		this.id_formacion = id_formacion;
	}

	@Override
	public String toString() {
		return "Formacion [id_formacion=" + id_formacion + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
