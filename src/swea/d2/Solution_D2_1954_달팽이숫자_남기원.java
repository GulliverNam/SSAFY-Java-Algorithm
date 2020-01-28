package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자_남기원 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1954_달팽이숫자.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int dir[][] = {{0, 1}, {1, 0}, {0 ,-1}, {-1, 0}};
		int N, snail[][];
		for(int test_case = 1; test_case <= T; test_case++) {
			N = scan.nextInt();
			snail = new int[N][N];
			
			int x = 0, y = 0, d = 0;
			int nx, ny;
			
			for (int i = 1; i <= N*N; i++) {
				snail[x][y] = i;
				nx = x + dir[d][0];
				ny = y + dir[d][1];
				if(nx == -1 || nx == N || ny == -1 || ny == N || snail[nx][ny] != 0) {
					d = (d + 1) % 4;
					nx = x + dir[d][0];
					ny = y + dir[d][1];
				}
				x = nx;
				y = ny;
			}
			
			System.out.println("#"+test_case);
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++)
					System.out.printf("%3d ", snail[a][b]);
				System.out.println();
			}
			
		}
		
	}
}
