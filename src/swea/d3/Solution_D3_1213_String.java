package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String target = br.readLine().trim();
			String strs = br.readLine().trim();
			int length = target.length();
			int answer = 0;
			for (int i = 0; i < strs.length()-length+1; i++) {
				if(strs.substring(i, i+length).equals(target)) {
					answer++;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

}
