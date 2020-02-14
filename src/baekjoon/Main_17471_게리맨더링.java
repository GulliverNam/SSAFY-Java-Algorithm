package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

	static boolean adjacent[][], check[];
	static int N, population[];
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_17471_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		population = new int[N + 1];
		adjacent = new boolean[N + 1][N + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int length = Integer.parseInt(st.nextToken());
			for (int j = 0; j < length; j++) {
				adjacent[i][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		for (int i = 1; i <= N/2; i++)
			subSet(i, 0, 0, new boolean[N+1]);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	private static void subSet(int num, int start, int cnt, boolean[] subset) {
		if(cnt == num) {
			findPath(subset);
			return;
		}
		for (int i = start+1; i <= N; i++) {
			subset[i] = true;
			subSet(num, i, cnt+1, subset);
			subset[i] = false;
		}
	}



	private static void findPath(boolean[] subset) {
		LinkedList<Integer> s1 = new LinkedList<>();
		LinkedList<Integer> s2 = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(subset[i])
				s1.add(i);
			else
				s2.add(i);
		}
		
		if(findAdjacent(new LinkedList<Integer>(s1)) && findAdjacent(new LinkedList<Integer>(s2))) {
			int sum1 = 0, sum2 = 0;
			for (Integer i : s1)
				sum1 += population[i];
			for (Integer i : s2)
				sum2 += population[i];
			answer = Math.min(answer, Math.abs(sum1-sum2));
		}
		
	}
	
	private static boolean findAdjacent(LinkedList<Integer> subset) {
		LinkedList<Integer> queue = new LinkedList<>();
		int curValue = subset.poll();
		queue.add(curValue);
		check = new boolean[N+1];
		check[curValue] = true;
		boolean cur[];
		while(!queue.isEmpty()) {
			cur = adjacent[queue.poll()];
			for (Integer i : new LinkedList<Integer>(subset)) {
				if(cur[i] && !check[i]) {
					check[i] = true;
					queue.add(i);
					subset.remove((Integer)i);
					if(subset.size() == 0)
						return true;
				}
			}
		}
		if(subset.size() > 0)
			return false;
		return true;
	}
}
