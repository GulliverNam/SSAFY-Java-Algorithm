package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_6109_추억의2048게임 {
	
	static int N, map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] answer = new int[N][N];
			switch (dir) {
				case "up":
					for (int i = 0; i < N; i++) {
						int num = 0;
						int idx = 0;
						for (int j = 0; j < N; j++) {
							if(map[j][i] != 0) {
								if(num == 0) {
									num = map[j][i];
								}
								else {
									if(map[j][i] == num) {
										answer[idx++][i] = num*2;
										num = 0;
									} else {
										answer[idx++][i] = num;
										num = map[j][i];
									}
								}
							}
						}
						answer[idx][i] = num;
					}
					break;
				case "down":
					for (int i = 0; i < N; i++) {
						int num = 0;
						int idx = N-1;
						for (int j = N-1; j > -1; j--) {
							if(map[j][i] != 0) {
								if(num == 0) {
									num = map[j][i];
								}
								else {
									if(map[j][i] == num) {
										answer[idx--][i] = num*2;
										num = 0;
									} else {
										answer[idx--][i] = num;
										num = map[j][i];
									}
								}
							}
						}
						answer[idx][i] = num;
					}
					break;
				case "left":
					for (int i = 0; i < N; i++) {
						int num = 0;
						int idx = 0;
						for (int j = 0; j < N; j++) {
							if(map[i][j] != 0) {
								if(num == 0) {
									num = map[i][j];
								}
								else {
									if(map[i][j] == num) {
										answer[i][idx++] = num*2;
										num = 0;
									} else {
										answer[i][idx++] = num;
										num = map[i][j];
									}
								}
							}
						}
						answer[i][idx] = num;
					}
					break;
				case "right":
					for (int i = 0; i < N; i++) {
						int num = 0;
						int idx = N-1;
						for (int j = N-1; j > -1; j--) {
							if(map[i][j] != 0) {
								if(num == 0) {
									num = map[i][j];
								}
								else {
									if(map[i][j] == num) {
										answer[i][idx--] = num*2;
										num = 0;
									} else {
										answer[i][idx--] = num;
										num = map[i][j];
									}
								}
							}
						}
						answer[i][idx] = num;
					}
					break;
			}
			
			bw.write("#"+tc+"\n");
			for (int line[] : answer) {
				for (int i : line) {
					bw.write(i+" ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
