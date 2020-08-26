package programmers;

import java.util.*;

public class Solution_소수찾기 {
	
	static int N, length;
    static Set<Integer> set = new HashSet<>();
    
	public static void main(String[] args) {
		String numbers = "17";
		length = numbers.length();
		for (int i = 0; i < length; i++) {
			N = i+1;
			subset(0, 0, new StringBuilder(), numbers);
		}
		System.out.println(set.size());

	}

	private static void subset(int idx, int visited, StringBuilder sb, String numbers) {
		if(idx == N){
			int result = Integer.parseInt(sb.toString());
			if(set.contains(result)) return;
			if(result > 1) {
				if(result == 2) {
					set.add(result);
					return;
				}
				for (int i = 2; i <= result/2; i++) {
					if(result % 2 == 0)
						return;
				}
				set.add(result);
			}
            return;
        }
        for(int i = 0; i < length; i++){
            if((visited & 1 << i) == 0){
            	sb.append(numbers.charAt(i));
                subset(idx+1, visited | 1 << i, sb, numbers);
                sb.deleteCharAt(sb.length()-1);
            }
        }
		
	}

}
