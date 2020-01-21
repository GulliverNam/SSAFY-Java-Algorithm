package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Gravity2 {
	
	public static int map[][];
	
	public static void build(Scanner s, int size) {
		map = new int[size][size];
		for(int i = 0; i < size; i++) {
			int m = s.nextInt();
			for(int j=size-1; j>size-m-1; j--)
				map[j][i] = 1;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/book/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		build(scan, n);
		
		int answer = 0;
		int next = 0;
		int cnt = 0;
	
//		n-2번째 열 부터 박스를 이동
		for(int i = n-2; i>-1; i--) {
			for(int j=0; j<n; j++) {
				if(map[j][i] == 1) {
					next = n-1-i;
					for(int k =1; k<=next;k++) {
						if(map[j][i+k] == 0) {
							cnt++;
							map[j][i+k-1]=0;	// 현재칸은 비워둠
							map[j][i+k]=1;		// 다음칸으로 이동
						} else {
							break;
						}
					}
					answer = Math.max(cnt, answer);
					cnt = 0;
				}
			}
		}
		System.out.println("answer: " + answer);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
