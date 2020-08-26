package baekjoon;

import java.util.*;
import java.io.*;

public class Main_1806_부분합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		int start = 0;
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += nums[i];
			while(sum - nums[start] >= s) {
				sum -= nums[start++];
			}
			if(sum >= s) {
				answer = Math.min(answer, i-start+1);
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

}
