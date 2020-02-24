package SavingsAccount;

public class SavingsAccountTest {
	
	

	public static void main(String[] args) {
		
		//instantiates saver1 and saver2 objects of SavingsAccount, and gives them values as given in rubric
		SavingsAccount saver1 = new SavingsAccount(2000.00d);
		SavingsAccount saver2 = new SavingsAccount(3000.00d);
		
		//sets new interest rate to 4%
		SavingsAccount.modifyInterestRate(4);
		 System.out.println("Balance when annual interest rate =  4%");
		 
		 //calculates monthly interest while rate is 4%
		  saver1.calculateMonthlyInterest();
	      saver2.calculateMonthlyInterest();
	      
	      //displays both users savings balances while rate is 4%
	      saver1.showSavings();
	      saver2.showSavings();
	      
	    //sets new interest rate to 5%
	      SavingsAccount.modifyInterestRate(5);
	      System.out.println("Balance when annual interest rate = 5%");
	      
	    //calculates monthly interest while rate is 5%
	      saver1.calculateMonthlyInterest();
	      saver2.calculateMonthlyInterest();
	      
	      //displays both users savings balances while rate is 5%
	      saver1.showSavings();
	      saver2.showSavings();
		
	}
	


}
