package com.codewithanas;

import com.codewithanas.persistance.DatabaseConnection;
import com.codewithanas.presentation.controllers.ControllerUser;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            DatabaseConnection con = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/framework_crud", "root", "", "com.mysql.cj.jdbc.Driver");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new ControllerUser().getDisplayTable();
    }
}
