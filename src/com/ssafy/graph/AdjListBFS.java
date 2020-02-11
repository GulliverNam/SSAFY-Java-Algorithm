package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjListBFS {
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
			bfs(0);
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
	private static void bfs(int cur) {
		// 노드정보 저장하는 queue
		LinkedList<Integer> queue = new LinkedList<>();
		visit[cur] = true;
		queue.add(cur);
		GraphNode temp = null;
		int v;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.printf("%c => ",cur+65);
			temp = list[cur];
			while(temp != null) { // 인접 노드 방문
				v = temp.vertex;
				if(!visit[v]) {
					visit[v] = true;
					queue.add(v);
				}
				temp = temp.link;
			}
		}
		
	}
}
