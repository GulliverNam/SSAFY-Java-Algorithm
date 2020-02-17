package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1240_단순2진암호코드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, M;
		String code[];
		String decode[] = {"0001101","0011001","0010011",
						   "0111101","0100011","0110001",
						   "0101111","0111011","0110111",
						   "0001011"};
		int answer[], odd, even, sum;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			code = new String[N];
			answer = new int[8];
			odd = 0;
			even = 0;
			sum = 0;
			for (int i = 0; i < code.length; i++) {
				code[i] = br.readLine().trim();
			}
			top1:
			for (int i = 0; i < N; i++) {
				top2:
				for (int j = 0; j < M-3; j++) {
					if(code[i].charAt(j) == '0' && code[i].charAt(j+1) == '0' &&
					   code[i].charAt(j+2) == '0' && code[i].charAt(j+3) == '0') {
						continue;
					} else {
						for (int k = 1; k <= 8 ; k++) {
							if(code[i].charAt(j + 7*k - 1) != '1')
								continue top2;
						}
						
						for (int k = 0; k < 8; k++) {
							for (int no = 0; no < 10; no++) {
								if(code[i].substring(j+k*7, j+(k+1)*7).equals(decode[no])) {
									answer[k] = no;
									break;
								}
							}
						}
						for (int k = 0; k < 7; k++) {
							if(k % 2 == 0)
								odd += answer[k];
							else
								even += answer[k];
							sum += answer[k];
						}
						System.out.print("#"+tc+" ");
						if((odd*3 + even + answer[7]) % 10 == 0)
							System.out.println(sum+answer[7]);
						else
							System.out.println(0);
						break top1;
						
					}
				}
			}
		}
	}

}
