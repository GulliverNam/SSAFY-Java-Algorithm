package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_4530_극한의청소작업 {

	static long A[] = new long[13];
	static long B[][] = new long[14][10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long answer = 0;
			if(b < 0) { // 음수 -> 음수
				a = base9(-a);
				b = base9(-b);
				answer = a - b;
			} else if(a < 0) { // 음수 -> 양수
				a = base9(-a);
				b = base9(b);
				answer = a + b - 1;
			} else { // 양수 -> 양수
				a = base9(a);
				b = base9(b);
				answer = b - a;
			}
			bw.write("#"+tc+" "+answer+"\n");

		}
		bw.flush();
		bw.close();
	}
	private static long base9(long num) {
		long temp = num;
		int count = 0;
		long result = 0;
		while(temp > 0) {
			int one = (int)(temp % 10);
			result += one > 4 ? (one-1)*(long)Math.pow(9, count) : one*(long)Math.pow(9, count);
			count++;
			temp /= 10;
		}
		return result;
	}
	

}


