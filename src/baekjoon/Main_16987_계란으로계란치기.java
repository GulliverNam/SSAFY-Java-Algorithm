package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {

	static int N, Answer;
	static int candidate[], Eggs[][], SortedEggs[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_16987_계란으로계란치기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		Eggs = new int[N][2];
		Answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			Eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		
		dfs(0);
		System.out.println(Answer);
	}

	

	private static void dfs(int index) {
		if(index == N) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				if(Eggs[i][0] <= 0) num++;
			}
			Answer = Math.max(Answer, num);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(i != index) {
				if(checkFinish(index)) {
					dfs(index+1);
					return;
				}
				if(Eggs[index][0] <= 0) {
					dfs(index+1);
					return;
				}
				if(Eggs[i][0] > 0) {
					Eggs[index][0] -= Eggs[i][1];
					Eggs[i][0] -= Eggs[index][1];
					dfs(index+1);
					Eggs[index][0] += Eggs[i][1];
					Eggs[i][0] += Eggs[index][1];
				}
			}
		}
		
	}

	private static boolean checkFinish(int pick) {
		for (int i = 0; i < N; i++)
			if(pick != i && Eggs[i][0] > 0)
				return false;
		return true;
	}	
}
