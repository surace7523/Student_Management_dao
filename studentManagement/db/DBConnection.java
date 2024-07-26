package studentManagement.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;
    public static Connection createConnection(){

        try{
   Class.forName("com.mysql.cj.jdbc.Driver");
   String user = "root";
   String password ="root";
   String url = "jdbc:mysql://localhost:3306/Student?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception ex){
            ex.printStackTrace();//prints the locations where the exception occurred in the source code, thus allowing the author who wrote the program to see what went wrong.
        }

        return con;
    }
}
