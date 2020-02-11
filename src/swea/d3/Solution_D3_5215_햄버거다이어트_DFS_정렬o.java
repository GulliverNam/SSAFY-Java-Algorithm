package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_DFS_정렬o {
	static Integer meals[][];
	static int N;
	static int maxCal, answer;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_5215_햄버거다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			maxCal = Integer.parseInt(st.nextToken());
			meals = new Integer[N][2];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				meals[i][0] = Integer.parseInt(st.nextToken());
				meals[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(meals, new Comparator<Integer[]>() {
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					if(o1[1] == o2[1])
						return o1[0] < o2[0] ? 1 : -1;
					return o1[1] > o2[1] ? 1 : -1;
				}
			});
			
			dfs(0, 0, 0);
			System.out.println("#"+test_case+" "+answer);
		}
	}
	private static void dfs(int start, int sumCal, int sumScore) {
		answer = Math.max(answer, sumScore);
		for (int i = start; i < N; i++) {
			if(sumCal+meals[i][1] <= maxCal)
				dfs(i+1, sumCal+meals[i][1], sumScore+meals[i][0]);
			else
				return;
		}
	}
}
