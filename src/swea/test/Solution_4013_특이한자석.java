package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_4013_특이한자석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int K, gear[][], starts[], answer;
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine().trim());
			gear = new int[5][8];
			starts = new int[5];
			answer = 0;
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 8; j++)
					gear[i][j] = Integer.parseInt(st.nextToken());
			}
			LinkedList<Integer> change = new LinkedList<Integer>();
			int start, turn;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				start = Integer.parseInt(st.nextToken());
				turn = Integer.parseInt(st.nextToken()) * (-1);
				
				int prev, cur, next;
				int t = turn;
				for (int j = start; j > 1; j--) {
					cur = (starts[j] + 6) % 8;
					prev = (starts[j-1] + 2) % 8; 
					if((gear[j][cur] ^ gear[j-1][prev]) != 1)
						break;
					else
						change.add(j-1);
				}
				for (Integer j : change) {
					t *= (-1);
					starts[j] = starts[j] + t < 0 ? 7 : (starts[j] + t) % 8; 
				}
				t = turn;
				change.clear();
				for (int j = start; j < 4; j++) {
					cur = (starts[j] + 2) % 8;
					next = (starts[j+1] + 6) % 8; 
					if((gear[j][cur] ^ gear[j+1][next]) != 1)
						break;
					else {
						change.add(j+1);
					}
				}
				for (Integer j : change) {
					t *= (-1);
					starts[j] = starts[j] + t < 0 ? 7 : (starts[j] + t) % 8; 
				}
				starts[start] = starts[start] + turn < 0 ? 7: (starts[start] + turn) % 8;
				change.clear();
			}
			for (int i = 1; i < 5; i++) {
				if(gear[i][starts[i]] == 1) {
					answer += (1 << (i-1));
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

}
