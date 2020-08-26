package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String croatia[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < croatia.length; i++) {
			map.put(croatia[i], i);
		}
		String str = br.readLine().trim();
		int idx, answer = 0;
		for (int i = 0; i < str.length(); i++) {
			try {
				idx = map.get(str.substring(i, i+2));
				answer++;
				i++;
			} catch(NullPointerException e) {
				try {
					idx = map.get(str.substring(i, i+3));
					answer++;
					i+=2;
				} catch(NullPointerException ee) {
					answer++;
				} catch(StringIndexOutOfBoundsException ee) {
					answer++;
				}
			} catch(StringIndexOutOfBoundsException e) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
