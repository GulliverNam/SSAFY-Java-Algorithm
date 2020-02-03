package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1249_보급로 {

	static int N, Map[][], Answer;
	static boolean Visited[][];
	static int Dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1249_보급로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		String str;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			Map = new int[N][N];
			Visited = new boolean[N][N];
			Answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				str = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					Map[i][j] = (int)(str.charAt(j) - 48);
				}
			}
			findPath();
			System.out.println("#"+testCase+" "+Answer);
		}
	}

	private static void findPath() {
		PriorityQueue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(0,0,Map[0][0]));
		Visited[0][0] = true;
		int nr, nc;
		while(!queue.isEmpty()) {
			Path p = queue.poll();
			Visited[p.r][p.c] = true;
			if(p.r == N-1 && p.c == N-1) {
				Answer = p.cost;
				break;
			}
			for (int i = 0; i < 4; i++) {
				nr = p.r + Dir[i][0];
				nc = p.c + Dir[i][1];
				if(nr > -1 && nc > -1 && nr < N && nc < N && !Visited[nr][nc]) {
					queue.add(new Path(nr,nc, p.cost+Map[nr][nc]));
				}
			}
		}
	}


}

class Path implements Comparable<Path>{
	public int r, c, cost;
	
	public Path() {}
	
	public Path(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Path o) {
		return this.cost >= o.cost ? 1 : -1;
	}
	
}