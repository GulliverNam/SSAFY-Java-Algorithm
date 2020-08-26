package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_7965_퀴즈 {
	
	public static long dcPower(int x, int n) {
		if(n == 0) return 1;
		else if(n == 1) return x;
		long result = dcPower(x, n >> 1) % 1000000007 ;
		if(n % 2 == 0)
			return result * result;
		return result * result % 1000000007 * x;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_7965_퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		int N;
		long answer;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			answer = 0;
			long num;
			for (int i = 1; i <= N; i++) {
				num = dcPower(i,i);
				if(answer + num > 10000007)
					answer = (answer + num) % 1000000007;
				else
					answer += num;
			}
			System.out.println("#"+tc+" "+answer);
		}

	}

}
