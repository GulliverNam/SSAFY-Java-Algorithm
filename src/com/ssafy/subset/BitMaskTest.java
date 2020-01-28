package com.ssafy.subset;

public class BitMaskTest {

	public static void main(String[] args) {
		// byte, short 연산시 int 형으로 변환됨.
		byte a = 12;
		byte c = 15;
		// byte b = a & 0; -> 에러
		int b = a & 0;
		int d = a | c;
		System.out.printf("%4d 의  bit: %5s\n",a,Integer.toBinaryString(a));
		System.out.printf("%4d 의  bit: %5s\n",b,Integer.toBinaryString(b));
		System.out.printf("%4d 의  bit: %5s\n",c,Integer.toBinaryString(c));
		System.out.printf("%4d 의  bit: %5s\n",d,Integer.toBinaryString(d));
		
		/*
		 * 	>> n : 비트를 N번 오른쪽으로 이동 => 2의 n제곱으로 나눈 효과
		 * 	0000 1000	= 8
		 * 	0000 0010	= 8>>2 = 2 (8/4)
		 * 	<< n : 비트를 N번 왼쪽으로 이동 => 2의 n제곱으로 곱한 효과
		 * 	0000 1000	= 8
		 * 	0010 0000	= 8<<2 = 32 (8*4)
		 */
		int e = 8;
		System.out.println("8>>2: "+(8>>2));
		System.out.println("-8>>2: "+(-8>>2)); // 부호bit 유지
		System.out.println("8<<2: "+(8<<2));
		
		/*
		 * >>> n : 비트를 N번 오른쪽으로 이동 => 2의 n제곱으로 나눈 효과
		 * 부호 bit를 0으로 채운다. -> 음수일 때 큰 양수로 변환
		 */
		System.out.println("8>>>2: "+(8>>>2));
		System.out.println("-8>>>2: "+(-8>>>2));
		System.out.println("-8>>2: "+Integer.toBinaryString(-8>>2)+" 맨 왼쪽 두 자리에 1이 채워짐"); // 부호bit 유지
		System.out.println("-8>>>2: "+Integer.toBinaryString(-8>>>2)+" 맨 왼쪽 두 자리에 0이 채워짐");
		
		/*
		 * 숫자 i의 j번째 비트가 0인지 1인지 출력하기
		 * i & 1<<j
		 */
		for (int i = 0; i < 5; i++) {
			printBit(i);
		}
	}

	private static void printBit(int i) {
		for (int j = 7; j >= 0; j--)
			System.out.printf("%d", (i & 1<<j) != 0 ? 1:0);
		System.out.println();
	}

}
