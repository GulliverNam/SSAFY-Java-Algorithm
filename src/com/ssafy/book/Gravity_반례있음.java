package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gravity_반례있음 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/book/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int maxHeight = 0;
		int max = n;
		boolean check = false;
		for (int i = 0; i < n; i++) {
			int height = scan.nextInt();
			if(!check && height != 0)
				check = true;
			if(height >= maxHeight) {
				maxHeight = height;
				max--;
			}
		}
		max = max != n ? max : 0;
		System.out.println(max);
	}
}
