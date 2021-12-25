package com.codewithanas.presentation.controllers;

import com.codewithanas.presentation.views.DisplayTable;

public abstract class ControllerManager<T, typeId> {

	private DisplayTable displayTable;

	public DisplayTable getDisplayTable() {
		return displayTable;
	}


	public void setDisplayTable(DisplayTable displayTable) {
		System.out.println("Display invoked");

		this.displayTable = displayTable;
	}

	
}