package com.tca.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb19?sslmode=disable";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root@123";
    private static final String DB_DRIVER = "org.postgresql.Driver";


    static {
        try{
            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL driver missing!" + e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
