package com.myhelmetapp.service;

import java.util.List;

import com.myhelmetapp.model.Helmet;

public interface HelmetService {
	int addHelmet (Helmet h);
	List<Helmet> findHelmet();
	Helmet findHelmet(String Brand);
	Helmet findHelmetByName(String Brand);
	int updateHelmet(Helmet h);
	int deleteHelmetByName(String Brand);
	void deleteallHelmet();


}
