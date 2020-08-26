package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1062_가르침 {
	
	static String[] words;
	static int answer;
	static int limit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(k <= 4) {
			System.out.println(0);
		} else if(k == 26) {
			System.out.println(n);
		} else {
			words = new String[n];
			answer = 0;
			char[] base = "antic".toCharArray();
			for (int i = 0; i < n; i++) {
				words[i] = br.readLine().trim().substring(4);
				words[i] = words[i].substring(0,words[i].length()-4);
			}
			int chars = 0;
			for (char c : base) {
				chars = chars | 1 << (c-'a'); 
			}
			
			limit = k-5;
			subSet(1, 0, chars);
			System.out.println(answer);
		}
	}

	private static void subSet(int start, int cnt, int chars) {
		if(cnt == limit) {
			answer = Math.max(answer, maxWord(chars));
			return;
		}
		for(int i = start; i < 26; i++) {
			if((chars & 1 << i) == 0) {
				subSet(i+1, cnt+1, chars | 1 << i);
			}
		}
	}

	private static int maxWord(int chars) {
		int result = 0;
		top:
		for (String w : words) {
			for (char c : w.toCharArray()) {
				if((chars & 1 << (c-'a')) == 0) {
					continue top;
				}
			}
			result++;
		}
		return result;
	}

}
