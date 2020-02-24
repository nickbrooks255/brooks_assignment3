import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;

public class CA4 {
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		
		//creating new SecureRandom named rand
		SecureRandom rand = new SecureRandom();
		
		//setting a counting variable to 0 to begin with, counts amount user has gotten correct
		int correctCount = 0;
		
		int difficulty = readDifficulty();
		System.out.println();
		
		//for loop to create a total of 20 one-digit integers, 10 firstNum ints and 10 secondNum ints to pair together, creating a total of 10 problems to solve
		for(int i = 0; i <11; i++) {
			//generating the two integers based on difficulty level chosen via generateQuestionArgument()
			int firstNum = generateQuestionArgument(rand, difficulty);
			int secondNum = generateQuestionArgument(rand, difficulty);
			
			
			//multiples the two random numbers to find product
			int correctAnswer = firstNum * secondNum;
		
		//while(true) reiterates the loop until is broken - noted from stackoverflow user RayZe
		while(true) {
			//calls method askQuestion to print out the multiplication problem
			askQuestion(firstNum, secondNum, i);
			
			//sets int userAnswer to the users input as stored in readResponse()
			int userAnswer = readResponse();
			
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
			
		//calls displayCompletionMessage to present user their score and respective outputs, then resets counter int to 0 and calls quiz() for another set of 10 questions	
		displayCompletionMessage(correctCount);	
		
}
	
	public static int generateQuestionArgument(SecureRandom rand, int difficulty)
	{
		int a = 0;
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
	
	public static int readDifficulty() {
		
		System.out.println("Select difficulty level 1-4:");
		
		int u;
		//creates new scanner to read user input
		Scanner diff = new Scanner(System.in);
		//sets int answer to users input
		u = diff.nextInt();
		
		//returns users answer
		return u;
		
	}

	public static void askQuestion(int firstNum, int secondNum, int i) {
		
		//prints out "How much is firstNum times secondNum?", with their respective values
		System.out.println("How much is " + firstNum + " times " + secondNum +"?");
		
	}
	
	public static int readResponse() {
		int uAnswer;
		
		//creates new scanner to read user input
		Scanner scan = new Scanner(System.in);
		//sets int answer to users input
		uAnswer = scan.nextInt();
		
		//returns users answer
		return uAnswer;
	}
	
	public boolean isAnswerCorrect(int correctAnswer, int userAnswer) {
		
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
	
	public static void displayCompletionMessage(int correctCount) {
		//if user got at least 75% correct, output congratulatory message. if user got less than 75%, output other message
				if((correctCount/10) > 0.74) {
					
					System.out.println("Congratulations, you are ready to go to the next level!\n Try a new set?\n 1. Yes\n 2. No");
					
				}
				
				else {
					
					System.out.println("Please ask your teacher for extra help.\n Try a new set?\n 1. Yes\n 2. No");
				}
		
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		//if user selects number 1, reset counter and run through quiz again. else exit
		if(select == 1) {
			correctCount = 0;
			quiz();
		}
		
		else
			System.exit(0);
	}
}


