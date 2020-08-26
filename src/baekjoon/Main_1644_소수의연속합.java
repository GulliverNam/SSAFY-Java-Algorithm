package baekjoon;

import java.util.*;
import java.io.*;

public class Main_1644_소수의연속합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		boolean[] notPrime = new boolean[n+1];
		notPrime[0] = notPrime[1] = true;
		List<Integer> pNums = new ArrayList<>();
		for(int i = 2; i <= n; i++) {
			int num = 0;
			if(!notPrime[i]) pNums.add(i);
			while(num <= n) {
				notPrime[num] = true;
				num += i;
			}
		}
		int length = pNums.size();
		int answer = 0;
		int sum = 0;
		int start = 0;
		for(int i=0; i<length;i++) {
			sum += pNums.get(i);
			while(sum > n) {
				sum -= pNums.get(start++);
			}
			if(sum == n)
				answer++;
		}
		System.out.println(answer);
	}

}
