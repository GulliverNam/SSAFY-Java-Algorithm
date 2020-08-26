package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_3234_준환이의양팔저울 {
	
	static int n, answer, total;
	static int[] sinker;
	static int[] facts = new int[10];
	static int[] twoOfN = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int num = 1;
		for (int i = 1; i < 10; i++) {
			num *= i;
			facts[i] = num; 
		}
		for (int i = 1; i < 10; i++) {
			twoOfN[i] = (int)Math.pow(2,i);
		}

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			sinker = new int[n];
			total = 0;
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				sinker[i] = Integer.parseInt(st.nextToken());
				total += sinker[i];
			}
			answer = 0;
			permutation(0, 0, 0, 0);
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void permutation(int cnt, int mask, int left, int right) {
		if(cnt == n) {
			answer++;
			return;
		}
		if(left >= total-left) {
			answer += facts[n-cnt]*twoOfN[n-cnt];
			return;
		}
		for (int i = 0; i < n; i++) {
			if((mask & 1 << i) == 0) {
				if(left >= right + sinker[i]) {
					permutation(cnt+1, mask | 1 << i, left, right+sinker[i]);
				}
				permutation(cnt+1, mask | 1 << i, left + sinker[i], right);
			}
		}
		
	}

}
