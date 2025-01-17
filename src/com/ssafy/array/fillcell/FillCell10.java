package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 초기 좌표에서 이동 방향 개수 만큼 이동후 마지막 이동 좌표 출력하기
 * 이동좌표가 범위를 벗어나면 -1 -1으로 출력하기 
 * 입력 :
 *  다음줄 부터 :  배열의 개수   초기row좌표, 초기col좌표, 이동 개수 , {이동 방향, 스텝} *n 
 *  1 : 오른쪽 
 *  2 : 아래쪽
 *  3 : 왼쪽
 *  4 : 윗쪽
 *  
 *  8  3 3 3 1 1 2 2 1 1                 결과] # 이동좌표 x :5 y:5  
 *  8  3 1 3 4 2 1 1 4 1                 결과] # 이동좌표 x :-1 y:-1
 */
public class FillCell10 {
	static int Answer1, Answer2;
	public static void main(String[] args) {
//		Scanner sc = new Scanner("8  3 3 3 1 1 2 2 1 1");
		Scanner sc = new Scanner("8  3 1 3 4 2 1 1 4 2");
//		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int num = sc.nextInt();
		int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
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
			else {
				Answer1 = Answer2 = -1;
				break;
			}
		}
		Answer1 = Answer1 != -1 ? r:-1;
		Answer2 = Answer2 != -1 ? c:-1;
		System.out.println("# 이동좌표 x :"+Answer1+ " y:"+Answer2);
	}
}
