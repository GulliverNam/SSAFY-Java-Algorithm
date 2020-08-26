package com.ssafy.graph;

import java.util.Arrays;

public class DisjointSetTest1 {
	/** 
	 *  노드와 루트를 담는 배열 
	 * 	index가 자신의 노드
	 *  값이 상위(부모)노드
	 *  => index == data : root
	 *  => index != data : sub node
	 */
	static int[] parent;
	
	/**
	 * 모든 노드들은 자기 자신이 root가 된다.
	 * @param v
	 */
	public static void makeSet(int v) {
		parent[v] = v;
	}
	
	/**
	 * 노드의 root를 찾아주는 기능
	 * @param v
	 * @return root
	 */
	public static int findSet(int v) {
		if(parent[v] == v)	// data == index : root
			return v;
		return findSet(parent[v]);
	}
	
	/**
	 * 두 tree를 결합
	 * @param u 노드 1
	 * @param v 노드 2
	 */
	public static void unionSet(int u, int v) {
		// 각각의 노드들의 root 찾아서 parent 연결
		parent[findSet(v)] = findSet(u);
		//     ----------    ----------
		//		u의 root		   v의 root
	}
	
	public static void main(String[] args) {
		int N = 6;
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		
		System.out.println("================ [make set] ================");
		System.out.println(Arrays.toString(parent));
		unionSet(3,4);
		unionSet(2,4);
		unionSet(5,6);
		System.out.println("================ [union set] ================");
		System.out.println(Arrays.toString(parent));
		System.out.println("================ [find set] ================");
		System.out.printf("2,4 : %b \n", findSet(2) == findSet(4));
		System.out.printf("2,6 : %b \n", findSet(2) == findSet(6));
		
	}

}
