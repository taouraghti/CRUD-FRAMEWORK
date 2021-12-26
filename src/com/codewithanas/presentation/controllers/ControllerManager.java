package com.codewithanas.presentation.controllers;

import com.codewithanas.entites.User;
import com.codewithanas.metier.Manager;
import com.codewithanas.presentation.models.TableModelManager;
import com.codewithanas.presentation.views.AddView;
import com.codewithanas.presentation.views.TableView;

import java.util.ArrayList;

public abstract class ControllerManager<T, typeId> {

	private TableView tableView;
	private AddView addView;
	private Manager manager;
	protected ArrayList<T> listObjects;
	protected TableModelManager<T> model;

	public abstract void init();

	public TableView getTableView() {
		return tableView;
	}

	public void setTableView(TableView tableView) {
		System.out.println("Display invoked");
		this.tableView = tableView;
	}
	public AddView getAddView() {
		return addView;
	}
	public void setAddView(AddView addView) {
		this.addView = addView;
	}
	public void displayAll(){
		this.tableView.setVisible(true);
	}
	public void displayAddView(){
		this.addView.setVisible(true);
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public T save(T object){
		T beanToSave = (T) manager.save(object);
		this.init();
		this.displayAll();
		return beanToSave;
	}

	public void delete(typeId id)
	{
		manager.deleteObject(id);
		this.init();
		this.displayAll();
	}
}