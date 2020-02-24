package SavingsAccount;

class SavingsAccount {

	  //creates variable annualInterestRate to store annual interest rate & creates variable savingsBalance which indicates amount currently on deposit
    private static double annualInterestRate;
    private double savingsBalance;
    private double monthlyInterest;
    
    
 


  /*  public SavingsAccount(double d) {
		// TODO Auto-generated constructor stub
	} */

	//main
    public static void main(String[] args) {
		
	}
    
  /* public SavingsAccount(double savingsBalance)
   {
	   //keyword this is used because we are passing the variable used inside this method as an argument for this method as noted from stackoverflow user Donal Boyle
	   this.savingsBalance = savingsBalance; 
   } */
   
 

public SavingsAccount(double savingsBalance) {
	// TODO Auto-generated constructor stub
	this.savingsBalance = savingsBalance;
}

public void calculateMonthlyInterest() {
	   //calculates monthlyInterest based on savingsBalance multiplied by the annualInterest rate divided by 12
	   monthlyInterest = (savingsBalance * annualInterestRate) / 12;
	   
	   //calculates new savings
	   savingsBalance += monthlyInterest;
   }
   
   public static void modifyInterestRate( double newRate ) {
	   //sets annualInterestRate to a new value
	   annualInterestRate = newRate;
	   
   }
   
   public void showSavings() {
	   //makes sure monthly interest is calculated and prints out the message displaying each users balance
	   calculateMonthlyInterest();
	   System.out.println("Your balance is $" + savingsBalance);
	   
   }
}