package com.ssafy.array.fillcell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation2 {
    static int AnswerN=0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN = 0;
			int N = sc.nextInt();
			char map[][] = new char[N][N];
			int totalHome = 0;
			int coverHome = 0;
//			 1.	Load data and make map
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
					if(map[i][j] == 'H') totalHome++;
				}
//				toCharArray : 문자열에서 한 문자 하나씩 추출해서 배열에 담아 리턴함
//				map[i] = sc.nextLine().toCharArray();
			}
			
//			2.	Search all the map and find 'A'
//				If there is 'H' at all direction(up, down, left, right), change 'H' to 'X'
			int nr, nc, n = dir.length;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'A') {
						for(int k=0; k<n; k++) {
							nr = i + dir[k][0];
							nc = j + dir[k][1];
							if(nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 'H') {
								map[nr][nc] = 'X';
								coverHome++;
							}
						}
					}
				}
			}
			
			
//			3.	Search all the map and count the remain 'H'
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(map[i][j] == 'H')
//						AnswerN++;
//				}
//			}
			
			AnswerN = totalHome - coverHome;
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
}//end class









