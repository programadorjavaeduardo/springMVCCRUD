package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.UsuarioAcceso;
import dao.UsuarioAccesoDao;

@Service
public class UsuarioAccesoServiceImpl implements UsuarioAccesoService{

	@Autowired
	UsuarioAccesoDao usuarioAccesoDao;
	
	public List<UsuarioAcceso> getUsuariosAccesoByIdPersona(int id_persona) {
		return usuarioAccesoDao.getUsuariosAccesoByIdPersona(id_persona);
	}

	public boolean addUsuarioAcceso(UsuarioAcceso u) {
		return usuarioAccesoDao.addUsuarioAcceso(u);
	}

	public boolean updateUsuarioAcceso(UsuarioAcceso u) {
		return usuarioAccesoDao.updateUsuarioAcceso(u);
	}

	public boolean deleteUsuarioAcceso(int id_usuario) {
		return usuarioAccesoDao.deleteUsuarioAcceso(id_usuario);
	}

	public boolean comprobarLogin(UsuarioAcceso u) {
		return usuarioAccesoDao.comprobarLogin(u);
	}

}
