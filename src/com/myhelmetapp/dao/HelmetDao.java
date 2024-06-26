package com.myhelmetapp.dao;

import java.util.List;

import com.myhelmetapp.model.Helmet;


public interface HelmetDao {
	int addhelmet(Helmet h);
	List<Helmet> findHelmet();
	Helmet findhelmetByName(String Brand);
	int updatehelmet(Helmet h);
	int deletehelmetByName(String Brand);
	void deleteallhelmet();



}
