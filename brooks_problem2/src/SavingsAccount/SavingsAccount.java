package SavingsAccount;

class SavingsAccount {

	  //creates variable annualInterestRate to store annual interest rate & creates variable savingsBalance which indicates amount currently on deposit
    private static double annualInterestRate;
    private double savingsBalance;
    private double monthlyInterest;
    
    
 



	//main
    public static void main(String[] args) {
		
	}
    

	  
	public SavingsAccount(double savingsBalance) {
		
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