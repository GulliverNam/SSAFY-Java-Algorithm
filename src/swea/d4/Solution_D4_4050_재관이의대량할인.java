package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_4050_재관이의대량할인 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] clothes = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				clothes[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(clothes);
			long answer = 0;
			for (int i = N-1; i > 1; i-=3) {
				answer += clothes[i] + clothes[i-1];
			}
			for (int i = 0; i < N % 3; i++) {
				answer += clothes[i];
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

}

