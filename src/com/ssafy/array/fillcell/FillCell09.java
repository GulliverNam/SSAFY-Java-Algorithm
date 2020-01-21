package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 초기 좌표에서 이동
 * 경계를 벗어난 경우  out문자 출력 
 * 입력 :
 *  다음줄 부터 :  배열의 개수   초기row좌표, 초기col좌표, 이동 개수 , {이동 방향, 스텝} *n 
 *  1 : 오른쪽 
 *  2 : 아래쪽
 *  3 : 왼쪽
 *  4 : 윗쪽
 *  
 *  8  3 3 3 1 1 2 2 1 1	
 *  8  3 1 3 4 2 1 1 4 1	
 */
public class FillCell09 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner("8  3 3 3 1 1 2 2 1 1");
		Scanner sc = new Scanner("8  3 1 3 4 2 1 1 4 1");
//		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int num = sc.nextInt();
		int dir[][] = {{-1, 0},{1,0},{0,-1},{0,1}};
		int selectDir, step, nr, nc;
		for(int i = 0; i < num; i++) {
			selectDir = sc.nextInt();
			step = sc.nextInt();
			nr = r + dir[selectDir-1][0]*step;
			nc = c + dir[selectDir-1][1]*step;
			if(nr > -1 && nr < N && nc > -1 && nc < N) {
				map[r][c] = 0;
				map[nr][nc] = 1;
				r = nr;
				c = nc;
			}
			else
				System.out.println("out");
			
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					System.out.print(map[a][b]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
		
//		for(int i = 0; i < num/2; i++) {
//			int nr = xy[i][0] + dir[selectDir-1][0];
//			int nc = xy[i][1] + dir[selectDir-1][1];
//			if(nr > -1 && nr < N && nc > -1 && nc < N)
//				map[nr][nc] = 1;
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
