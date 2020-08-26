package swea.d5;

import java.io.*;
import java.util.*;

public class Solution_D5_1798_범준이의제주도여행계획 {
	
	static int N, M, airport;
	static int[][] cost;
	static List<Integer> hotel;
	static List<int[]> point;
	static boolean[] visited;
	static int maxStf;
	static List<Integer> answerRoute;
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		/**
		 * 1. 첫날 공항에 도착한 후부터 M일 후 다시 공항에 돌아올 때까지 얻은 만족도와 경로를 구해야 한다.
		   2. 방문할 수 있는 지점은 공항, 호텔, 관광포인트를 모두 합해 N개의 지점이 있다.
		   3. 각 관광포인트는 즐기기 위해 소요되는 시간과 얻을 수 있는 만족도가 정해져 있으며, 한 번 갔던 관광포인트는 다시 방문하지 않는다.
		   4. 각 지점들은 서로 간에 모두 연결된 길이 있으며 이동에 소요되는 시간이 정해져 있다. 또, 다른 길로 우회하여 가지 않는다.
		   5. 하루에 이동+놀이에 소요되는 시간이 9시간을 넘으면 안되고 그 전에 반드시 호텔에 입실해야 한다.
		    	호텔은 같은 호텔을 중복 이용해도 되고 다른 호텔로 옮겨도 상관없다.
		   6. M일째 날에도 9시간을 사용할 수 있으며 그 전에 공항에 도착해야 한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			cost = new int[N+1][N+1];
			airport = 0;
			hotel = new ArrayList<>();
			point = new ArrayList<>();
			answerRoute = new ArrayList<>();
			maxStf = 0;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = i+1; j <= N; j++) {
					int c = Integer.parseInt(st.nextToken());
					cost[i][j] = c;
					cost[j][i] = c;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				char type = st.nextToken().charAt(0);
				switch (type) {
				case 'A':
					airport = i;
					break;
				case 'P':
					point.add(new int[] {i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
					break;
				case 'H':
					hotel.add(i);
					break;
				}
			}
			memo = new int[M][N+1];
			dfs(airport, M-1, 540, 0, new Stack<Integer>());
			bw.write("#"+tc+" "+maxStf+" ");
			for (int r : answerRoute) {
				bw.write(r+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int start, int day, int time, int stf, Stack<Integer> route) {
		for (int[] p : point) {
			if(!visited[p[0]] && p[1] + cost[start][p[0]] <= time){
				visited[p[0]] = true;
				route.push(p[0]);
				dfs(p[0], day, time - p[1] - cost[start][p[0]], stf+p[2], route);
				route.pop();
				visited[p[0]] = false;
			}
		}
		if(day > 0) {
			for (int h : hotel) {
				if(cost[start][h] <= time) {
					if(memo[day][h] == 0 || memo[day][h] <= stf) {
						memo[day][h] = stf;
						route.push(h);
						dfs(h, day-1, 540, stf, route);
						route.pop();
					}
				}
			}
		} else {
			if(cost[start][airport] <= time) {
				if(maxStf < stf) {
					route.push(airport);
					maxStf = stf;
					answerRoute.clear();
					answerRoute.addAll(route);
					route.pop();
					return;
				}
			}
		}
	}

}
