package com.db.ridebooking.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

//    PostgreSQL properties
//    private static final String URL = "jdbc:postgresql://localhost:5432/ridebooking";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "root";

//  MySQL properties
    private static final String URL = "jdbc:mysql://localhost:3306/ridebooking";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
