package com.codewithanas.metier;

import java.util.ArrayList;

import com.codewithanas.entites.User;
import com.codewithanas.persistance.DaoUser;

public class UserManager implements Manager<User, Integer>{

	DaoUser dao = new DaoUser();

	@Override
	public User save(User object) {
		// TODO Auto-generated method stub
		return dao.save(object);
	}

	@Override
	public User getObject(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteObject(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateObject(Integer id, User newObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	
}
