package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Locale;

@SuppressWarnings("ALL")
public class Main {

    public final static String URL = "jdbc:postgresql://localhost:5432/ee_java_db?sslmode=disable";
    public final static String USER = "root";
    public final static String PASSWORD = "root@123";
    public final static String DRIVER = "org.postgresql.Driver";


    public static Connection conn = null;
    public static PreparedStatement ps = null;

    public static BufferedReader br = null;

    public static void main(String[] args) {

        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            br = new BufferedReader(new InputStreamReader(System.in));

            conn.setAutoCommit(false);

            //prepare query for inserting the student
            ps = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");

            while(true){
                System.out.print("Do you want to insert record [Yes/No]: ");
                String choice = br.readLine().toLowerCase();

                if(choice.equals("yes")){
                    System.out.print("Enter Roll Number: ");
                    ps.setInt(1, ( Integer.parseInt( br.readLine() ) ) );

                    System.out.print("Enter Name: ");
                    ps.setString(2, ( br.readLine() ) );

                    System.out.print("Enter Percentage: ");
                    ps.setDouble(3, ( Double.parseDouble( br.readLine() ) ) );

                    ps.addBatch();

                    continue;
                }
                else if(choice.equals("no")){

                    break;
                }
                else{
                        System.out.println("Wrong Choice!!");
                }

            }


            ps.executeBatch();

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
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}