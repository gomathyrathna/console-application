import java.util.*;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public  class AccountOperations{
	String transact;
	UserDetails details=new UserDetails();
	CrudOperations operations=new CrudOperations();
	Scanner scan=new Scanner(System.in);
	 Random random = new Random();
     int accountNo=random.nextInt(999999);
     int pin=random.nextInt(9999);
     java.util.Date date=new java.util.Date();
 	 Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
 	 ArrayList<String> transaction=new ArrayList<String>();
 	public void createAccount()
	{
         String firstName;
         String lastName;
         int age;
         String dob;
         String type;
         String Date;
         int balance;
         boolean flag=false;
         do
         {
        	  System.out.println("Enter First name:");
 	          firstName=scan.next();
	          if(flag==false)
	          {
	 	        Matcher match = pattern.matcher(firstName);
	 			boolean compare = match.find(); 
	            if(compare==true)
	            {
	               details.setFirstName(firstName);  
	               flag=true;
	            }
	            else
	            {
	                System.out.println("***ENTER A VALID NAME-ONLY ALPHABETS ARE ALLOWED***");
                   continue;
	            }
	          }
         }
            while(flag==false);
    	    flag=false;
    	 do
    	 {
    		 System.out.println("Enter Last name:");
 	         lastName=scan.next();
 	         if(flag==false)
 	          {
 	        	Matcher match1 = pattern.matcher(lastName);
 				boolean compare = match1.find();  
 	            if(compare==true)
 	            {
 	               details.setLastName(lastName); 
 	               flag=true;
 	            }
 	            else
 	            {
 	               System.out.println("***ENTER A VALID NAME-ONLY ALPHABETS ARE ALLOWED***");
 	               continue;
 	            }
    	      }
	        }
    	    while(flag==false);
	        flag=false;
	        while(true) {
	        	System.out.println("Enter date of birth in YYYY-MM-DD format:");
	 	        dob=scan.next();
		        LocalDate dateOfBirth=LocalDate.parse(dob);
		        LocalDate currentDate=LocalDate.now();
		        age=Period.between(dateOfBirth,currentDate).getYears();
		        if(age<18||age>120)
		        {
		        	System.out.println("***ENTER A VALID AGE(>18 and <120)***");
		        	continue;
		        	
		        }
		        else
		        {
		        	details.setAge(age);
		        	break;
		        }
	        }
	        scan.nextLine();
	        System.out.println("Enter the account type(savings or current):");
	        type=scan.next();
	        details.setType(type);
	      do
	       {
	        System.out.println("Enter account balance:(minimum balance is Rs:1000)");
	        balance=scan.nextInt();
	        if(flag==false)
	        {
	        	if(balance>1000)
	        	{
	    	        details.setBalance(balance);
                     flag=true;
	        	}
	        	else
	        	{
	        		System.out.println("***ENTER AN AMOUNT GREATER THAN 1000***");
		            continue;
	        	}
	        }	
	      }
	        while(flag==false);
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	        Date = formatter.format(date); 
	        details.setDate(Date);
	        details.setAccountNumber(accountNo);
	        details.setPinNumber(pin);
	        boolean result =operations.AccountCreation(details);
	        if(result==true)
	        {
	        	System.out.println("***ACCOUNT CREATED***");
	        	System.out.println("Your Account number is:"+accountNo);
	        	System.out.println("Your Pin number is:"+pin);
		       
	        }
	}
 	    public void display() {
	    	System.out.println("Name:"+details.getFirstName()+" "+details.getLastName());
	    	System.out.println("Age:"+details.getAge());
	    	System.out.println("AccountNumber:"+details.getAccountNumber());
	    	System.out.println("Balance:"+details.getBalance());
	    	System.out.println("Date of Creation:"+details.getDate());
	    	System.out.println("Account Type:"+details.getType());
	    }
		public void deposit(){
			int amount;
		    System.out.println("Enter the amount you want to deposit:");
		    amount=scan.nextInt();
		    int balance=details.getBalance()+amount;
		    System.out.println("***AMOUNT DEPOSITED SUCCESSFULLY!***\n Current balance is "+balance);
            operations.balanceUpdate(pin, balance);
            details.setBalance(balance);
            transact="amount'"+amount+"' is deposited by '" +details.getFirstName()+"'";
            transaction.add(transact);
		}
		public void withdraw()
		{
			int amount;
			while(true)
			{
				System.out.println("Enter the amount to withdraw:(Minimum balance must be 1000)");
			    amount=scan.nextInt();
			    int balance=details.getBalance();
			    if(balance<1000||balance-amount<1000)
			    {
	                 System.out.println("***INSUFFICIENT FUNDS-TRANSACTION FAILED***");
	                 continue;
			    }
		        else
		        {
		    	   balance=balance-amount;
		           System.out.println("***AMOUNT WITHDRAWN SUCCESSFULLY!***\n Current Balance in account:"+balance);
		           operations.balanceUpdate(pin, balance);	
		           details.setBalance(balance);
		           transact="amount'"+amount+"' is withdrawn by '" +details.getFirstName()+"'";
		           transaction.add(transact);
		           break;
		        }
		     }
		}
		public void interest(){
		    int principal;
		    int rate=10;
		    int time;
		    int option;
		    double interest;
		    System.out.println("Enter the principal amount");
			principal=scan.nextInt();
			System.out.println("Enter the time period");
			time=scan.nextInt();
			System.out.println("Press1:For simple interest\nPress2:For complex interest");
			option=scan.nextInt();
			if(option==1){
				System.out.println("***INTEREST OF THE ACCOUNT IS:'"+(principal*time*rate)/100+"'***");

			}
			else if(option==2)
			{
				int number;
				System.out.println("Enter the number of times the interest is compounded:");
				number=scan.nextInt();
				interest=principal*(Math.pow ((1+rate/number),(time*number)));
				System.out.println("***INTEREST OF THE ACCOUNT IS:'"+interest+"'***");
			}
		}
		public boolean pinNumberValidation(int verifyPin) {
			if(verifyPin==pin)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		public void getLatestTransactions()
    	{
    		System.out.println(transaction);
    	}
			
}
