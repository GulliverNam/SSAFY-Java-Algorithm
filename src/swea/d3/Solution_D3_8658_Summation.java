package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8658_Summation {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_8658_Summation.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int min, max;
		char[] str;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			int sum;
			for (int i = 0; i < 10; i++) {
				str = st.nextToken().toCharArray();
				sum = 0;
				for (char c : str) {
					sum += c - '0';
				}
				min = Math.min(min, sum);
				max = Math.max(max, sum);
			}
			System.out.println("#"+tc+" "+max+" "+min);
		}
	}

}
