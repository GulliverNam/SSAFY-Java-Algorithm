package baekjoon;

import java.io.*;
import java.util.*;

public class Main_6987_월드컵 {
	
	static int[][] table;
	static int[][] game;
	static boolean done;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(16);
		game = new int[15][2];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i+1; j < 6; j++) {
				game[idx++] = new int[] {i, j};
			}
		}
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine().trim());
			table = new int[6][3];
			done = false;
			int total = 0;
			for (int j = 0; j < 6; j++) {
				table[j][0] = Integer.parseInt(st.nextToken());
				table[j][1] = Integer.parseInt(st.nextToken());
				table[j][2] = Integer.parseInt(st.nextToken());
				total += (table[j][0] + table[j][1] + table[j][2]);
			}
			if(total == 30) play(0);
			if(done) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb.toString());
		
	}
	private static void play(int idx) {
		if(done) return;
		if(idx == 15) {
			done = true;
			return;
		}
		int[] t1 = table[game[idx][0]];
		int[] t2 = table[game[idx][1]];
		
		for (int i = 0; i < 3; i++) {
			if(t1[i] > 0 && t2[2-i] > 0) {
				t1[i]--;
				t2[2-i]--;
				play(idx+1);
				t1[i]++;
				t2[2-i]++;
			}
		}
	}

}
