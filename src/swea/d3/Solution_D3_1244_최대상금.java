package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int n, length;
		char nums[];
		Character sortedNums[];
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			nums = st.nextToken().toCharArray();
			length = nums.length;
			sortedNums = new Character[length];
			for (int i = 0; i < length; i++)
				sortedNums[i] = nums[i];
			n = Integer.parseInt(st.nextToken());
			Arrays.sort(sortedNums, new Comparator<Character>(){
				@Override
				public int compare(Character a, Character b) {
					return a<b ? 1:-1;
				}
			});
			
			int index = -1, targetIndex;
			char temp;
			boolean complete;
			while(n-->0) {
				index = (index + 1) % length;
				targetIndex = -1;
				complete = true;
				for (int i = index; i < length; i++) {
					if(sortedNums[index] == nums[i]) {
						if(sortedNums[i] != nums[i]) {
							targetIndex = i;
							break;
						}
					}
					if(sortedNums[i] != nums[i]) {
						complete = false;
					}
				}
				if(complete) break;
				if(targetIndex == -1) {
					n++;
					continue;
				}
				temp = nums[index];
				nums[index] = nums[targetIndex];
				nums[targetIndex] = temp;
			}
			
			boolean ones[] = new boolean[10];
			int dup = -1;
			if(n != -1) {
				for (int i = 0; i < length; i++) {
					if(!ones[nums[i] - 48]) ones[nums[i]- 48] =true;
					else{
						dup = nums[i] - 48;
						break;
					}
				}
				
				char tmp;
				if(dup == -1) {
					if(n % 2 == 0) {
						tmp = nums[length-2];
						nums[length-2] = nums[length-1];
						nums[length-1] = tmp;
					}
				}
			}
			System.out.print("#"+testCase+" ");
			System.out.println(nums);
			
		}

	}

}
