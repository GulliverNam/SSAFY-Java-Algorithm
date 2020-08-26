package baekjoon;

import java.io.*;
import java.util.*;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		String[] AB = br.readLine().trim().split(" ");
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		long answer = n;
		for (int i = 0; i < n; i++) {
			int examinee = Integer.parseInt(st.nextToken()) - A;
			if(examinee < 0) continue;
			if(examinee % B == 0) {
				answer += examinee / B;
			} else {
				answer += (examinee / B) + 1;
			}
		}
		System.out.println(answer);
	}

}
