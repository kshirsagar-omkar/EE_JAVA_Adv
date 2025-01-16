package com.tca;

import com.tca.config.DatabaseConfig;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SuppressWarnings("ALL")
public class Main {

    public static Connection conn = null;
    public static PreparedStatement ps = null;

    public static void main(String[] args) {

        try{

            Class.forName(DatabaseConfig.DRIVER);
            conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);


            conn.setAutoCommit(false);
            ps = conn.prepareStatement("INSERT INTO student VALUES (?,?,?)");


            try(BufferedReader reader = new BufferedReader( new FileReader("src/resources/data.csv"))){

                String line = null;

                while( (line = reader.readLine()) != null ){
                    String token[] = line.split(",");

                    try{
                        if( token.length != 3 ){
                            throw new Exception("Invalid Record From File");
                        }

                        ps.setInt(1,Integer.parseInt(token[0]));
                        ps.setString(2,token[1]);
                        ps.setDouble(3,Double.parseDouble(token[2]));

                        ps.executeUpdate();
                    }
                    catch (Exception e) {
                        System.out.println("\nUnable to add {" + line + " } Record!!");
                        System.out.println(e.getMessage()+"\n");
                        conn.rollback();

                        //Add this Record to log
                        continue;
                    }
                    conn.commit();
                    System.out.println("Record {" + line + " } Added Successfully!!");
                }

                System.out.println("\n\nData Migration Process Done!!!");

            }
            catch (Exception e) {
                System.out.println("Something went wrong while doing file operations !");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
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