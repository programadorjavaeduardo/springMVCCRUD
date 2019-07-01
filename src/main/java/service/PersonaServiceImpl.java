package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Persona;
import dao.PersonaDao;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDao personaDao;	
	
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaDao.findAll();
	}

	public boolean deletePersona(int idPersona) {
		// TODO Auto-generated method stub
		return personaDao.deletePersona(idPersona);
	}

	public boolean insertarPersona(Persona p) {
		return personaDao.insertarPersona(p);
	}

	public Persona getPersonaById(int idPersona) {
		return personaDao.getPersonaById(idPersona);
	}

	public boolean updatePersona(Persona persona) {
		return personaDao.updatePersona(persona);
	}

	

}
