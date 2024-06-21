package secondGame;
import java.util.Scanner;  // Import the Scanner class

public class secondGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intro();
		
		System.out.println();
		
		board();
		
		System.out.println();	
		
		game();
	}
	
	public static void intro() {
		
		System.out.println("Welcome to the game of tic tac toe.");		
		System.out.println();
		System.out.println("|Board|");
	}
	
	public static void board() {
		
		 int rows = 3;
		 int cols = 3;
		 int base = 1;
		 int[][] numbers = new int[rows][cols];
		 
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 numbers[i][j] = base;
				 base++;
			 }
		 }
		 
		 for (int f = 0; f < rows; f++) {
			 for (int s = 0; s < cols; s++) {
				 System.out.print(numbers[f][s]);
			 }
			 System.out.println();
		 }
	}
	
	public static void game() {
		
		boolean winner = false;
		int marker = 0;
		int draw = 1;
		char[][] positions = new char[3][3];
		
		Scanner read = new Scanner(System.in);
		
		System.out.print("Player one name: ");
		String playerOne = read.nextLine();  // Read user inputxtLine
		
		System.out.println();
		
		System.out.print("Player two name: ");
		String playerTwo = read.nextLine();  // Read user inputxtLine
		
		System.out.println();
		
		do {
			
			System.out.print(playerOne + "'s turn: ");
			
			int playerOnePick = read.nextInt();
			
			winner = playGame(playerOnePick, marker, positions);
			marker++;
			draw++;
			
			if (winner == false && draw <= 9){
				
				System.out.print(playerTwo + "'s turn: ");
			
				int playerTwoPick = read.nextInt();
			
				winner = playGame(playerTwoPick, marker, positions);
				marker++;
				draw++;
			}
			
		} while (winner == false && draw <= 9);
		
		checkWinner(marker, playerOne, playerTwo, winner);
		read.close();
	}
	
	public static boolean playGame(int pick, int marker, char[][] positions) {
		
		int counter = 1;
		int rows = 3;
		int cols = 3;
		
		if (marker % 2 == 0) {
			for (int i = 0; i < rows; i++) {
				 for (int j = 0; j < cols; j++) {
					 if (counter == pick) {
						 positions[i][j] = 'x';
						 j++;
					 }
					 counter++;
				 }
			 }
			  
			for (int f = 0; f < rows; f++) {
				 for (int s = 0; s < cols; s++) {
					 System.out.print(positions[f][s]);
				 }
				 System.out.println();
		    }
		} else {
			for (int d = 0; d < rows; d++) {
				 for (int v = 0; v < cols; v++) {
					 if (counter == pick) {
						 positions[d][v] = 'o';
						 v++;
					 }
					 counter++;
				 }
			 }
			  
			for (int c = 0; c < rows; c++) {
				 for (int e = 0; e < cols; e++) {
					 System.out.print(positions[c][e]);
				 }
				 System.out.println();
			 }
		}
		
		return checkScore(positions);
	}
	
	public static boolean checkScore(char[][] check) {
			
		boolean flag = false;
		
		flag = checkColumn(check);
		
		if (flag) {
			return flag;
		}
		
		flag = checkRow(check);
		
		if (flag) {
			return flag;
		}
		
		flag = checkFirstDiagonal(check);
		
		if (flag) {
			return flag;
		}
		
		flag = checkSecondDiagonal(check);
		
		if (flag) {
			return true;
		}
		
		return flag;
	}
	
	public static boolean checkRow(char check[][]) {
		
		int cnt = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (check[i][j] == 'x') {
					cnt++;
				} 
			}
			if (cnt == 3) {
				return true;
			} else {
				cnt = 0;
			}
		}
		
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (check[k][l] == 'o') {
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			} else {
				cnt = 0;
			}
		}
		
		return false;	
	}
	
	public static boolean checkColumn(char check[][]) {
		
		int cnt = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (check[j][i] == 'x') {
					cnt++;
				} 
			}
			if (cnt == 3) {
				return true;
			} else {
				cnt = 0;
			}
		}
		
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (check[l][k] == 'o') {
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			} else {
				cnt = 0;
			}
		}
		
		return false;	
	}
	
	public static boolean checkFirstDiagonal(char check[][]) {
		
		int cnt = 0;
		
		for (int x = 0; x < 3; x++) {
			if (check[x][x] == 'x') {
				cnt++;
			}
		}
		
		if (cnt == 3) {
			return true;
		} else {
			cnt = 0;
		}
		
		for (int b = 0; b < 3; b++) {
			if (check[b][b] == 'o') {
				cnt++;
			}
		}
		
		if (cnt == 3) {
			return true;
		} 
	
		return false;
	}
	
	public static boolean checkSecondDiagonal(char[][] check) {
		
		int cnt = 0;
		int l = 2;
		
		for (int x = 0; x < 3; x++) {
			if (check[x][l] == 'x') {
				cnt++;
			}
			l--;
		}
		
		if (cnt == 3) {
			return true;
		} else {
			cnt = 0;
		}
		
		l = 2;
		
		for (int b = 0; b < 3; b++) {
			if (check[b][l] == 'o') {
				cnt++;
			}
		}
		
		if (cnt == 3) {
			return true;
		}
		
		return false;
	}
	
	public static void checkWinner(int marker, String playerOne, String playerTwo, boolean winner) {
		
		if (winner == false) {
			System.out.println("We have a draw!");
		} else if (marker % 2 != 0) {
			System.out.print(playerOne + " won the game!");
		} else {
			System.out.print(playerTwo + " won the game!");
		}
	}
}
	
