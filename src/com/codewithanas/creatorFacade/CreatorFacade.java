package com.codewithanas.creatorFacade;

import com.codewithanas.metier.Manager;
import com.codewithanas.persistance.Dao;
import com.codewithanas.persistance.DatabaseConnection;
import com.codewithanas.presentation.controllers.ControllerManager;
import com.codewithanas.presentation.models.TableModelManager;
import com.codewithanas.presentation.views.AddView;
import com.codewithanas.presentation.views.TableView;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class CreatorFacade<T, typeId> {

    private Manager<T, typeId> manager;
    private Dao<T,typeId> dao;
    private AddView<T,typeId> addView;
    private TableView<T,typeId> tableView;
    private TableModelManager<T> tableModelManager;
    private ControllerManager<T, typeId> controllerManager;
    private HashMap<String,String> configHashMap;

    public CreatorFacade() {
        this.controllerManager = new ControllerManager<T,typeId>();
    }

    public CreatorFacade(String configFile){
        configHashMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(configFile));
            while (scanner.hasNext())
            {
                String[] arr = scanner.next().split("=");
                //System.out.println("{" + arr[0] + "}");
                if(arr[0].equals("pass") && arr.length == 1)
                    configHashMap.put(arr[0],"");
                else
                    configHashMap.put(arr[0],arr[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        this.controllerManager = new ControllerManager<T,typeId>();
        try {
            this.tableModelManager = (TableModelManager) Class.forName(this.configHashMap.get("tableModel")).newInstance();
            this.manager = (Manager) Class.forName(this.configHashMap.get("manager")).newInstance();
            this.tableView = (TableView) Class.forName(this.configHashMap.get("tableView")).newInstance();
            this.addView = (AddView) Class.forName(this.configHashMap.get("addView")).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreatorFacade(Manager<T, typeId> manager, Dao<T, typeId> dao, AddView<T, typeId> addView, TableView<T, typeId> tableView, TableModelManager<T> tableModelManager) {
        this.manager = manager;
        this.dao = dao;
        this.addView = addView;
        this.tableView = tableView;
        this.tableModelManager = tableModelManager;
        this.controllerManager = new ControllerManager<T,typeId>();

    }

    public void init(){

        try {
            DatabaseConnection con = DatabaseConnection.getInstance(this.configHashMap.get("url"), this.configHashMap.get("name"), this.configHashMap.get("pass"), this.configHashMap.get("driver"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        controllerManager.setManager(this.manager);
        controllerManager.setModel(this.tableModelManager);

        /** init add view **/
        this.addView.setController(this.controllerManager);
        controllerManager.setAddView(this.addView);

        /** init Table view **/
        this.tableView.setModel(this.tableModelManager);
        this.tableView.setController(this.controllerManager);

        controllerManager.setTableView(this.tableView);
        controllerManager.displayAll();
    }



    public Manager<T, typeId> getManager() {
        return manager;
    }

    public void setManager(Manager<T, typeId> manager) {
        this.manager = manager;
    }

    public Dao<T, typeId> getDao() {
        return dao;
    }

    public void setDao(Dao<T, typeId> dao) {
        this.dao = dao;
    }

    public AddView<T, typeId> getAddView() {
        return addView;
    }

    public void setAddView(AddView<T, typeId> addView) {
        this.addView = addView;
    }

    public TableView<T, typeId> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<T, typeId> tableView) {
        this.tableView = tableView;
    }

    public TableModelManager<T> getTableModelManager() {
        return tableModelManager;
    }

    public void setTableModelManager(TableModelManager<T> tableModelManager) {
        this.tableModelManager = tableModelManager;
    }

    public ControllerManager<T, typeId> getControllerManager() {
        return controllerManager;
    }

    public void setControllerManager(ControllerManager<T, typeId> controllerManager) {
        this.controllerManager = controllerManager;
    }
}
