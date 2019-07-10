package dao;

import java.util.List;

import beans.Formacion;
import beans.UsuarioAcceso;

public interface UsuarioAccesoDao {
	
	public UsuarioAcceso getUsuarioAccesoByUserPass(String user, String pass);
	
	public boolean addUsuarioAcceso(UsuarioAcceso u);
	
	public boolean updateUsuarioAcceso(UsuarioAcceso u);
	
	public boolean deleteUsuarioAcceso(int id_usuario);
	
	public UsuarioAcceso getUsuarioByIdUsuario(int id_usuario);

}

