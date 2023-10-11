import java.sql.*;

public class ConnectionClass 
{
    Connection conn;
    Statement stm;
    
    ConnectionClass()
    {
        try 
        {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "hms";
            String userName = "root";
            String password = "1234";

            conn = DriverManager.getConnection(url+db, userName, password);
            stm = conn.createStatement();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        new ConnectionClass();
    }
}

