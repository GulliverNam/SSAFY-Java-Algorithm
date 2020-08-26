package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281_야구 {
	
	static int N, players[][], answer;
	static boolean selected[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		players = new int[N][9];
		selected = new boolean[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		baseball(new int[9], 0);
		System.out.println(answer);
	}

	private static void baseball(int select[], int cnt) {
		if(cnt == 9) {
			play(select);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if(!selected[i]) {
				selected[i] = true;
				if(cnt == 3) {
					select[cnt+1] = i;
					baseball(select, cnt+2);
				}
				else {
					select[cnt] = i;
					baseball(select, cnt+1);
				}
				selected[i] = false;
			}
		}
		
	}

	private static void play(int[] select) {
		boolean base[] = new boolean [3];
		int ining = 0, seq = 0, out, score = 0;
		while(ining != N) {
			out = 0;
			Arrays.fill(base, false);
			while(out != 3) {
				switch(players[ining][select[seq]]) {
				case 0: out++; break;
				case 1: 
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1]) {
						base[1] = false;
						base[2] = true;
					}
					if(base[0])
						base[1] = true;
					base[0] = true;
					break;
				case 2:
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1])
						score++;
					if(base[0]) {
						base[0] = false;
						base[2] = true;
					}
					base[1] = true;
					break;
				case 3:
				case 4:
					for (int i = 2; i > -1; i--) {
						if(base[i]) {
							base[i] = false;
							score++;
						}
					}
					if(players[ining][select[seq]] == 3)
						base[2] = true;
					else
						score++;
					break;
				}
				seq = (seq + 1) % 9;
			}
			ining++;
		}
		answer = Math.max(answer, score);
	}

}
