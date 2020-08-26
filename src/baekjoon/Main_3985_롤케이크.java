package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine().trim());
		int N = Integer.parseInt(br.readLine().trim());
		int cake[] = new int[L+1];
		int count[] = new int[N+1];
		int p,k;
		int expect = 0, expectPerson = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			p = Integer.parseInt(st.nextToken()); // P
			k = Integer.parseInt(st.nextToken()); // K
			if(expect < k-p) {
				expect = k-p;
				expectPerson = i;
			}
			for (int j = p; j <= k; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					count[i]++;
				}
			}
		}
		int actual = count[1], actualPerson = 1;
		for (int i = 2; i <= N; i++) {
			if(actual < count[i]) {
				actual = count[i];
				actualPerson = i;
			}
		}
		System.out.println(expectPerson);
		System.out.println(actualPerson);
		
	}

}
