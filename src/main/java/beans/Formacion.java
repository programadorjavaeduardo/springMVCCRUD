package beans;

import org.springframework.stereotype.Component;

@Component
public class Formacion {
	
	private int id_formacion;
	
	private String descripcionEsp;
	
	private String descripcionEng;
	
	
	public int getId_formacion() {
		return id_formacion;
	}

	public void setId_formacion(int id_formacion) {
		this.id_formacion = id_formacion;
	}

	
	public String getDescripcionEsp() {
		return descripcionEsp;
	}

	public void setDescripcionEsp(String descripcionEsp) {
		this.descripcionEsp = descripcionEsp;
	}

	public String getDescripcionEng() {
		return descripcionEng;
	}

	public void setDescripcionEng(String descripcionEng) {
		this.descripcionEng = descripcionEng;
	}

	@Override
	public String toString() {
		return "Formacion [id_formacion=" + id_formacion + ", descripcionEsp=" + descripcionEsp + ", descripcionEng="
				+ descripcionEng + "]";
	}

	
	
	
	
	
	
}
