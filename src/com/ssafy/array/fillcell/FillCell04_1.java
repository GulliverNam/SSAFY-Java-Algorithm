package com.ssafy.array.fillcell;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 좌표에서 지정한 칸수까지 상하좌우로 1 채우기
 * 입력 :
 *  배열의 개수   row좌표, column좌표, 칸수
 *  ex) 8  1  1  3
 * 
 */
public class FillCell04_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int count = sc.nextInt();
		
		for(int i = -count; i <= count;i++) {
			if(i == 0) continue;
			if(r+i > -1 && r+i < N) map[r+i][c] = 1;
			if(c+i > -1 && c+i < N) map[i][c+i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
