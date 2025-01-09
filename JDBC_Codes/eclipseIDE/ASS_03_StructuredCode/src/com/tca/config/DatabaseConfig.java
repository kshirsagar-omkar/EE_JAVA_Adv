package com.tca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	private static final String DB_URL = "jdbc:postgresql://localhost/ee_java_db?sslmode=disable";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root@123";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    
    
    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName(DB_DRIVER);
    	}
    	catch( ClassNotFoundException e ) {
    		throw new SQLException( "Failded to load database driver!", e);
    	}
    	return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
