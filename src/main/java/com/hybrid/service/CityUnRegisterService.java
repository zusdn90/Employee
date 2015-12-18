package com.hybrid.service;


import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;

public class CityUnRegisterService {

	CityDao cityDao;
	
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	@Transactional
	public int unregist(int id) {
		
		cityDao.deleteById(id);
		
		return id;
	}
}
