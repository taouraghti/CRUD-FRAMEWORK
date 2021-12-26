package com.codewithanas;

import com.codewithanas.entites.User;
import com.codewithanas.persistance.DatabaseConnection;
import com.codewithanas.presentation.controllers.ControllerManager;
import com.codewithanas.presentation.controllers.ControllerUser;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ControllerManager<User, Integer> controllerManager = new ControllerUser();
        try {
            DatabaseConnection con = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/framework_crud", "root", "", "com.mysql.cj.jdbc.Driver");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        controllerManager.init();
        controllerManager.displayAll();
    }
}
