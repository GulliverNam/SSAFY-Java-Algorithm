package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	
	static int pay[] = new int[3], plan[] = new int[12], answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_1952_수영장.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 2; i > -1; i--)
				pay[i] = Integer.parseInt(st.nextToken());
			answer = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 12; i++)
				plan[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 12; i++) {
				if(plan[i] != 0) {
					calculate(i, 0);
					break;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static void calculate(int m, int sum) {
		if(m < 12) {
			if(plan[m] != 0) {
				calculate(m+3,sum+pay[0]);
				calculate(m+1,sum+pay[1]);
				calculate(m+1,sum+(pay[2]*plan[m]));
			} else
				calculate(m+1, sum);
		} else
			answer = Math.min(answer, sum);
	}

}
