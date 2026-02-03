import java.io.*;
import java.util.*;

public class Solution {
	static int[][] around = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			int[][] counts = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '*') {
						counts[r][c] = -1;
					} else {
						int count = 0;
						for (int m = 0; m < 8; m++) {
							int nr = r + around[m][0];
							int nc = c + around[m][1];
							if (checkRange(nr, nc, N) && map[nr][nc] == '*') {
								count++;
							}
						}
						counts[r][c] = count;
					}
				}
			}
			int answer = 0;
			boolean[][] visited = new boolean[N][N];
			for(int r=0; r<N; r++){
				for(int c=0; c<N; c++) {
					if(counts[r][c] == 0 && !visited[r][c]) {
						answer++;
						BFS(r, c, counts, visited);
					}
				}
			}
			for(int r=0; r<N; r++){
				for(int c=0; c<N; c++) {
					if(counts[r][c] > 0 && !visited[r][c]) {
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static boolean checkRange(int r, int c, int N) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void BFS(int startR, int startC, int[][] counts, boolean[][] visited) {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		visited[startR][startC] = true;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int m=0; m<8; m++) {
				int nr = r + around[m][0];
				int nc = c + around[m][1];
				if(checkRange(nr, nc, visited.length) && counts[nr][nc] >= 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(counts[nr][nc] == 0) {
						rQueue.offer(nr);
						cQueue.offer(nc);
					}
				}
			}
		}
	}
}