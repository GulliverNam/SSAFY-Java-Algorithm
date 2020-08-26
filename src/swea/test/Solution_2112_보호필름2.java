package swea.test;

import java.io.*;
import java.util.*;

public class Solution_2112_보호필름2 {
	
	public static int origin[][];
	public static int map[][];
	public static int d,w,k;
	public static int answer;
	public static int[] cover;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2112_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T ;tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			origin= new int[d][w];
			map= new int[d][w];
			for(int i = 0 ; i < d ; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0 ; j < w ; j ++) {
					origin[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
     
			answer = k; 
			cover = new int[d];
			dfs(0 ,0);
			sb.append("#"+tc+" "+answer+"\n");
		}System.out.print(sb);
	}
	private static void dfs(int depth , int time) {
		if(time > answer) return;
		if(depth==d || time ==k) {
			if(check(cover)) {
				answer =time > answer ? answer : time;
			}
			return;
		}
		
		backToOrigin(depth);
		cover[depth] = 0; dfs(depth+1 , time);
		Arrays.fill(map[depth], 0);
		cover[depth] = 1; dfs(depth+1 , time+1);
		Arrays.fill(map[depth], 1);
		cover[depth] = 2; dfs(depth+1 , time+1);
      
	}
	private static void backToOrigin(int depth) {
		for (int i = 0; i < w; i++) {
			map[depth][i] = origin[depth][i];
		}
	}
	private static boolean check(int[] cover) {
		top:
		for (int j = 0; j < w; j++) {
			int cnt = 1;
			int now = map[0][j];
			for (int i = 1; i < d; i++) {
				if(map[i][j] != now) {
					cnt = 1;
					now = map[i][j];
				} else {
					cnt++;
				}
				if(cnt >= k)
					continue top;
			}
			return false;
		}
		return true;
	}

}
