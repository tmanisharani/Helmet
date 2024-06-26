package com.myhelmetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.myhelmetapp.model.Helmet;
import com.myhelmetapp.util.DBUtil;

public class HelmetDaoImpl implements HelmetDao{
	static Connection con = DBUtil.getConnection(); {

}

	@Override
	public int addhelmet(Helmet h) {
		String INSERT_QUERY = "insert into Helmet(brand,price,colour,star_rating) values(?,?,?,?)";
		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, h.getBrand());
			ps.setInt(2, h.getPrice());
			ps.setString(3, h.getColour());
			ps.setString(4, h.getStar_rating());
			status = ps. executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		

	@Override
	public Helmet findhelmetByName(String Brand) {
		String SELECT_QUERY = "select * from Helmet where brand = ?";
		Helmet h = null;
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1,  Brand);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				h = new Helmet();
				h.setId(rs.getInt("Id"));
				h.setBrand(rs.getString("brand"));
				h.setPrice(rs.getInt("price"));
				h.setColour(rs.getString("colour"));
				h.setStar_rating(rs.getString("star_rating"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

		
	

	

	@Override
	public int deletehelmetByName(String Brand) {
		String DELETE_QUERY = "delete from helmet where brand=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1,Brand);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
		

	@Override
	public void deleteallhelmet() {
		String DELETE_QUERY = "delete from helmet";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}




		// TODO Auto-generated method stub
		
	


	@Override
	public List<Helmet> findHelmet() {
		String SELECT_QUERY = "select * from Helmet";
		List<Helmet> HelmetList = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Helmet h = new Helmet();
				h.setId(rs.getInt("Id"));
				h.setBrand(rs.getString("Brand"));
				h.setPrice(rs.getInt("Price"));
				h.setColour(rs.getString("colour"));
				h.setStar_rating(rs.getString("Star_rating"));
				HelmetList.add(h);

			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return HelmetList;
	}
		// TODO Auto-generated method stub
		


	@Override
	public int updatehelmet(Helmet h) {
		String UPDATE_QUERY = "update Helmet set brand=?,price=?,colour=? ,star_rating= ? where id=?";
		int status = 0;

				try {
					PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);

					ps.setString(1, h.getBrand());
					ps.setInt(2, h.getPrice());
					ps.setString(3, h.getColour());
					ps.setString(4, h.getStar_rating());
					ps.setInt(5,  h.getId());
					status = ps. executeUpdate();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
	
		
	}


	
}
