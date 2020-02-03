package com.ssafy.array;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
public class Gravity2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); 		//배열의 크기 
		
		int[][] map = new int [n][n];	//상자가 쌓이 맵
		
		int m;							//상자 높이
		for (int i = 0; i < n; i++) {	//열 반복
			m = scan.nextInt();
			for (int j = n-1; j >=0; j--) {	//행 반복
				if(m==0) {
					break;
				}
				map[j][i] = 1;
				m--;
			}
			System.out.println(Arrays.toString(map[i]));
		}
//		for (int[] box : map) {
//			System.out.println(Arrays.toString(box));
//		}
		
		int answer = -1;			//최대 낙차 
		int next = 0;
		int count= 0;
		
		//n-2번째 열 부터 박스를 이동하기
		for (int i = n-2; i >=0; i--) {
			for (int j = 0; j < n; j++) {	//행
				if(map[j][i] == 1) {
					next = n-1 -i;
					for (int k = 1; k <=next; k++) {
						if(map[j][i+k]==0) { //다음 칸이 움직일 수 있다. 
							count++;
							map[j][i+k]=1;	 //다음 칸으로 박스를 이동 
							map[j][i+k-1]=0; //현재 칸은 비우기
						}else {
							break;			 //다음 칸이 움직일 수 없기때문에 멈추기 
						}
					}
					answer = Math.max(count, answer);
					count=0;
				}
			}
		}
		System.out.println("answer:"+answer);
		for (int[] box : map) {
			System.out.println(Arrays.toString(box));
		}
		scan.close();
	}
}
























