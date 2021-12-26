package com.codewithanas.persistance;

import java.util.ArrayList;
import java.sql.*;

import com.codewithanas.entites.User;

public class DaoUser implements Dao<User, Integer> {

	@Override
	public User save(User user) {
		try {
			Statement st = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
			String query = "insert into user values('"+user.getId()+"','"+user.getName()+"')";
			st.executeUpdate(query);
			return user;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getObject(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteObject(Integer id) {

		try{
			Statement st = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
			String query = "delete from user where id='"+id+"'";
			st.executeUpdate(query);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User updateObject(Integer id, User newObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			Statement st = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
			String query = "select * from user";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				User user = new User();
			 
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				
				users.add(user);
			}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
