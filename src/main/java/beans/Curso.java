package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Curso {
	private int id_curso;
	
	private String nombre;
	
	private String descripcion;
	
	private float precio;
	
	@Autowired
	private Instructor instructor;
	
	public Curso() {
		
	}
	
	
	public Curso(int id_curso, String nombre, String descripcion, float precio, Instructor instructor) {
		super();
		this.id_curso = id_curso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.instructor = instructor;
	}


	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Curso [id_curso=" + id_curso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio +  "]";
	}
	
	
	
	
	
}
