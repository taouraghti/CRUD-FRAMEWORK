package com.codewithanas.presentation.models;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public abstract class TableModelManager<T> extends AbstractTableModel {
    protected ArrayList<T> modelList;

    /*public TableModelManager(ArrayList<T> modelList) {
        super();
        this.modelList = modelList;
    }*/

    @Override
    public int getRowCount() {
        return this.modelList.size();
    }


    public ArrayList<T> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<T> modelList) {
        this.modelList = modelList;
    }
}
