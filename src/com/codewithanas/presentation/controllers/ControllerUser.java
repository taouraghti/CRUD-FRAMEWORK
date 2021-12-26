package com.codewithanas.presentation.controllers;

import java.util.ArrayList;

import com.codewithanas.entites.User;
import com.codewithanas.metier.UserManager;
import com.codewithanas.presentation.models.TableModelManager;
import com.codewithanas.presentation.models.TableModelUser;
import com.codewithanas.presentation.views.AddUserView;
import com.codewithanas.presentation.views.TableUserView;

public class ControllerUser extends ControllerManager<User, Integer> {

	@Override
	public void init(){
		this.listObjects = new UserManager().getAll();
		this.model = new TableModelUser(listObjects);
		this.setTableView(new TableUserView(model));
	}

}
