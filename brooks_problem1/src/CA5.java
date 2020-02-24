import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

//for CA5, all ints have been changed to doubles to correctly calculate/enter division problems specifically, but works for each kind of problem

public class CA5 {
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		
		//creating new SecureRandom named rand
		SecureRandom rand = new SecureRandom();
		
		//setting a counting variable to 0 to begin with, counts amount user has gotten correct
		double correctCount = 0;
		
		double difficulty = readDifficulty();
		System.out.println();
		
		//double x;
		//Scanner scan;
		double probType = readProblemType();
		
		
		SecureRandom mixRand = new SecureRandom();
		
		
		//for loop to create a total of 20 one-digit integers, 10 firstNum ints and 10 secondNum ints to pair together, creating a total of 10 problems to solve
		for(double i = 0; i <11; i++) {
			//generating the two doubles based on difficulty level chosen via generateQuestionArgument()
			double firstNum = generateQuestionArgument(rand, difficulty);
			double secondNum = generateQuestionArgument(rand, difficulty);
			double correctAnswer = 0;
			
			
			
			
			double mix = mixRand.nextInt(4);
			
			//finds value of correctAnswer depending on problem type chosen
			if( probType == 1)
				correctAnswer = firstNum + secondNum;
			
			else if( probType == 2)
				correctAnswer = firstNum * secondNum;
			
			else if( probType == 3)
				correctAnswer = firstNum - secondNum;
			
			else if( probType == 4)
				correctAnswer = firstNum / secondNum;
			
			else if ( probType == 5 ) {
				
				if( mix == 1)
					correctAnswer = firstNum + secondNum;
				else if( mix == 2 ) 
					correctAnswer = firstNum * secondNum;
				else if( mix == 3 ) 
					correctAnswer = firstNum - secondNum;
				else if( mix == 4 ) 
					correctAnswer = firstNum / secondNum;
			}
		
		//while(true) reiterates the loop until is broken - noted from stackoverflow user RayZe
		while(true) {
			//calls method askQuestion to print out the multiplication problem
			askQuestion(firstNum, secondNum, i, probType, mixRand, mix);
			
			//sets double userAnswer to the users input as stored in readResponse()
			double userAnswer = readResponse();
			
			if(userAnswer == correctAnswer) {
				
				displayCorrectResponse();
				correctCount++;
				break;
			}
			
			else {
				
				displayIncorrectResponse();
				break;
			}
			
		}
		
		
	}
			
		//calls displayCompletionMessage to present user their score and respective outputs, then resets counter double to 0 and calls quiz() for another set of 10 questions	
		displayCompletionMessage(correctCount);	
		//correctCount = 0;
		//quiz();
}
	
	public static double generateQuestionArgument(SecureRandom rand, double difficulty)
	{
		double a = 0;
	      //generates how many digits in each integer based on difficulty level chosen from readDifficulty()
	       if (difficulty == 1)
	           a = rand.nextInt(10);
	       else if (difficulty == 2)
	           a = rand.nextInt(100);
	       else if (difficulty == 3)
	           a = rand.nextInt(1000);
	       else
	           a = rand.nextInt(10000);
	      
	       return a;
	}
	
	public static double readDifficulty() {
		
		System.out.println("Select difficulty level 1-4:");
		
		double u;
		//creates new scanner to read user input
		Scanner diff = new Scanner(System.in);
		//sets double answer to users input
		u = diff.nextInt();
		
		//returns users answer
		return u;
		
	}
	
	public static double readProblemType()
	{
		
		System.out.println("Select arithmetic type.\n 1. Addition\n 2. Multiplication\n 3. Subtraction\n 4. Division\n 5. Mixture");
		
		double x;
		
		//creates new scanner to read user input
				Scanner type = new Scanner(System.in);
				//sets double answer to users input
				x = type.nextInt();
				
				//returns users answer
				return x;
		
	}

	public static void askQuestion(double firstNum, double secondNum, double i, double probType, SecureRandom mixRand, double mix) {
		String word = "";
		
		
		
		//defines string word depending on problem type
		if( probType == 1)
			word = " plus ";
		else if( probType == 2 ) 
			word =" times ";
		else if( probType == 3 ) 
			word =" minus ";
		else if( probType == 4 ) 
			word =" divided by ";
		else if ( probType == 5 ) {
			
			if( mix == 1)
				word = " plus ";
			else if( mix == 2 ) 
				word =" times ";
			else if( mix == 3 ) 
				word =" minus ";
			else if( mix == 4 ) 
				word =" divided by ";
			
		}
			
		//prints out "How much is firstNum word secondNum?", where the value of word depends on problem type chosen
		System.out.println("How much is " + firstNum + word + secondNum +"?");
		
	}
	
	public static double readResponse() {
		double uAnswer;
		
		//creates new scanner to read user input
		Scanner scan = new Scanner(System.in);
		//sets double answer to users input
		uAnswer = scan.nextDouble();
		
		//returns users answer
		return uAnswer;
	}
	
	public boolean isAnswerCorrect(double correctAnswer, double userAnswer) {
		
		//compares if correctAnswer is same as userAnswer
		return correctAnswer == userAnswer;
	}
	
	public static void displayCorrectResponse() {
		//creates a new random named dCRrand
		Random dCRrand = new Random();
		
		//switch statement runs through random numbers and prints out a randomly chosen response
		switch(dCRrand.nextInt(4) + 1) {
			case 1: System.out.println("Very good!");
					break;
			case 2: System.out.println("Excellent!");
					break;
			case 3: System.out.println("Nice work!");
					break;
			case 4: System.out.println("Keep up the good work!");
					break;
		}
	}
		
		
	
	public static void displayIncorrectResponse() {
		//creates a new random named dIRrand
		Random dIRrand = new Random();
		//switch statement runs through random numbers and prints out a randomly chosen response
		switch(dIRrand.nextInt(4) + 1) {
			case 1: System.out.println("No. Please try again.");
					break;
			case 2: System.out.println("Wrong. Try once more.");
					break;
			case 3: System.out.println("Don’t give up!");
					break;
			case 4: System.out.println("No. Keep trying.");
					break;
	}
	}
	
	public static void displayCompletionMessage(double correctCount) {
		
		
		
		//if user got at least 75% correct, output congratulatory message. if user got less than 75%, output other message
		if((correctCount/10) > 0.74) {
			
			System.out.println("Congratulations, you are ready to go to the next level!\n Try a new set?\n 1. Yes\n 2. No");
			
		}
		
		else {
			
			System.out.println("Please ask your teacher for extra help.\n Try a new set?\n 1. Yes\n 2. No");
		}
		
		Scanner sc = new Scanner(System.in);
		double select = sc.nextInt();
		//if user selects number 1, reset counter and run through quiz again. else exit
		if(select == 1) {
			correctCount = 0;
			quiz();
		}
		
		else
			System.exit(0);
	}
}


