package EndofSemProject;

import java.util.ArrayList;

public class GuessWord {
	
	private boolean gameOn = true;
	private HangMan man = new HangMan();
	
	private String[] words = {"abruptly","abyss", "avenue", "awkward",
			"axiom", "azure","bagpipes", "bandwagon", "banjo", "bayou", "beekeeper",
			"bikini", "blitz", "blizzard", "boggle", "bookworm", "boxcar", "boxful",
			"buckaroo", "buffalo", "buffoon", "buxom", "buzzard", "buzzing", "buzzwords",
			"caliph", "cobweb", "cockiness", "croquet", "crypt", "curacao", "cycle",
			"daiquiri", "dirndl", "disavow", "dizzying", "duplex", "dwarves", "embezzle",
			"equip", "espionage", "euouae", "exodus", "faking", "fishhook", "fixable",
			"fjord", "flapjack", "flopping", "fluffiness", "flyby", "foxglove", "frazzled",
			"frizzled", "fuchsia", "funny", "gabby", "galaxy", "galvanize", "gazebo",
			"giaour", "gizmo", "glowworm", "glyph", "gnarly", "gnostic", "gossip",
			"grogginess", "haiku", "haphazard", "hyphen", "iatrogenic", "icebox",
			"injury", "ivory", "ivy", "jackpot", "jaundice", "jawbreaker", "jaywalk",
			"jazziest", "jazzy", "jelly", "jigsaw", "jinx", "jiujitsu", "jockey",
			"jogging", "joking", "jovial", "joyful", "juicy", "jukebox", "jumbo",
			"kayak", "kazoo", "keyhole", "khaki", "kilobyte", "kiosk", "kitsch",
			"kiwifruit", "klutz", "knapsack", "larynx", "lengths", "lucky", "luxury",
			"lymph", "marquis", "matrix", "megahertz", "microwave", "mnemonic", "mystify",
			"naphtha", "nightclub", "nowadays", "numbskull", "nymph", "onyx", "ovary",
			"oxidize", "oxygen", "pajama", "peekaboo", "phlegm", "pixel", "pizazz",
			"pneumonia", "polka", "pshaw", "psyche", "puppy", "puzzling", "quartz",
			"queue", "quips", "quixotic", "quiz", "quizzes", "quorum", "razzmatazz",
			"rhubarb", "rhythm", "rickshaw", "schnapps", "scratch", "shiv", "snazzy",
			"sphinx", "spritz", "squawk", "staff", "strength", "strengths", "stretch",
			"stronghold", "stymied", "subway", "swivel", "syndrome", "thriftless",
			"thumbscrew", "topaz", "transcript", "transgress", "transplant", "triphthong",
			"twelfth", "twelfths", "unknown", "unworthy", "unzip", "uptown", "vaporize",
			"vixen", "vodka", "voodoo", "vortex", "voyeurism", "walkway", "waltz", "wave",
			"wavy", "waxy", "wellspring", "wheezy", "whiskey", "whizzing", "whomever",
			"wimpy", "witchcraft", "wizard", "woozy", "wristwatch", "wyvern", "xylophone",
			"yachtsman", "yippee", "yoked", "youthful", "yummy", "zephyr", "zigzag",
			"zigzagging", "zilch", "zipper", "zodiac", "zombie"};
	
	private String currentWord = new String();
	private int hangManPart = 0;
	
	public ArrayList<String> guess = new ArrayList<String>();
	private ArrayList<String> bank = new ArrayList<String>();
	private ArrayList<String> used = new ArrayList<String>();
	
	public GuessWord() {
		resetWord();
	}
	
	public GuessWord(boolean gameOn, HangMan man) {
		this.gameOn = gameOn;
		this.man = man;
	}
	
	public void resetWord() {
		deleteElements();
		selectWord();
		setGuessLen();
	}
	
	public void setGameStat(boolean x) {
		gameOn = x;
	}
	
	public boolean getGameStat() {
		return gameOn;
	}
	
	private void deleteElements() {
		for(int i = 0; i<guess.size(); i++) {
			guess.remove(i);
			i--;
		}
		
		for(int i = 0; i<bank.size(); i++) {
			bank.remove(i);
			i--;
		}
		
		for(int i = 0; i<used.size(); i++) {
			used.remove(i);
			i--;
		}
	}
	
	public void selectWord() {
		int rand = (int)(Math.random()*210);
		currentWord = words[rand];
	}
	
	public void setGuessLen() {
		for(int i=0; i<currentWord.length(); i++) {
			guess.add("_");
		}
	}
	
	public boolean letterUsed(String letter) {
		for(String i: used) {
			if(i.equals(letter)) {
				return true;
			}
		}
		
		return false;
	}

	public void makeGuess(String letter) {
		if(!letterUsed(letter)) {
			if(!currentWord.contains(letter)) {
				addToBank(letter);
				drawMan();
			}
			else {
				analyzeGuess(letter);
				
			}
			used.add(letter);
		}
		else {
			System.out.println("You've already used that letter!");
			System.out.println();
		}

	}
	
	private void drawMan() {
		if(hangManPart == 0) {
			man.drawHead();
		}
		else if (hangManPart == 1) {
			man.drawTorso();
		}
		else if (hangManPart == 2) {
			man.drawLeftArm();
		}
		else if (hangManPart == 3) {
			man.drawRightArm();
		}
		else if (hangManPart == 4) {
			man.drawLeftLeg();
		}
		else if (hangManPart == 5) {
			man.drawRightLeg();
		}
		else if (hangManPart == 6) {
			gameLost();
		}
		
		hangManPart ++;
	}
	

	private void analyzeGuess(String letter) {
		int index= 0;
		String temp = currentWord;
		int cutLen = 0;
		index = temp.indexOf(letter);
		
		while(index > -1) {
			
			guess.set(index+cutLen,letter);
			

			
			String cut = temp.substring(0,index+1);
			cutLen = cut.length();
			temp = temp.substring(index+1);
			
			index = temp.indexOf(letter);
			
		}
		
	}
	
	public boolean ifWon() {
		for (String x : guess) {
			if (x.equals("_")) {
				return false;
			}
		}
		return true;
	}
	
	private void addToBank(String letter) {
		bank.add(letter);
	}
	
	public void printGuess() {
		for(String i : guess) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void printBank() {
		String toPrint = "used: ";
		for(String i:bank) {
			toPrint += i;
		}
		System.out.println(toPrint);
	}
	
	
	public void gameLost() {
		System.out.println("**********");
		System.out.println("GAME LOST");
		System.out.println("The word was: " + currentWord);
		System.out.println();
		
		resetWord();
		man.resetBoard();
		gameOn = false;
	}
	
	public void gameWon() {
		System.out.println("**********");
		System.out.println("CONGRATULATIONS! YOU WIN !");
		System.out.println();
		
		resetWord();
		man.resetBoard();
		gameOn = false;
	}

}
