import java.sql.*;
import java.sql.DriverManager;

public class MySqlConnection
{    
	static Connection connection;
       public Connection databaseConnection() throws Exception
       {
    	   try
    	   {
    		   String url="jdbc:mysql://localhost:3306/aspire_bank_database";
        	   String username="root";
        	   String pass="@Smija117";
        	   
        	   connection=DriverManager.getConnection(url,username,pass);
        	   
    	   }
    	   catch(Exception exception)
    	   {
    		   exception.printStackTrace();
    	   }
    	   
    	   return connection;
       }
}
