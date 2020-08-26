package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_9760_PokerGame {
	
	static int[] suit, rank;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		top:
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			suit = new int[4];
			rank = new int[14];
			boolean isRoyal = false;
			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				switch(str.charAt(0)) {
					case 'S': suit[0]++; break;
					case 'D': suit[1]++; break;
					case 'H': suit[2]++; break;
					case 'C': suit[3]++; break;
				}
				switch(str.charAt(1)) {
					case 'A': rank[0]++; isRoyal = true; break;
					case 'T': rank[10]++; isRoyal = true; break;
					case 'J': rank[11]++; isRoyal = true; break;
					case 'Q': rank[12]++; isRoyal = true; break;
					case 'K': rank[13]++; isRoyal = true; break;
					default: rank[str.charAt(1) - '0']++; break;
				}
			}
			int maxSuit = 0;
			int maxRank = 0;
			for (int s : suit) maxSuit = Math.max(maxSuit, s);
			for (int r : rank) maxRank = Math.max(maxRank, r);
			
			for (int i = 0; i < 14; i++) {
				if(rank[i] != 0 && isSequential(i)) {
					if(maxSuit == 5)
						bw.write("#"+tc+" Straight Flush\n");
					else
						bw.write("#"+tc+" Straight\n");
					continue top;
				}
			}
			if(maxSuit == 5)
				bw.write("#"+tc+" Flush\n");
			else if(maxRank == 5) {
				if(isRoyal)
					bw.write("#"+tc+" Straight Flush\n");
			}else if(maxRank == 4){
				bw.write("#"+tc+" Four of a Kind\n");
			}else if(maxRank == 3) {
				for (int i = 0; i < 14; i++) {
					if(rank[i] == 2) {
						bw.write("#"+tc+" Full House\n");
						continue top;
					}
				}
				bw.write("#"+tc+" Three of a kind\n");
			}else if(maxRank == 2) {
				int num = 0;
				for (int i = 0; i < 14; i++) {
					if(rank[i] == 2) {
						num++;
					}
					if(num == 2) {
						bw.write("#"+tc+" Two pair\n");
						continue top;
					}
				}
				bw.write("#"+tc+" One pair\n");
			}else {
				bw.write("#"+tc+" High card\n");
			}
		}
		bw.flush();
		bw.close();
	}

	private static boolean isSequential(int start) {
		for (int i = start; i < start+5; i++) {
			if(rank[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
