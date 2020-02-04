package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1229_암호문2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1229_암호문2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N, C;
		LinkedList<Integer> crypto = new LinkedList<>();
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				crypto.offer(Integer.parseInt(st.nextToken()));
			C = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			char c;
			int x, y;
			for (int i = 0; i < C; i++) {
				c = st.nextToken().charAt(0);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					switch(c) {
						case 'I':
							crypto.add(x++, Integer.parseInt(st.nextToken()));
							break;
						case 'D':
							crypto.remove(x);
							break;
					}
				}
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < 10; i++)
				System.out.print(crypto.get(i)+" ");
			System.out.println();
			crypto.clear();
		}
		
	}

}
