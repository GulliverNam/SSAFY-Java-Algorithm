package swea.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {

	static int Ladder[][], Answer;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1210_Ladder1.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		int goal;
		for (int testCase = 1; testCase <= T; testCase++) {
			sc.nextLine();
			Ladder = new int[100][100];
			int j;
			goal = 0;
			for (int i = 99; i > -1; i--) {
				j=0;
				for(String s: sc.nextLine().split(" ")) {
					Ladder[i][j] = Integer.parseInt(s);
					if(Ladder[i][j++] == 2)
						goal = j-1;
				}
			}
			findStart(0, goal, 0);
			System.out.println("#"+testCase+" "+Answer);
		}
		sc.close();

	}

	private static void findStart(int i, int j, int d) {
		if(i == 99) {
			Answer = j;
			return;
		}
		switch(d) {
			case 0: // 아래
				if(j-1 > -1 && Ladder[i][j-1] == 1)
					findStart(i,j-1,1);
				else if(j+1 < 100 && Ladder[i][j+1] == 1)
					findStart(i,j+1,2);
				else if(i+1 < 100 && Ladder[i+1][j] == 1)
					findStart(i+1,j,0);
				break;
			case 1: // 왼쪽
				if(i+1 < 100 && Ladder[i+1][j] == 1)
					findStart(i+1,j,0);
				else if(j-1 > -1 && Ladder[i][j-1] == 1)
					findStart(i,j-1,1);
				break;
			case 2: // 오른쪽
				if(i+1 < 100 && Ladder[i+1][j] == 1)
					findStart(i+1,j,0);
				else if(j+1 < 100 && Ladder[i][j+1] == 1)
					findStart(i,j+1,2);
				break;
		}
	}

}
