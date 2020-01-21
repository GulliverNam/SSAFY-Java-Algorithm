package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_Gravity_남기원 {
	public static int data[][];
	
	public static void build(Scanner s, int size) {
		data = new int[size][size];
		for(int i = 0; i < size; i++) {
			int box = s.nextInt();
			for(int j=size-1; j>size-box-1; j--) {
				data[j][i] = 1;
			}
		}
	}
	
	public static int[][] rotate(int size) {
		int newData[][] = new int[size][size];
		
		for(int i=0; i<size; i++)
			for(int j=size-1; j>-1; j--)
				newData[i][size-j-1] = data[j][i];

		return newData;
	}
	
	public static int findHeight(int size) {
		int answer = 0;
		for(int i = 0; i < size; i++) {
			boolean check = false;
			int temp = 0;
			int max = 0;
			for(int j=0; j < size; j++) {
				if(!check && data[j][i] == 1)
					check = true;
				else if(check) {
					if(j == size - 1) max = Math.max(max, temp+1);
					else {
						if(data[j][i] == 0)
							temp += 1;
						else {
							max = Math.max(max, temp);
							temp = 0;
						}
					}
				}
			}
			answer = Math.max(answer, max);
		}
		return answer;
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/book/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		build(scan, size);
		data = rotate(size);
		int answer = findHeight(size);
		answer = answer > 0 ? answer + 1 : 0;
		System.out.println(answer);
	}
}
