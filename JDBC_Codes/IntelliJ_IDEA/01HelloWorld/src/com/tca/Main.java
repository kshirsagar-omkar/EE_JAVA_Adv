package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public final static String URL = "jdbc:postgresql://localhost:5432/ee_java_db?ssl=true&sslmode=require";
    public final static String USER = "root";
    public final static String PASSWORD = "root@123";
    public final static String DRIVER = "org.postgresql.Driver";


    public static Connection conn = null;
    public static PreparedStatement ps = null;

    public static void main(String[] args) {

        try{

            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            ps = conn.prepareStatement("INSERT INTO student VALUES(106, 'FFF', 99.87)");
            ps.executeUpdate();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        System.out.println("Hello, World!");


    }
}