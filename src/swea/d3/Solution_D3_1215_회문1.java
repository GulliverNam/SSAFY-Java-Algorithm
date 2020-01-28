package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1215_회문1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1215_회문1.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n;
		char plate[][];
		for(int test_case = 1; test_case <= 10; test_case++) {
			n = sc.nextInt();
			plate = new char[8][8];
			String str;
			for (int i = 0; i < 8; i++) {
				str = sc.next();
				for (int j = 0; j < 8; j++)
					plate[i][j] = str.charAt(j);
			}
			
			
		}
	}

}
