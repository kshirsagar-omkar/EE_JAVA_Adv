import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {


    public final static String DB_URL = "jdbc:postgresql://localhost:5432/ee_java_db?sslmode=disable";
    public final static String DB_USER = "root";
    public final static String DB_PASS = "root@123";
    public final static String DB_DRIVER = "org.postgresql.Driver";


    public static Connection conn = null;
    public static CallableStatement cs = null;
    public static ResultSet rs = null;


    public static void main(String[] args) {




        try{

            Class.forName(DB_DRIVER);

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            cs = conn.prepareCall("SELECT display(?)");
            cs.setInt(1, 101);

            
            rs = cs.executeQuery();

            rs.next();

            System.out.println("This msg is from Postgresql : " + rs.getString(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}