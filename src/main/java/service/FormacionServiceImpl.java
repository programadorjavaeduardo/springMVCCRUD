package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Formacion;
import dao.FormacionDao;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	private FormacionDao formacionDao;
	
	public List<Formacion> getFormaciones() {
		// TODO Auto-generated method stub
		return formacionDao.getFormaciones();
	}
	
	public Formacion getFormacionById(int id_formacion) {
		return formacionDao.getFormacionById(id_formacion);
	}

	public FormacionDao getFormacionDao() {
		return formacionDao;
	}

	public void setFormacionDao(FormacionDao formacionDao) {
		this.formacionDao = formacionDao;
	}

	public boolean addFormacion(Formacion f) {
		return formacionDao.addFormacion(f);
	}

	public boolean updateFormacion(Formacion f) {
		return formacionDao.updateFormacion(f);
	}

	public boolean deleteFormacion(int id_formacion) {
		return formacionDao.deleteFormacion(id_formacion);
	}

	
	
	

}
