package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_1592_영식이와친구들.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int count[] = new int[N+1];
		count[1] = 1;
		int cur = 1;
		int answer = 0;
		while(count[cur] < M) {
			if(count[cur] % 2 == 1)
				cur = cur + L > N ? (cur + L) % N : cur + L;
			else
				cur = cur - L <= 0 ? N + cur - L : cur - L;
			count[cur]++;
			answer++;
		}
		System.out.println(answer);
	}

}
