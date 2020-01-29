package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1204_최빈수구하기.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int counts[], answer, maxCount;
		for (int testCase = 1; testCase <= T; testCase++) {
			counts = new int[101];
			answer = -1;
			maxCount = 0;
			sc.nextInt();
			int count, score;
			for(int i = 0; i < 1000; i++) {
				score = sc.nextInt();
				count = ++counts[score];
				if(maxCount < count) {
					maxCount = count;
					answer = score;
				}
				else if(maxCount == count)
					answer = Math.max(answer, score);
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
		
		sc.close();

	}

}
