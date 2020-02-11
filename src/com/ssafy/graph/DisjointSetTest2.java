package com.ssafy.graph;

import java.util.Arrays;

/**
 * rank가 있는  Disjoint Set
 * 
 */
public class DisjointSetTest2 {
	/** 
	 *  노드와 루트를 담는 배열 
	 *  배열 index: 노드
	 *  배열 data : 상위 노드 or rank
	 *  - 0과 양의 정수	: 상위 노드
	 *  - 음수		: root & rank
	 */
	static int[] parent;
	
	/**
	 * 모든 노드들에 root를 넣어준다.
	 * @param v
	 */
	public static void makeSet(int v) {
		parent[v] = -1;
	}
	
	/**
	 * 노드의 root를 찾아주는 기능
	 * @param v
	 * @return root
	 */
	public static int findSet(int v) {
		if(parent[v] < 0)	// data == 음수 : root 이므로 node return
			return v;
		return findSet(parent[v]); // data != 음수 : 상위 노드로 이동
	}
	
	/**
	 * 두 tree를 결합
	 * @param u 노드 1
	 * @param v 노드 2
	 */
	public static void union(int u, int v) {
		// 각 트리의 root를 찾아온다.
		int root1 = findSet(u);
		int root2 = findSet(v);
		if(root1 == root2) return;
		// 두 트리 중 rank가 높은 곳에 낮은 tree를 연결
		int rank1 = parent[root1];
		int rank2 = parent[root2];
		if(rank1 < rank2) { // rank1이 rank2보다 깊음
			parent[root1] += parent[root2]; // rank1에 rank2를 더해줌 -> 랭크 수 늘리기
			parent[root2] = root1;
		} else {
			parent[root2] += parent[root1]; // rank2에 rank1를 더해줌 -> 랭크 수 늘리기
			parent[root1] = root2;
		}
	}	
	
	/**
	 * 노드가 속한 트리의 총 노드 수 반환
	 * @param v
	 * @return
	 */
	public static int getSize(int v) {
		return -parent[findSet(v)];
	}
	public static void main(String[] args) {
		int N = 6;
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		
		System.out.println("================ [make set] ================");
		System.out.println(Arrays.toString(parent));
		union(4,3);
		union(4,2);
		union(6,5);
		System.out.println("================ [union set] ================");
		System.out.println(Arrays.toString(parent));
		union(5,2);
		System.out.println(Arrays.toString(parent));
		System.out.println("================ [find set] ================");
		System.out.printf("2,4 : %b \n", findSet(2) == findSet(4));
		System.out.printf("2,6 : %b \n", findSet(2) == findSet(6));
		System.out.println("================ [get size] ================");
		System.out.println("2번 노드가 속한 트리의 size : "+getSize(2));
		
	}

}
