package com.codewithanas.presentation.controllers;

import com.codewithanas.metier.Manager;
import com.codewithanas.presentation.models.TableModelManager;
import com.codewithanas.presentation.views.AddView;
import com.codewithanas.presentation.views.TableView;

import java.util.ArrayList;

public class ControllerManager<T, typeId> {

	private TableView tableView;
	private AddView addView;
	private Manager manager;
	protected ArrayList<T> listObjects;
	protected TableModelManager<T> model;

	public void init(){
		this.listObjects = this.manager.getAll();
		this.model.setModelList(this.listObjects);
	}

	public void setTableView(TableView tableView) {
		System.out.println("Display invoked");
		this.tableView = tableView;
	}

	public void setAddView(AddView addView) {
		this.addView = addView;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void displayAll(){
		this.init();
		this.tableView.init();
		this.tableView.setVisible(true);
	}

	public void displayAddView(){
		this.addView.draw();
		this.addView.setVisible(true);
	}

	public T save(T object){
		T beanToSave = (T) manager.save(object);
		this.displayAll();
		return beanToSave;
	}

	public void delete(typeId id)
	{
		manager.deleteObject(id);
		this.tableView.dispose();
		this.displayAll();
	}

	public TableView getTableView() {
		return tableView;
	}

	public AddView getAddView() {
		return addView;
	}

	public Manager getManager() {
		return manager;
	}

	public ArrayList<T> getListObjects() {
		return listObjects;
	}

	public void setListObjects(ArrayList<T> listObjects) {
		this.listObjects = listObjects;
	}

	public TableModelManager<T> getModel() {
		return model;
	}

	public void setModel(TableModelManager<T> model) {
		this.model = model;
	}
}