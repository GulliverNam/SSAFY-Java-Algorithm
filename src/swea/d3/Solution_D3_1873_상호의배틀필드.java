package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	static int H, W, Tr, Tc;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static char tank[] = {'^','v','<','>'};
	static char map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_1873_상호의배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char [H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '<' || map[i][j] == '>' ||
					   map[i][j] == '^' || map[i][j] == 'v') {
						Tr = i;
						Tc = j;
					}
				}
			}
			br.readLine();
			for (char c : br.readLine().toCharArray()) {
				play(c);
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void play(char c) {
		switch(c) {
		case 'U':
			map[Tr][Tc] = '.';
			if(Tr-1 >-1 && map[Tr-1][Tc] == '.')
				Tr--;
			map[Tr][Tc] = '^';
			break;
		case 'D':
			map[Tr][Tc] = '.';
			if(Tr+1 < H && map[Tr+1][Tc] == '.')
				Tr++;
			map[Tr][Tc] = 'v';
			break;
		case 'L':
			map[Tr][Tc] = '.';
			if(Tc-1 > -1 && map[Tr][Tc-1] == '.')
				Tc--;
			map[Tr][Tc] = '<';
			break;
		case 'R':
			map[Tr][Tc] = '.';
			if(Tc+1 < W && map[Tr][Tc+1] == '.')
				Tc++;
			map[Tr][Tc] = '>';
			break;
		case 'S':
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				if(map[Tr][Tc] == tank[i]) {
					nr = Tr + dir[i][0];
					nc = Tc + dir[i][1];
					while(nr > -1 && nc > -1 && nr < H && nc < W) {
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
						if(map[nr][nc] == '#') break;
						nr += dir[i][0];
						nc += dir[i][1];
					}
					break;
				}
			}
		}
	}

}
