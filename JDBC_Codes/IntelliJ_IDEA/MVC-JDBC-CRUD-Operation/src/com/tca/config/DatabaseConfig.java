package com.tca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private DatabaseConfig(){}

    private static final String DB_URL = "jdbc:postgresql://localhost/ee_java_db?sslmode=disable";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root@123";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static Connection conn = null;

    static {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch( Exception e ) {
            System.out.println( "Failed to load database driver OR Form A DB Connection!: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        if(conn == null || conn.isClosed() ) {
            throw new SQLException("Connection not formed or closed !!");
        }
        return conn;
    }


    public static void closeConnection() throws SQLException{
        if(conn == null || conn.isClosed()){
            throw new SQLException("Connection not formed or closed already!!");
        }
        conn.close();
    }



}
