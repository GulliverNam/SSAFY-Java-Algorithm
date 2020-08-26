package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 아기상어의 크기는 2
		// 크기가 작은 물고기만 먹을 수 있음
		// 크기가 같은 물고기는 먹을 수는 없지만 지나갈 수 있음
		// 먹을수 있는 물고기 1마리 -> 먹으러감
		// 먹을수 있는 물고기가 여러마리 -> 가장가까운 물고기를 먹음
		//  - 거리: 물고기가 있는칸까지 이동할 때 지나가야하는 칸의 최소개수
		//  - 거리가 가까운 물고기가 같다면 가장 위에 있는 물고기
		//  - 위와같은 물고기가 많다면 가장 오니쪽 물고기
		// 이동은 1초 소요 / 먹는데 걸리는시간 x
		// 크기:x -> x마리를 먹을때 크기가 1 증가
		// 문제: 몇초동안 엄마상어에게 요청하지 않고 물고기를 먹을 수 있는가?
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n+2][n+2];
		int[] babyShark = new int[3];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -1);
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					babyShark[0] = i;
					babyShark[1] = j;
					babyShark[2] = 2;
				}
			}
		}
		int[] dr = {-1,0,0,1};
		int[] dc = {0,-1,1,0};
		int answer = 0;
		int cnt = 0;
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0] && o1[2] == o2[2])
					return Integer.compare(o1[1], o2[1]);
				else if(o1[2] == o2[2])
					return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[2], o2[2]);
			}
		};
		while(true) {
			boolean[][] visited = new boolean[n+1][n+1];
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(comp);
			queue.add(new int[] {babyShark[0], babyShark[1], 0});
			visited[babyShark[0]][babyShark[1]] = true;
			int[] fish = null;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(map[cur[0]][cur[1]] > 0 && map[cur[0]][cur[1]] < babyShark[2]) {
					fish = cur;
					map[cur[0]][cur[1]] = 0;
					cnt++;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if(map[nr][nc] > -1 && map[nr][nc] <= babyShark[2] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc, cur[2]+1});
					}
				}
			}
			if(fish != null){
				answer += fish[2];
				babyShark[0] = fish[0];
				babyShark[1] = fish[1];
				if(cnt == babyShark[2]) {
					cnt = 0;
					babyShark[2]++;
				}
			} else break;
		}
		System.out.println(answer);
	}

}
