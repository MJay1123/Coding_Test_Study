import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] cheese;
	static int cheeseCount = 0;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheese = new boolean[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					cheeseCount++;
					cheese[r][c] = true;
				}
			}
		}
		int day = 0;
		while(true) {
			day++;
			BFS();
			removeCheese();
			if(cheeseCount == 0) {
				break;
			}
		}
		bw.write(day + "\n");
		bw.flush();
	}
	public static void removeCheese() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] > 0) {
					if(map[r][c] >= 3) {
						map[r][c] = 0;
						cheeseCount--;
					} else {
						map[r][c] = 1;
					}
				} else {
					map[r][c] = 0;
				}
			}
		}
	}
	public static void BFS() {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(0);
		cQueue.offer(0);
		map[0][0] = -1;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc)) {
					if(map[nr][nc] > 0) {
						map[nr][nc]++;
					} else if(map[nr][nc] == 0) {
						map[nr][nc] = -1;
						rQueue.offer(nr);
						cQueue.offer(nc);
					}
				}
			}
		}
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
