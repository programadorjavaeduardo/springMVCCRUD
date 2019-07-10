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
	
	public UsuarioAcceso getUsuarioAccesoByUserPass(String user, String pass) {
		return usuarioAccesoDao.getUsuarioAccesoByUserPass(user,pass);
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

	public UsuarioAcceso getUsuarioByIdUsuario(int id_usuario) {
		return usuarioAccesoDao.getUsuarioByIdUsuario(id_usuario);
	}


}
