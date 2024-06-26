package com.myhelmetapp.service;

import java.util.List;

import com.myhelmetapp.dao.HelmetDao;
import com.myhelmetapp.dao.HelmetDaoImpl;
import com.myhelmetapp.model.Helmet;


public class HelmetServiceImpl implements HelmetService {
	private HelmetDao dao = new HelmetDaoImpl();

	@Override
	public int addHelmet(Helmet h) {
		// TODO Auto-generated method stub
		return dao.addhelmet(h);
	}

	@Override
	public List<Helmet> findHelmet() {
		// TODO Auto-generated method stub
		return dao.findHelmet();
	}

	@Override
	public Helmet findHelmet(String Brand) {
		// TODO Auto-generated method stub
		return dao.findhelmetByName(Brand);
	}

	@Override
	public int updateHelmet(Helmet h) {
		// TODO Auto-generated method stub
		return dao.updatehelmet(h);
	}

	@Override
	public int deleteHelmetByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.deletehelmetByName(Brand);
	}

	@Override
	public void deleteallHelmet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Helmet findHelmetByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.findhelmetByName(Brand);
	}



	

}
