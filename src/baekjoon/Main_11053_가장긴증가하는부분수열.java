package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[n];
		int[] maxLength = new int[n];
		for (int i = n-1; i > -1; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(maxLength, 1);
		for(int i=0;i<n;i++) {
			int value = arr[i];
			int length = maxLength[i];
            for(int j=i+1;j<n;j++) {
            }
		}
		int answer = 0;
		for (int l : maxLength) {
			answer = Math.max(answer, l);
		}
		System.out.println(answer);
		
	}

}
