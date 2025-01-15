package com.tca;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("ALL")
public class Main {

    public final static String URL = "jdbc:postgresql://localhost:5432/ee_java_db?sslmode=disable";
    public final static String USER = "root";
    public final static String PASSWORD = "root@123";
    public final static String DRIVER = "org.postgresql.Driver";


    public static Connection conn = null;
    public static Statement stmt = null;



    public static void main(String[] args) {

        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);


            conn.setAutoCommit(false);


            stmt = conn.createStatement();


            stmt.addBatch("INSERT INTO student VALUES(111,'AAA', 99)");
            stmt.addBatch("INSERT INTO student VALUES(222,'BBB', 80)");
            stmt.addBatch("INSERT INTO student VALUES(333,'CCC', 73)");


            stmt.executeBatch();


            conn.commit();
        } catch (Exception e) {
            try{
                conn.rollback();
                System.out.println("----------ROLLBACK----------");
            }
            catch (Exception ex){
                e.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}