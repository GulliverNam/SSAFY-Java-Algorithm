package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	
	static int[] student;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1863_종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		student = new int[n+1];
		for (int i = 1; i <= n; i++)
			makeSet(i);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <= n; i++) {
			if(student[i] < 0)
				answer++;
		}
		System.out.println(answer);
		
	}
	
	public static void makeSet(int v) {
		student[v] = -1;
	}
	
	public static int findSet(int v) {
		if(student[v] < 0)	
			return v;
		return findSet(student[v]);
	}
	
	public static void union(int u, int v) {
		int root1 = findSet(u);
		int root2 = findSet(v);
		if(root1 == root2) return;
		
		int rank1 = student[root1];
		int rank2 = student[root2];
		if(rank1 < rank2) { 
			student[root1] += student[root2];
			student[root2] = root1;
		} else {
			student[root2] += student[root1];
			student[root1] = root2;
		}
	}	
}

