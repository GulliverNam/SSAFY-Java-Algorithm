package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5604_구간합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long answer[] = new long[10];
			int target = 1;
			while(A <= B) {
				while(B % 10 != 9 && A <= B) {
					calculate(B, answer, target);
					B--;
				}
				if(A > B) break;
				while(A % 10 != 0 && A <= B) {
					calculate(A, answer, target);
					A++;
				}
				A /= 10;
				B /= 10;
				for (int i = 1; i < 10; i++) {
					answer[i] += (B - A + 1)*target;
				}
				target *= 10;
			}
			long sum = 0;
			for (int i = 1; i < 10; i++) {
				sum += i*answer[i];
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

	private static void calculate(long num, long[] answer, int target) {
		for (int i = 0, size = (int)Math.log10(num); i <= size; i++) {
			answer[(int)num%10] += target;
			num /= 10;
		}
		
	}
}
