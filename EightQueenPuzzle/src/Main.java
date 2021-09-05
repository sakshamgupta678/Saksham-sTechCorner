import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static int QUEENS;
	public static int[][] queensOnBoard;
	//public static int[] x;
	public static int[] xPlusY;
	public static int[] xMinusY;
	//public static int y;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 
        System.out.println("Enter Number of Queens:");		
        Main.QUEENS = Integer.parseInt(reader.readLine());

		Main.queensOnBoard = new int[QUEENS][2];
		//Main.x = new int[QUEENS];
		Main.xPlusY = new int[QUEENS];
		Main.xMinusY = new int[QUEENS];
		//Main.y = 0;
		if(!addQueens(0)) {
			System.out.println("Solution not found.");
		}
		for (int i = 0; i < QUEENS; i++) {
			
			System.out.println("(" + Main.queensOnBoard[i][0] + "," + Main.queensOnBoard[i][1] + ")");
		}
		
		
		char[][] board = new char[QUEENS][QUEENS];
		for (int i = 0; i < QUEENS; i++) {
			for (int j = 0; j < QUEENS; j++) {
				board[i][j] = '_';
			}
		}
		
		for (int i = 0; i < QUEENS; i++) {
			board[queensOnBoard[i][0]][queensOnBoard[i][1]] = 'Q';
		}
		
		for (int i = 0; i < QUEENS; i++) {
			for (int j = 0; j < QUEENS; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	
	public static boolean addQueens(int y) {
		
			

		
		for (int i = 0; i < QUEENS; i++) {
			if (checkSaftey(i,y)) {
				Main.queensOnBoard[y][0] = i;
				Main.queensOnBoard[y][1] = y;
				Main.xMinusY[y] = i-y;
				Main.xPlusY[y] = i+y;
				if (y==QUEENS-1) {
					return true;
				} else if (addQueens(y+1)) {
					return true;
				}
				
			}
			
			
			
		}
		
		return false;
	}
	
	
	public static boolean checkSaftey(int x, int y) {
	
		int xpy = x+y;
		int xmy = x-y;
		
		for (int i = 0; i < y; i++) {
			
			
			if ((Main.queensOnBoard[i][0]==x) || (Main.xPlusY[i]==xpy) || (Main.xMinusY[i]==xmy)) {
				return false;
			}
		}
		
		
		
		return true;
		
	}
	
	
}
