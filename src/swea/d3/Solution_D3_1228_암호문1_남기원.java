package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1_남기원 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/D3/Solution_D3_1228_암호문1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N, C;
		int x, y;
		LinkedList<Integer> crypto = new LinkedList<>();
		for (int testCase = 1; testCase <= 10; testCase++) {
			N = Integer.parseInt(in.readLine().trim());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++)
				crypto.add(Integer.parseInt(st.nextToken()));

			C = Integer.parseInt(in.readLine().trim());
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < C; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					crypto.add(x++, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(crypto.get(i)+" ");
			}
			System.out.println();
			crypto.clear();
		}
	}

}
