package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AdjMatrixBFS {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, graph[][];
		boolean visit[];
		LinkedList<Integer> queue = new LinkedList<>();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			graph = new int[N][N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			queue.add(0);		// 첫 노드 넣기
			visit[0] = true;	// 첫 노드 방문 처리
			int current;
			System.out.print("#"+testCase+" ");
			while(!queue.isEmpty()) {
				current = queue.poll();
				System.out.printf("%c -> ",current+65);
				// 현재 노드와 인접한 노드를 탐색
				for (int adj = 0; adj < N; adj++) {
					//  방문 x && 연결된 노드
					if(!visit[adj] && graph[current][adj] == 1) {
						visit[adj] = true;
						queue.add(adj);
					}
				}
			}
			System.out.println("finish");
			queue.clear();
		}
		

	}

}
