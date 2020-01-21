package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_Gravity_남기원2 {
	
	public static int nums[];
	
	public static int findHeight(Scanner s, int size) {
		nums = new int[size];
		for(int i=0; i<size; i++)
			nums[i] = s.nextInt();
		
		int answer = 0;
		int max_num = 0;
		int cnt = 0;
		boolean check = false;
		for (int i = 0; i < size; i++) {
			if(!check && nums[i] != 0) {
				check = true;
				max_num = nums[i];
			}
			else if(check) {
				if(max_num <= nums[i]) {
					answer = Math.max(answer, cnt);
					max_num = nums[i];
					cnt = 0;
				}
				else if(max_num > nums[i]) {
					if(i == size-1)
						answer = Math.max(answer, cnt + 1);
					else
						cnt += 1;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/book/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int answer = findHeight(scan, size);
		answer = answer > 0 ? answer + 1 : 0;
		System.out.println(answer);
	}

}
