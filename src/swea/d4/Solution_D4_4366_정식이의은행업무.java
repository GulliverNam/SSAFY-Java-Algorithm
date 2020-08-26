package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_4366_정식이의은행업무 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			String binary = br.readLine().trim();
			String trinary = br.readLine().trim();
			int bLength = binary.length();
			int tLength = trinary.length();
			long[] arr1 = new long[bLength];
			long[] arr2 = new long[tLength*2];
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < bLength; i++) {
				for (int j = 0; j < 2; j++) {
					if(binary.charAt(i)-'0' != j) {
						String num = binary.substring(0, i)+String.valueOf(j)+binary.substring(i+1);
						arr1[cnt1++] = Long.parseLong(num, 2);
					}
				}
			}
			for (int i = 0; i < tLength; i++) {
				for (int j = 0; j < 3; j++) {
					if(trinary.charAt(i)-'0' != j) {
						String num = trinary.substring(0, i)+String.valueOf(j)+trinary.substring(i+1);
						arr2[cnt2++] = Long.parseLong(num, 3);
					}
				}
			}
			Long answer = 0L;
			top:
			for (int i = 0; i < bLength; i++) {
				for (int j = 0; j < tLength*2; j++) {
					if(arr1[i] == arr2[j]) {
						answer = arr1[i];
						break top;
					}
				}
			}
			
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

}
