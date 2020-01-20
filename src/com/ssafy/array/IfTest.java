package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IfTest {
//	java 알고리즘을 풀 때는 try, catch 구문보다 throws로 처리하는게 더 빠름.
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * if(조건){
		 * 	// 조건이 참인경우 수행할 문장;
		 * }
		 * 
		 * if(조건){
		 * 	// 조건이 참인 경우 수행할 문장;
		 * }else{
		 * 	// 조건이 거짓일 때 수행할 문장;
		 * }
		 * 
		 * if(조건){
		 * 	// 조건이 참인 경우 수행할 문장;
		 * }else if(조건){
		 * 	..
		 * }else{
		 * 	// 조건이 거짓일 때 수행할 문장;
		 * }
		 * 
		 */
		
//		파일로 입력받을 때 사용하는 구문
//		setIn 구문을 통해 어떤 것으로 데이터를 받을지 결정
		System.setIn(new FileInputStream("res/a.txt"));
		
//		*Scanner
//		- Scanner 보다 BufferedInputStream가 더 빠름
//		- BufferedInputStream
//		- 시스템, 네트워크, 파일로부터 데이터를 받을 수 있으나 
//		Scanner는 성능이 느려서 실무에서 많이 사용하지 않음.
		Scanner scan = new Scanner(System.in);
		
//		scan.next() -> 공백 or 개행문자를 기준으로 하나의 데이터라고 판단(공백과 개행문자를 제외한 나머지)
//		scan.nextLine() -> 개행문자를 기준으로 하나의 데이터라고 판단(공백을 제외한 나머지 )
		
		System.out.println("이름을 입력해 주세요");
		System.out.println("이름은 " + scan.next() + " 입니다.");
		
		System.out.println("나이를 입력해 주세요");
		System.out.println("나이는 " + scan.next() + " 입니다.");

		System.out.println("시간을 입력해 주세요");
		int time = scan.nextInt();
		
		if(time >= 9 && time < 12) System.out.println("오전 수업 시간입니다.");
		else if (time == 12) System.out.println("점심 시간 입니다.");
		else if (time >= 13 && time < 18) System.out.println("오후 수업 시간 입니다.");
		else System.out.println("자유 시간 입니다.");
		
	}
}
