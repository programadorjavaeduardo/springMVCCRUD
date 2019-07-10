package service;

import java.util.List;

import beans.Persona;
import beans.UsuarioAcceso;

public interface PersonaService {
	public List<Persona> findAll();
	public boolean deletePersona(int idPersona);
	public boolean insertarPersona(Persona p);
	public Persona getPersonaById(int idPersona);
	public boolean updatePersona(Persona persona);
	public List<UsuarioAcceso> obtenerUsuariosByIdPersona(int idPersona);

}
