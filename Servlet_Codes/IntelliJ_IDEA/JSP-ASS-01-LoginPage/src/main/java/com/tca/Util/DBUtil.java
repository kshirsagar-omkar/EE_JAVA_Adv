package com.tca.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb19?sslmode=disable";
    public final static String DB_USER = "root";
    public final static String DB_PASS = "root@123";
    public final static String DB_DRIVER = "org.postgresql.Driver";


    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("\n\n\nException in DBUtil Class :" + e.getMessage() + "\n\n\n");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
