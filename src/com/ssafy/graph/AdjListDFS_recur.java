package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjListDFS_recur {
	static int N;
	static GraphNode[] list;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/recture/AdjList.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			list = new GraphNode[N];
			visit = new boolean[N];
			int L = sc.nextInt();
			int v, ad;
			for (int i = 0; i < L; i++) {
				v  = sc.nextInt();
				ad = sc.nextInt();
				list[v] = new GraphNode(ad,list[v]);
			}
			for (int i = 0; i < N; i++) {
				System.out.println("["+i+"] "+list[i]);
			}
			dfs(0, list[0]);
			System.out.println();
		}
		sc.close();
//		Node[] list = new Node[5];
//		// 뒤에서부터 연결
//		// list
//		// [0 ] -> [2 | ]
//		// [0 ] -> [1 | ] -> [2 | ]
//		list[0] = new Node(2, list[0]);
//		list[0] = new Node(1, list[0]);
//		System.out.println(list[0]);
	}
	private static void dfs(int cur, GraphNode node) {
		int v;
		System.out.printf("%c => ",cur+65);
		visit[cur] = true;
		while(node != null) {
			v = node.vertex;
			if(!visit[v])
				dfs(v, list[v]);
			node = node.link;
		}
	}
}
