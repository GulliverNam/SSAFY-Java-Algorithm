package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class AdjMatrixDFS_stack {
	static int N, Graph[][];
	static boolean Visit[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			Graph = new int[N][N];
			Visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					Graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0);
			System.out.println();
		}

	}

	private static void dfs(int cur) {
		Stack<Integer> stack = new Stack<>();
		stack.push(cur);
		while(!stack.isEmpty()) {
			cur = stack.pop();
			if(!Visit[cur]) {
				Visit[cur] = true;
				System.out.printf("%c -> ", cur+65);
				
				for (int adj = 0; adj < N; adj++) {
					if(!Visit[adj] && Graph[cur][adj] == 1)
						stack.push(adj);
				}
			}
		}
		
	}

}
