package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_7988_내전경기 {
	
	static ArrayList<String> players = new ArrayList<>(); 
	static boolean[] selected, teams[], synergy[];
	static int length;
	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int K;
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine().trim());
			synergy = new boolean[K*2][K*2];
			players.clear();
			answer = "Yes";
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(!players.contains(str1))
					players.add(str1);
				if(!players.contains(str2))
					players.add(str2);
				synergy[players.indexOf(str1)][players.indexOf(str2)] = true;
				synergy[players.indexOf(str2)][players.indexOf(str1)] = true;
			}
			length = players.size();
			selected = new boolean[length];
			teams = new boolean[2][length];
			teaming(0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static void teaming(int now, int cnt) {
		selected[now] = true;
		teams[cnt][now] = true;
		for (int i = 0; i < length; i++) {
			if(synergy[now][i]) {
				if(teams[cnt][i]) {
					answer="No";
					return;
				}
				else if(!selected[i]) {
					teaming(i, (cnt+1) % 2);
				}
			}
		}
	}

}
