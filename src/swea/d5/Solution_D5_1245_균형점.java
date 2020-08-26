package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1245_균형점 {
	static double xw[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			xw = new double[N][2];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N*2; i++) {
				if(i<N)
					xw[i][0] = Double.parseDouble(st.nextToken());
				else {
					xw[i-N][1] = Double.parseDouble(st.nextToken());
				}
			}
			double left = 0, right = 0;
			double start = 0, dx = 0, min = Double.MAX_VALUE;
			for (int i = 0; i < N-1; i++) {
				double diff = (xw[i+1][0] - xw[i][0]) / 2;
				double num = xw[i][0] + diff;
				for (int j = 0; j <= i; j++) {
					left += getGravity(j, num);
				}
				for (int j = i+1; j <= N; j++) {
					right += getGravity(j, num);
				}
				if(min > Math.abs(left-right)) {
					min = Math.abs(left-right);
					start = num;
					dx = diff;
				}
				left = right = 0;
			}
			
			
			findBalance(start, dx, dx > 0);
			System.out.println("#"+tc+" ");
		}
	}

	private static void findBalance(double num, double dx, boolean goRight) {
		if(dx < 1e-12)
			return;
		if(goRight) {
			while(true) {
				num += dx;
				double left = 0, right = 0;
			}
		}else {
			for (int i = 0; i < xw.length; i++) {
				
			}
		}
	}

	private static double getGravity(int i, double num) {
		return (xw[i][1])/Math.pow((xw[i][0]-num), 2);
	}

}
