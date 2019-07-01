package dao;

import java.util.List;

import beans.Persona;

public interface PersonaDao {
	public List<Persona> findAll();
	public boolean deletePersona(int idPersona);
	public boolean insertarPersona(Persona p);
	public Persona getPersonaById(int idPersona);
	public boolean updatePersona(Persona persona);
}
