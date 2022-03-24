import java.sql.*;
public class CrudOperations{
	   MySqlConnection connect=new MySqlConnection();

	 public boolean AccountCreation(UserDetails details) 
	   {
		   String query;
		   query="insert into customer_details values(?,?,?,?,?,?,?,?)";		  
		   try
		   {
			  Connection connection=connect.databaseConnection(); 
			  PreparedStatement statement=connection.prepareStatement(query);
			  
			   statement.setString(1,details.getFirstName());
			   statement.setString(2,details.getLastName());
			   statement.setInt(3,details.getAge());
			   statement.setInt(4,details.getAccountNumber());
			   statement.setInt(5,details.getPinNumber());
			   statement.setInt(6,details.getBalance());
			   statement.setString(7,details.getDate());
			   statement.setString(8, details.getType());
			   
			   statement.executeUpdate();
			   
			   
		   }
		   catch(Exception exception)
		   {
			   return false;
		   }
		   return true;
	   } 
	   public void balanceUpdate(int pinNo,int balance) 
	   {
		   String query="UPDATE customer_details SET balance='"+balance +"'WHERE pin_no='"+pinNo+"'";
		   try
		   {
			   Connection connection= connect.databaseConnection();
			   PreparedStatement statement=connection.prepareStatement(query);
			   statement.executeUpdate();
			   
		   }
		   catch(Exception exception)
		   {
			   System.out.println("Error in connecting database");
		   }
	   }
}
