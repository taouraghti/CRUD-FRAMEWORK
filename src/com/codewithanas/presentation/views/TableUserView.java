package com.codewithanas.presentation.views;

import com.codewithanas.entites.User;
import com.codewithanas.metier.UserManager;
import com.codewithanas.presentation.controllers.ControllerUser;
import com.codewithanas.presentation.models.TableModelManager;

public class TableUserView extends TableView<User, Integer> {

	private static final long serialVersionUID = 1L;

	public TableUserView(TableModelManager<User> model) {
		super(model);
		this.setController(new ControllerUser());
		this.getController().setAddView(new AddUserView());
		this.getController().setManager(new UserManager());
	}

}
