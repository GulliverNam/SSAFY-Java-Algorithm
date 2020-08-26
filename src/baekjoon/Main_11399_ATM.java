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
		int people[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		int sum = 0;
		int answer = 0;
		for (int i = 2; i <= N+1; i++) {
			sum += people[i-1];
			answer += sum;
		}
		System.out.println(answer);
		
	}

}
