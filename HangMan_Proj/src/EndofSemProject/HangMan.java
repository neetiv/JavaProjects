package EndofSemProject;

import java.util.ArrayList;

public class HangMan {
	
	private String[][] man = new String[11][8];
	
	public HangMan() {
		resetBoard();
		
	}

	public void resetBoard() {
		clearArray();
		drawPost();
	}
	
	private void clearArray() {
		for(int i=0; i<man.length; i++) {
			for(int j=0; j< man[0].length; j++) {
				man[i][j]=" ";
			}
		}
	}
	
	private void drawPost() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if((i==1 && j==1)||(j==6)) {
					man[i][j]= "|";
				}
				if((i==1 && j>0) || (i==10&&j>4)) {
					man[i][j]="-";
				}
			}
		}
	}
	
	public void drawHead() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if(i==3 && (j==1 || j==3)) {
					man[i][j]= "|";
				}
				if((i==2 || i==4)&&(j>0 && j<4)) {
					man[i][j]="-";
				}
			}
		}
	}
	
	public void drawTorso() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if(j==2 && (i>4&&i<8)) {
					man[i][j]= "|";
				}
			}
		}
	}
	
	public void drawLeftLeg() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if((i==8&&j==1)||(i==9&&j==0)) {
					man[i][j]= "/";
				}
			}
		}
	}
	
	public void drawRightLeg() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if((i==8&&j==3)||(i==9&&j==4)) {
					man[i][j]= "\\";
				}
			}
		}
	}
	
	public void drawLeftArm() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if(i==6&&j<2) {
					man[i][j]= "-";
				}
			}
		}
	}
	
	public void drawRightArm() {
		for(int i = 0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				if(i==6&&(j>2&&j<5)) {
					man[i][j]= "-";
				}
			}
		}
	}
	
	public void printMan() {
		for(int i=0; i<man.length; i++) {
			for(int j=0; j<man[i].length; j++) {
				System.out.print(man[i][j]);
			}
			System.out.println();
		}
	}
	
	


}
