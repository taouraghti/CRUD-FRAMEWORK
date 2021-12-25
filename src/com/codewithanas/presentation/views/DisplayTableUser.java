package com.codewithanas.presentation.views;

import com.codewithanas.entites.User;
import com.codewithanas.presentation.models.TableModelManager;

public class DisplayTableUser extends DisplayTable<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayTableUser(TableModelManager<User> model) {

		super(model);
		this.setVisible(true);
	}

}
