package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16235_나무재테크 {
	
	static PriorityQueue<Tree> trees = new PriorityQueue<Tree>();
	static PriorityQueue<Tree> aliveTree = new PriorityQueue<Tree>();
	static PriorityQueue<Tree> deadTree = new PriorityQueue<Tree>();
	static int[][] farm, nutrient;
	static int N, dr[] = {-1,-1,-1,0,0,1,1,1}, dc[] = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		farm = new int[N][N];
		nutrient = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				nutrient[i][j] = Integer.parseInt(st.nextToken());
				farm[i][j] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken());
			trees.offer(new Tree(r, c, y));
		}
		
		
		for (int t = 0; t < K; t++) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(trees.size());
	}
	static void spring() {
		while(!trees.isEmpty()) {
			Tree tree = trees.poll();
			if(farm[tree.r][tree.c] >= tree.age) {
				farm[tree.r][tree.c] -= tree.age;
				tree.age++;
				aliveTree.offer(tree);
			} else {
				deadTree.offer(tree);
			}
		}
	}
	static void summer() {
		while(!deadTree.isEmpty()) {
			Tree tree = deadTree.poll();
			farm[tree.r][tree.c] += tree.age/2;
		}
	}
	static void autumn() {
		while(!aliveTree.isEmpty()) {
			Tree tree = aliveTree.poll();
			if(tree.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = tree.r + dr[i];
					int nc = tree.c + dc[i];
					if(nr > -1 && nr < N && nc > -1 && nc < N)
						trees.offer(new Tree(nr,nc,1));
				}
			}
			trees.offer(tree);
		}
	}
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				farm[i][j] += nutrient[i][j];
			}
		}
	}
	static class Tree implements Comparable<Tree>{
		int r, c, age;
		
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}		
	}
}
