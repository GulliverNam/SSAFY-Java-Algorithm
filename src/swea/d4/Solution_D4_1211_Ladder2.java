package swea.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1211_Ladder2 {
	
	static int Ladder[][] = new int[100][100];
	static int StartPoints[] = new int[100];
	static int MinDis, Answer;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1211_Ladder2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		int j;
		for (int testCase = 1; testCase <= T; testCase++) {
			sc.nextLine();
			MinDis = Integer.MAX_VALUE;
			Arrays.fill(StartPoints, -1);
			int cnt = 0;
			for (int i = 0; i < 100; i++) {
				j=0;
				for(String s: sc.nextLine().split(" ")) {
					Ladder[i][j++] = Integer.parseInt(s);
					if(i == 0 && Ladder[i][j-1] == 1)
						StartPoints[cnt++] = j-1;
				}
			}
			
			for (int i = 0; i < 100; i++) {
				if(StartPoints[i] == -1)
					break;
				minPath(0, StartPoints[i], 0, 0, StartPoints[i]);
			}
			System.out.println("#"+testCase+" "+Answer);
			
		}
		sc.close();

	}

	private static void minPath(int i, int j, int dir, int distance, int sp) {
		if(i == 99) {
			if(MinDis > distance) {
				MinDis = distance;
				Answer = sp;
			}
			return;
		}
		switch(dir) {
			case 0: // 아래
				if(j-1 > -1 && Ladder[i][j-1] == 1)
					minPath(i,j-1,1,distance+1, sp);
				else if(j+1 < 100 && Ladder[i][j+1] == 1)
					minPath(i,j+1,2,distance+1, sp);
				else if(i+1 < 100 && Ladder[i+1][j] == 1)
					minPath(i+1,j,0,distance+1, sp);
				break;
			case 1: // 왼쪽
				if(i+1 < 100 && Ladder[i+1][j] == 1)
					minPath(i+1,j,0,distance+1, sp);
				else if(j-1 > -1 && Ladder[i][j-1] == 1)
					minPath(i,j-1,1,distance+1, sp);
				break;
			case 2: // 오른쪽
				if(i+1 < 100 && Ladder[i+1][j] == 1)
					minPath(i+1,j,0,distance+1, sp);
				else if(j+1 < 100 && Ladder[i][j+1] == 1)
					minPath(i,j+1,2,distance+1, sp);
				break;
		}
		
		return;
	}
}
