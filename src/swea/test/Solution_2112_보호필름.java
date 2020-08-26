package swea.test;

import java.io.*;
import java.util.*;

public class Solution_2112_보호필름 {
	
	static int D, W, K, answer;
	static boolean[][] origin;
	static boolean[][] protector;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2112_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			origin = new boolean[D][W];
			protector = new boolean[D][W];
			answer = K;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					origin[i][j] = protector[i][j] = st.nextToken().equals("1");
				}
			}
			dfs(0,0);
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int start, int cnt) {
		if(cnt >= answer) {
			return;
		}
		if(check()) {
			answer = Math.min(answer,cnt);
		}
		for (int i = start; i < D; i++) {
			Arrays.fill(protector[i], true);
			dfs(i+1, cnt+1);
			Arrays.fill(protector[i], false);
			dfs(i+1, cnt+1);
			backToOrigin(i);
		}
	}
	
	private static void backToOrigin(int i) {
		for (int j = 0; j < W; j++) {
			protector[i][j] = origin[i][j];
		}
	}

	private static boolean check() {
		top:
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			boolean now = protector[0][j];
			for (int i = 1; i < D; i++) {
				if(protector[i][j] ^ now) {
					cnt = 1;
					now = protector[i][j];
				} else {
					cnt++;
				}
				if(cnt >= K)
					continue top;
			}
			return false;
		}
		return true;
	}

	

}
