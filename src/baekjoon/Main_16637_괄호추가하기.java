package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16637_괄호추가하기 {
	static int N, answer = Integer.MIN_VALUE;
	static char[] math;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		math = br.readLine().toCharArray();
		findMax(1, math[0]-'0');
		System.out.println(answer);
	}

	private static void findMax(int i, int result) {
		if(i > N-1) {
			answer = Math.max(answer, result);
			return;
		}
		findMax(i+2, calculate(i, result, math[i+1]-'0'));
		if(i < N-2)
			findMax(i+4, calculate(i, result, calculate(i+2, math[i+1]-'0', math[i+3]-'0')));
		
	}

	private static int calculate(int idx, int prev, int next) {
		int result = 0; 
		switch(math[idx]) {
		case '+': result = prev + next; break;
		case '-': result = prev - next; break;
		case '*': result = prev * next; break;
		case '/': result = prev / next; break;
		}
		return result;
	}
	

}
