package com.codewithanas.metier;

import java.util.ArrayList;

public interface Manager<T, typeId> {

	public T save(T object);
	public T getObject(typeId id);
	public Boolean deleteObject(typeId id);
	public T updateObject(typeId id, T newObject);
	public ArrayList<T> getAll();
}
