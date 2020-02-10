package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_DFS {
	static int N;
	static long maxCal, answer;
	static LinkedList<int[]> menus = new LinkedList<>();
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_5215_햄버거다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			maxCal = Integer.parseInt(st.nextToken());
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				menus.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			menus.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] > o2[1] ? 1 : -1;
				}
			});
			for (int[] i : menus) {
				System.out.println(Arrays.toString(i));
			}
			dfs(0, 0, 0);
			System.out.println("#"+test_case+" "+answer);
			menus.clear();
		}
	}
	private static void dfs(int start, long sumCal, long sumScore) {
		int cur[];
		answer = Math.max(answer, sumScore);
		for (int i = start; i < N; i++) {
			cur = menus.get(i);
			if(sumCal+cur[1] <= maxCal) {
				dfs(i+1, sumCal+cur[1], sumScore+cur[0]);
			} else {
				return;
			}
		}
	}
}
