package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_Gravity_남기원2 {
	
	public static int nums[];
	
	public static int findHeight(Scanner s, int size) {
		nums = new int[size];
		int answer = 0;
		for(int i = 0; i < size; i++)
			nums[i] = s.nextInt();
		for (int i = 0; i < size-1; i++) {
			if(nums[i] != 0) {
				int temp = 0;
				for (int j = i+1; j< size; j++) {
					if(nums[i] > nums[j])
						temp += 1;
					else
						break;
				}
				answer = Math.max(answer, temp);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/book/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int answer = findHeight(scan, size) + 1;
		System.out.println(answer);
	}

}
