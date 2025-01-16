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
                Integer rno = null;
                String name = null;
                Double per = null;

                while( (line = reader.readLine()) != null ){
                    String token[] = line.split(",");

                    if( token.length != 3 ){
                        System.out.println("Invalid Record!!");
                        continue;
                    }


                    try{
                        rno = Integer.parseInt(token[0]);
                        name = token[1];
                        per = Double.parseDouble(token[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid Record While Parsing!!");
                        System.out.println(e.getMessage());
                        continue;
                    }


                }

            }
            catch (Exception e) {
                System.out.println("Something went wrong while doing file operations !");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
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