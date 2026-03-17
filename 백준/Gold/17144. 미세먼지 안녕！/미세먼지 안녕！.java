import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;
	static int[][] map;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	static Integer[] airCleaner = new Integer[2];
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] != -1;
	}
	static class Dust {
		int r;
		int c;
		int amount;
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					if(airCleaner[0] == null) {
						airCleaner[0] = r;
					} else {
						airCleaner[1] = r;
					}
				}
			}
		}
		for(int t=0; t<T; t++) {
			spread();
			cleanAir();
		}
		int answer = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] >= 0) {
					answer += map[r][c];
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}

	public static void cleanAir() {
		int r1 = Math.min(airCleaner[0], airCleaner[1]);
		for(int r=r1 - 1; r>0; r--) {
			map[r][0] = map[r-1][0];
		}
		for(int c=0; c<C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for(int r=0; r<r1; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		for(int c=C-1; c>1; c--) {
			map[r1][c] = map[r1][c-1];
		}
		map[r1][1] = 0;
		int r2 = Math.max(airCleaner[0], airCleaner[1]);
		for(int r=r2+1; r<R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		for(int c=0; c<C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		for(int r=R-1; r>r2; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		for(int c=C-1; c>1; c--) {
			map[r2][c] = map[r2][c-1];
		}
		map[r2][1] = 0;
	}
	public static void spread() {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> dQueue = new LinkedList<>();
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] > 0) {
					int temp = map[r][c] / 5;
					for(int i=0; i<4; i++) {
						int nr = r + around[i][0];
						int nc = c + around[i][1];
						if(checkRange(nr, nc)) {
							rQueue.offer(nr);
							cQueue.offer(nc);
							dQueue.offer(temp);
							map[r][c] -= temp;
						}
					}
				}
			}
		}
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int d = dQueue.poll();
			map[r][c] += d;
		}
	}
}
