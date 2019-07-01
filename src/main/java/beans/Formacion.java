package beans;

import org.springframework.stereotype.Component;

@Component
public class Formacion {
	
	private int codigoFormacion;
	
	@Override
	public String toString() {
		return "Formacion [codigoFormacion=" + codigoFormacion + ", descripcion=" + descripcion + "]";
	}

	private String descripcion;

	public int getCodigoFormacion() {
		return codigoFormacion;
	}

	public void setCodigoFormacion(int codigoFormacion) {
		this.codigoFormacion = codigoFormacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
