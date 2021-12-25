package com.codewithanas.presentation.controllers;

import java.util.ArrayList;

import com.codewithanas.entites.User;
import com.codewithanas.metier.UserManager;
import com.codewithanas.presentation.models.TableModelManager;
import com.codewithanas.presentation.models.TableModelUser;
import com.codewithanas.presentation.views.DisplayTableUser;

public class ControllerUser extends ControllerManager<User, Integer> {

	private ArrayList<User> users;
	private TableModelManager<User> model;
	private DisplayTableUser displayTableUser;

	public ControllerUser() {
		this.users = new UserManager().getAll();
		System.out.println(users.get(0).getName());
		this.model = new TableModelUser(users);
		this.displayTableUser = new DisplayTableUser(model);
		this.setDisplayTable(displayTableUser);
	}
	
}
