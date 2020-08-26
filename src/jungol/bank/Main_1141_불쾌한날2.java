package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * n^2비교 -> 8만 번 -> 약 64억번 비교
 * Scanner 사용하면 오류
 * Buffered Reader
 * @author NamGiwon
 *
 */

public class Main_1141_불쾌한날2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1141_불쾌한날.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		long answer = 0;
		
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(Integer.parseInt(in.readLine().trim()));
		int max = stk.peek();
		int current;
		
		for (int i = 1; i < N; i++) {
			current = Integer.parseInt(in.readLine().trim());
			if(max <= current) {
				max = current;
				stk.clear();
			}
			else {
				while(stk.peek() <= current)
					stk.pop();
			}
			answer += stk.size();
			stk.push(current);
		}
		
		System.out.println(answer);
		
	}

}
