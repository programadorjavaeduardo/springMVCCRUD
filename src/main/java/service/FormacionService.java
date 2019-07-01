package service;

import java.util.List;

import beans.Formacion;

public interface FormacionService {
	public List<Formacion> getFormaciones();
	
	public Formacion getFormacionById(int id_formacion);
	
	public boolean addFormacion(Formacion f);
	
	public boolean updateFormacion(Formacion f);
	
	public boolean deleteFormacion(int id_formacion);
}
