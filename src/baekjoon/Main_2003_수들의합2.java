package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int sum = 0;
		long answer = 0;
		for(int i=0; i<n; i++) {
			sum += nums[i];
			if(sum > m) {
				while(sum > m) {
					sum -= nums[start++];
				}
			}
			if(sum == m) {
				answer++;
				sum -= nums[start++];
			}
		}
		System.out.println(answer);
		
	}

}
