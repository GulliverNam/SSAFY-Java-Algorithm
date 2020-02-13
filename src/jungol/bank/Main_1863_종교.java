package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1863_종교 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1863_종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[n+1];
		LinkedList<int[]> data = new LinkedList<>();
		
		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			data.add(new int [] {Math.min(a, b), Math.max(a, b)});
		}
		
		data.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		int answer = 0;
		while(!data.isEmpty()) {
			int cur[] = data.poll();
			int prev0 = cur[0];
			int prev1 = cur[1];
			check[prev0] = true;
			check[prev1] = true;
			for (int i = 0, size = data.size(); i < size; i++) {
				cur = data.poll();
				if(prev0 == cur[0] && prev1 == cur[1]) {
					continue;
				} else if(prev0 == cur[0]) {
					check[cur[1]] = true;
				} else if(prev1 == cur[0]) {
					check[cur[1]] = true;
					prev0 = cur[0];
					prev1 = cur[1];
				} else {
					data.add(new int[] {cur[0], cur[1]});
				}
			}
			answer++;
		}
		
		for (int i = 0; i < n; i++) {
			if(!check[i])
				answer++;
		}
		System.out.println(answer);
	}

}
