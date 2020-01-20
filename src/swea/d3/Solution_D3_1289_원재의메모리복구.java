package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1289_원재의메모리복구.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T;test_case++) {
			String data = sc.next();
			int size = data.length();
			StringBuilder nData = new StringBuilder(data);
			
			int cnt = 1;
			//첫 1을 찾기
			int idx = data.indexOf("1");
			for(int i = idx; i< size;) {
				change(nData, i, size, ""+(cnt%2));
				//변경후 원본 문자열과 같은지 비교
				if(data.equals(nData.toString())) {
					//원본과 같아 비교 중지
					break;
				}
				//원본과 다르므로 다른 첫 위치를 찾기
				for (int j = i+1; j < size; j++) {
					//charAt(idx) 인덱스 위치의 문자 하나를 추출
					if(data.charAt(j) != nData.charAt(j)) {
						i=j;
						break;
					}
				}
				cnt++;
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	/**
	 * start 위치부터 end까지 fill 문자로 nData를 채워주는 함수
	 * @param nData		문자열을 채울 대상
	 * @param start		문자열을 채울 시작 위치
	 * @param end		문자열을 채울 끝 위치
	 * @param fill		채울 문자
	 */
	private static void change(StringBuilder nData, int start, int end, String fill) {
		for (int i = start; i < end; i++) {
			nData.replace(i, i+1, fill);
		}
	}

}
