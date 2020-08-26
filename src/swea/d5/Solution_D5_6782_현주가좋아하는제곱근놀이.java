package swea.d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D5_6782_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine().trim());
			long answer = 0;
			while(N != 2) {
				long num = (long)Math.sqrt(N);
				if(num*num != N) {
					long upto = (num+1)*(num+1);
					answer += upto - N;
					N = upto;
				}
				answer += 1;
				N = (long)Math.sqrt(N);
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

}
