package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int courses[] = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				courses[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(courses);
			double answer = 0;
			for (int i = N-K; i < N; i++) {
				answer = (answer + courses[i]) / 2;
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

}
