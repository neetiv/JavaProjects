package EndofSemProject;

import java.util.Scanner;

public class MyConsole {

	public static void main(String[] args) {
		
		HangMan man = new HangMan();
		GuessWord guesser = new GuessWord(true, man);
		
		System.out.println("WELCOME TO HANGMAN");
		System.out.println();
		
		while (true) {
			
			Scanner scanOp = new Scanner(System.in);
			System.out.println("Please select an option: \n 0: exit \n 1: play");
			int ifPlay = scanOp.nextInt();
			
			if (ifPlay == 0) {
				System.out.println();
				System.out.println("********************");
				System.out.println();
				System.out.println("THANK YOU FOR PLAYING");
				break;
			}
			
			guesser.resetWord();
			guesser.setGameStat(true);
			
			while(guesser.getGameStat()) {
				Scanner scanGuess = new Scanner(System.in);
				int len = 0;
				boolean isLetter = false;
				String guess;
				
				man.printMan();
				guesser.printGuess();
				guesser.printBank();
				System.out.println();
				
				do {
					
					System.out.println();
					System.out.print("Please enter your guess (ONE LETTER PLEASE, LOWERCASE): ");
					guess = scanGuess.nextLine();
					len = guess.length();
					
					for(int i=0; i<len; i++) {
						if (Character.isLetter(guess.charAt(i))) {
							isLetter = true;
						}
					}
					
					System.out.println();
					
				}while(!isLetter && len>1);
				
				guesser.makeGuess(guess);
				if(guesser.ifWon()) {
					guesser.gameWon();
				}
				
				
			}
			
		}

	}

}
