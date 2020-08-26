package swea.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_5607_조합 {
	
	static int mod = 1234567891;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long factorial[] = new long[n+1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++) {
				factorial[i] = (factorial[i-1]*i) % mod;
			}
			long bottom = (factorial[r] * factorial[n - r]) % mod;
            long inverse = fermat(bottom, mod - 2);
            
			bw.write("#"+tc+" "+(factorial[n]*inverse % mod)+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static long fermat(long n, int x) {
        if (x == 0) return 1;
        long temp = fermat(n, x / 2);
        long result = (temp * temp) % mod;
        if (x % 2 == 0) return result;
        else return (result * n) % mod;
    }

}
