package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1974_스도쿠검증 {

	public static int puzzle[][];
	
	public static boolean checkLine(boolean horizon) {
		boolean check[];
		int value;
		for (int i = 0; i < 9; i++) {
			check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if(horizon)	value = puzzle[i][j];
				else value = puzzle[j][i];
				
				if(!check[value]) check[value] = true;
				else return false;
			}
		}
		return true;
	}
	
	public static boolean checkSquare() {
		for (int i = 0; i < 9; i = i + 3)
			for (int j = 0; j < 9; j = j + 3)
				if(!square(i,j)) return false;
		return true;
	}
	
	public static boolean square(int x, int y) {
		boolean check[] = new boolean[10];
		int value;
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				value = puzzle[i][j];
				if(!check[value]) check[value] = true;
				else return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1974_스도쿠검증.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int answer;
		for (int test_case = 1; test_case <= T; test_case++) {
			puzzle = new int[9][9];
			answer = 0;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					puzzle[i][j] = sc.nextInt();
			if(checkLine(true) && checkLine(false) && checkSquare()) answer = 1;
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
