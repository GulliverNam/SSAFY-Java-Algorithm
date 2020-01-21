package com.ssafy.array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Gravity3_반례있음 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); 		//배열의 크기 
		
		int maxHeight = 0; 
		int max = n ;
		for (int i = 0; i < n; i++) {
			int height = scan.nextInt();
			if(height>=maxHeight) {
				maxHeight = height;
				max--;
			}
		}
		if(max == n) {	//box가 map에 하나도 없는 경우 
			System.out.println(0);
		}else {
			System.out.println(max);
		}
	}
}














