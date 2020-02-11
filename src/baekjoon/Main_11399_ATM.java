package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_11399_ATM.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int people[][] = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			people[i][0] = i;
			people[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] > o2[1])
					return 1;
				if (o1[1] == o2[1])
					return 0;
				return -1;
			}
		});
		int sum = 0;
		int answer = 0;
		for (int i = 2; i <= N+1; i++) {
			sum += people[i-1][1];
			answer += sum;
		}
		System.out.println(answer);
		
	}

}
