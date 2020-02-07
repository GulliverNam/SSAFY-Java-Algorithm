package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {

	static int N, Answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_16987_계란으로계란치기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		int eggs[][] = new int[N][2];
		
		for (int i = 0; i < eggs.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		
		
	}
	
}
