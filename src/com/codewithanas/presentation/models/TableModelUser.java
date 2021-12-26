package com.codewithanas.presentation.models;

import java.util.ArrayList;

import com.codewithanas.entites.User;

public class TableModelUser extends TableModelManager<User> {

	public TableModelUser(ArrayList<User> modelList) {
		super(modelList);
		//TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0 : return modelList.get(rowIndex).getId();
		case 1 : return modelList.get(rowIndex).getName();
		default : return null;
		}	
	}
	
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "id";
		case 1 : return "name";
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return Integer.class;
		case 1 : return String.class;
		default : return Object.class;
		}
	}
	
}
