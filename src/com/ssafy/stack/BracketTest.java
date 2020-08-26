package com.ssafy.stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호검사
 * - 괄호 짝이 맞으면 OK, 짝이 맞지 않으면 Error를 출력
 * 
 * [입력]
 * 첫줄은 테스트 케이스(T) 수
 * 두번째 줄 부터 T줄의 괄호 데이터가 입력된다.
 * 
 * [출력]
 * #테스트케이스번호 결과
 * 
 * @author NamGiwon
 *
 */
public class BracketTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/bracket.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		char[] chr;
		Stack<Character> stk = new Stack<Character>();
		String msg;
		int length;
		for (int testCase = 1; testCase <= T; testCase++) {
			chr = sc.nextLine().toCharArray();
			length = chr.length;
			msg = "OK";
			char c;
			for (int i = 0; i < length; i++) {
				c = chr[i];
				if(c == '(')
					stk.push(c);
				else if(c == ')') {
					if(stk.isEmpty()) {
						msg = "Error";
						break;
					}
					stk.pop();
				}
			}
			if(!stk.isEmpty())
				msg = "Error";
			System.out.println("#"+testCase+" "+msg);
			stk.clear();
		}
		sc.close();
	}

}
