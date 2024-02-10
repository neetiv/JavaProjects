package Calculator;

/*
 * Within this class are methods that allow the calculator to run and completes all the operations for said calculator
 */

public class Math{

	private int ans = 0;
	private String op = "";
	public float num;
	
	/*
	 * The boolean method endProgram takes the integer parameter ans, which represents the chosen operation
	 * ans also holds whether or not the user wants the program to end
	 * the endProgram method returns true if the user selects "0" from the menu, which is attributed to exiting the program
	 * and false if otherwise
	 */
	
	public boolean endProgram(int ans) { //if the option to end the program is selected return true, else false
		if (ans == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * The void method solveMath takes the integer parameter of ans which represents the chosen operation and
	 * the float parameters of num1 and num2 which are the numbers to be calculated
	 * while the method is void, it does print the final calculated value
	 */
	
	public void solveMath(int ans, float num1, float num2) { //conducts all operations
		this.ans = ans;
		
		if (this.ans == 1) { //addition
			num = num1 + num2;
			op = "+";
		}
		else if (this.ans ==2) { //subtraction
			num = num1 - num2;
			op="-";
		}
		else if (this.ans == 3) { //multiplication
			num = num1*num2;
			op = "*";
		}
		else if (this.ans == 4) { //division
			num = num1/num2;
			op = "÷";
		}
		else if (this.ans == 5) { //exponents
			float val = num1;
			for (int g = 2; g<=num2; g++) { //multiplies value by itself as many times as asked by user
				num = val*num1;
				val = num;
			}
			op = "^";
		}
		
		System.out.println(num1 + op + num2 + " = " + num); //prints answer
		System.out.println();
	}
}