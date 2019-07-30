package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Admin;
import dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	public Admin comprobarLogin(String user, String admin) {
		return adminDao.comprobarLogin(user, admin);
	}
	
	
}
