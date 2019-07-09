package dao;

import java.util.List;

import beans.Formacion;
import beans.UsuarioAcceso;

public interface UsuarioAccesoDao {
	
	public List<UsuarioAcceso> getUsuariosAccesoByIdPersona(int id_persona);
	
	public boolean addUsuarioAcceso(UsuarioAcceso u);
	
	public boolean updateUsuarioAcceso(UsuarioAcceso u);
	
	public boolean deleteUsuarioAcceso(int id_usuario);

	public boolean comprobarLogin(UsuarioAcceso u);
}

