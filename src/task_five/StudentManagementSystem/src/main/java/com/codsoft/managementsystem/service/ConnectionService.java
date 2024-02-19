package com.codsoft.managementsystem.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static final String URL = "jdbc:mysql://localhost:3306/student_ms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Darasimi@1";

    public static Connection connector() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Caused by: " + e.getCause());
        }
        return null;
    }

}
