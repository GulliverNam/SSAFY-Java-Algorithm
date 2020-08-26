package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1234_비밀번호.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int N;
		LinkedList<Character> charList = new LinkedList<>();
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			for (char c : st.nextToken().toCharArray()) {
				charList.add(c);
			}
			
			boolean check = false;
			while(!check) {
				check = true;
				for (int i = 0; i < charList.size()-1; i++) {
					if(charList.get(i) == charList.get(i+1)) {
						check = false;
						charList.remove(i);
						charList.remove(i);
						break;
					}
				}
			}
			System.out.print("#"+testCase+" ");
			for (char c : charList)
				System.out.print(c);
			System.out.println();
			charList.clear();
		}
	}

}
