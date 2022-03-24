public class UserDetails  {
	private String firstName;
    private String lastName;
    private int age;
    private int balance;
    private String type;
    private String date;
    private int acNo;
    private int pin;
    //getter
     
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    } 

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
   
    public int getAge()
    {
       return age;
    }
    public void setAge(final int age) 
    {    
     this.age=age;  
    } 

   public String getType()
   {
       return type;
   }
   
   public void setType(String type)
   {
       this.type=type;
   } 

   public int getBalance()
   {
	   return balance;
   }
   public void setBalance(final int balance)
   {
	   this.balance=balance;
   }
   public String getDate()
   {
	   return date;
   }
   public void setDate(String date)
   {
	   this.date=date;
   }
    
  public int getAccountNumber()
  {
	  return acNo;
  }
  public void setAccountNumber(final int acNo)
  {
	  this.acNo=acNo;
  }
  public int getPinNumber()
  {
	  return pin;
  }
  public void setPinNumber(final int pin)
  {
	  this.pin=pin;
  }

}
