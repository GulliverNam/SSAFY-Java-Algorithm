package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1948_날짜계산기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1948_날짜계산기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int days[] = {0, 31, 28, 31, 30, 
					     31, 30, 31, 31,
					     30, 31, 30, 31};
		
		int T = Integer.parseInt(br.readLine().trim());
		int m1, d1, m2, d2, answer = 0;
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());
			answer = 0;
			for (int i = m1; i <= m2; i++) {
				if(m1 == m2) answer += (d2 - d1)+1;
				else {
					if(i == m1) answer += days[i] - d1 + 1;
					if(i == m2) answer += d2;
					if(i != m1 && i != m2) answer += days[i];
				}
			}
			System.out.println("#"+testCase+" "+answer);
		}
		
		
	}

}
