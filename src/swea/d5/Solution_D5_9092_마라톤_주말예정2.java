package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_9092_마라톤_주말예정2{
	
	static int N, K, points[][], distance[][][], Answer;
	static PriorityQueue<Path> Queue;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_9092_마라톤.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim()), length;
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			points = new int[N][2];
			Answer = Integer.MAX_VALUE;
			distance = new int[N-1][][];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int idx, k = 0;
			for (int i = 0; i < N-1; i++) {
				length = i < N-1-K ? K+1 : K+1-(++k);
				distance[i] = new int[length][2];
				idx = 0;
				for (int j = i+1; j <= i+length; j++) {
					distance[i][idx][0] = j;
					distance[i][idx++][1] = getDistance(i, j);
				}
			}
			
			for (int i = 0; i < N-1; i++) {
				Arrays.sort(distance[i], new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
			            return Integer.compare(o1[1], o2[1]);
			        }
				});
//				for (int j = 0; j < distance[i].length; j++)
//					System.out.println(i+" "+distance[i][j][0]+" "+distance[i][j][1]);
			}
			
			findShortestPath();
			System.out.println("#"+testCase+" "+Answer);
			
			
		}
	}
	
	private static void findShortestPath() {
		Queue = new PriorityQueue<>();
		for (int i = 0; i < distance[0].length; i++) {
			Queue.add(new Path(0, distance[0][i][0], distance[0][i][0]-1, distance[0][i][1]));
		}
		Path p;
		int ni, nj, nk;
		while(!Queue.isEmpty()) {
			p = Queue.poll();
			ni = p.j;
			if(ni == N-1) {
				Answer = p.cost;
				return;
			}
			for (int index = 0; index < distance[ni].length; index++) {
				nj = distance[ni][index][0];
				nk = p.k + nj - ni - 1;
				if(nk <=K) {
					Queue.add(new Path(ni, nj, nk, p.cost + distance[ni][index][1]));
				}
			}
		}
	}

	private static int getDistance(int i, int j) {
		return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
	}
}

class Path implements Comparable<Path>{
	public int i, j, k, cost;
	
	public Path(int i, int j, int k, int cost) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Path o) {
		if(this.cost == o.cost) return this.i < o.i ? 1: -1;
		return this.cost > o.cost ? 1 : -1;
	}
}