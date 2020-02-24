
import java.security.SecureRandom;
import java.util.Scanner;

public class CA1 {

	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		//creating new SecureRandom named rand
		SecureRandom rand = new SecureRandom();
		//generating the two integers between 0 and 9
		int firstNum = rand.nextInt(10);
		int secondNum = rand.nextInt(10);
		//multiples the two random numbers to find product
		int correctAnswer = firstNum * secondNum;
		int userAnswer;
		
		//while(true) reiterates the loop until is broken - noted from stackoverflow user RayZe
		while(true) {
			//calls method askQuestion to print out the multiplication problem
			askQuestion(firstNum, secondNum);
			
			//sets int userAnswer to the users input as stored in readResponse()
			userAnswer = readResponse();
			
			//if user is correct, output displayCorrectReponse. if user is incorrect, output displayIncorrectReponse
			if(userAnswer == correctAnswer) {
				
				displayCorrectResponse();
				break;
			}
			
			if(userAnswer != correctAnswer) {
				
				displayIncorrectResponse();
			}
			
			
		}
	}

	public static void askQuestion(int firstNum, int secondNum) {
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
		//prints "Very good!" if userAnswer is correct
		System.out.println("Very good!");
	}
	
	public static void displayIncorrectResponse() {
		//prints "No. Please try again." if userAnswer is incorrect
		System.out.println("No. Please try again.");
	}
}

