/*
 * Title: Online banking Application
 * Author:Gomathy Rathna.S
 * Created at:1 Dec 2021
 * Reviewed by:Akshaya Rajagopal
 * Modified at:18 Jan 2021
 */
import java.util.*;
public abstract class BankingApp  {
	 

	public static void main(String[] args) {
        int pinNumber;
        int selection;
        boolean answer;
        AccountOperations operations = new AccountOperations();
        Scanner scanner= new Scanner(System.in);
        System.out.println("*******WELCOME TO ASPIRE BANKING SYSTEM*******");
        do{
        System.out.println("*****Choose the operation to perform*****");
        System.out.println("Press0:To create an account\nPress1:To display the account details\nPress2:To deposit amount\nPress3:To withdraw amount\nPress4:To find interest\nPress5:To Get Transaction Details\nPress6:To Exit");
        selection=scanner.nextInt();
        switch(selection)
        { 
            case 0:
            	operations.createAccount();
            	break;
            case 1:
            	System.out.println("Enter your pin number:");
            	pinNumber=scanner.nextInt();
            	answer=operations.pinNumberValidation(pinNumber);
            	if(answer==false)
            	{
            		System.out.println("***INCORRECT PIN***");
            	}
            	else
            	{
            	      operations.display();
            	}
                break;
            case 2:
            	System.out.println("Enter your pin number:");
            	pinNumber=scanner.nextInt();
            	answer=operations.pinNumberValidation(pinNumber);
            	if(answer==false)
            	{
            		System.out.println("***INCORRECT PIN***");
            	}
            	else
            	{
                    operations.deposit();
            	}
                break;
            case 3:
            	System.out.println("Enter your pin number:");
            	pinNumber=scanner.nextInt();
            	answer=operations.pinNumberValidation(pinNumber);
            	if(answer==false)
            	{
            		System.out.println("***INCORRECT PIN***");            
            	}
            	else
            	{
            		
            			operations.withdraw();
            	}
                break;
            case 4:
            	System.out.println("Enter your pin number:");
            	pinNumber=scanner.nextInt();
            	answer=operations.pinNumberValidation(pinNumber);
            	if(answer==false)
            	{
            		System.out.println("***INCORRECT PIN***");
            	}
               else
            	{
            	    operations.interest();
            	}
            	break;
            case 5:
            {
            	operations.getLatestTransactions();
            	break;
            }
            case 6:
                System.out.println("Thank you!..Visit Again!!");
                System.exit(0);
            default:
            	System.out.println("***SELECT A VALID INPUT(0-5)***");
            	BankingApp.main(null);
                	
        }
        }
        while(selection<=5);
    	scanner.close();

		}
	
}
