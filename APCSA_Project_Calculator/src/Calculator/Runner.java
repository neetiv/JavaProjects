package Calculator; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;

/* This class runs the calculator as well as instantiates all objects, variables, and lists
 * it also takes user input and error checks all given input to avoid exceptions
 */

public class Runner{
	public static void main(String args[]) {
		
		List<String> Operations = new ArrayList<String>(); //creates list with all the values to be printed
		Operations.add("Exit");
		Operations.add("Addition");
		Operations.add("Subtraction");
		Operations.add("Multiplication");
		Operations.add("Division");
		Operations.add("Exponents/Powers");
		
		Math calc = new Math(); //instantiating object calculator to carry out calculations via Math class
		Scanner scanner = new Scanner(System.in); 
		
		int x = Operations.size(); //instantiating all variables
		int ans =0; 
		float num1 = 0;
		float num2 = 0;

		
		while(true){
			System.out.println("What operation would you like to conduct?");
			
			for (int i=0; i<x; i++) { //for loop prints all available operations
				//used a for loop so that if another operation is added it will automatically print
				System.out.println(""+i+": "+ Operations.get(i));
			}
			
			
			try {
				ans = scanner.nextInt(); //scanner takes user input
			} catch(Exception e) {
				System.out.println("""
						Invalid value, please enter an integer from the list above
						"""); //if the given value is not an integer, the program will send out an exception error message
				continue; // try/catch gives a condition to what should happen if there is an exception
			} //if invalid, prints error message and restarts program
			
			if (!(ans>=0 && ans<=x)) { //if the number is not within the list the value is still invalid
				System.out.println("""
						Invalid value, please enter an integer from the list above
						""");
				continue;
			}

			
			if (calc.endProgram(ans)) {
				System.out.println("stopping calculator"); //if they select the exit option, the calculator is stopped
				break;
			}
			
			else {
			
				System.out.println("enter your first number"); //taking input for first number to be calculated
				try {
					num1 = scanner.nextFloat();
				} catch(Exception e) {
					System.out.println("""
							Invalid value, please enter an integer or decimal
							""");
					continue;
				}
				
				System.out.println("enter your second number"); //taking input for second number to be calculated
				try {
					num2 = scanner.nextFloat();
				}catch(Exception e){
					System.out.println("""
							Invalid value, please enter an integer or decimal
							""");
					continue;
				}
				
				calc.solveMath(ans, num1, num2); //uses calc method from Math.java to calculate and print the answer
			}
		}	
	}
}