package com.ssafy.track;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyGinGame {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int count[] = new int[10];
		int num;
		boolean triple = false, run = false;
		for (int i = 0; i < 6; i++) {
			num = Integer.parseInt(st.nextToken());
			count[num]++;
			if(count[num] == 3) {
				count[num] = 3;
				triple = true;
			}
		}
		
		for (int i = 1; i < 8; i++) {
			if(count[i] >= 1 && count[i+1] >= 1 && count[i+2] >= 1) {
				run = true;
			}
		}
		
		if(triple && run)
			System.out.println("Baby Gin!!");
		else
			System.out.println("No!!");
		
		
		
	}

}
