import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static char[][] map;
	static int[][] numberMap;
	static boolean[][] visited;
	static int[][] around = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			numberMap = new int[N][N];
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c] == '*') {
						numberMap[r][c] = -1;
						for(int i=0; i<8; i++) {
							int nr = r + around[i][0];
							int nc = c + around[i][1];
							if(checkRange(nr, nc) && map[nr][nc] != '*') {
								numberMap[nr][nc]++;
							}
						}
					}
				}
			}
			int answer = 0;
			visited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(numberMap[r][c] == 0 && !visited[r][c]) {
						answer++;
						BFS(r, c);
					}
				}
			}
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c] && numberMap[r][c] != -1) {
						answer++;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	public static void BFS(int startR, int startC) {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		visited[startR][startC] = true;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<8; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc]) {
					if(numberMap[nr][nc] == 0) {
						rQueue.offer(nr);
						cQueue.offer(nc);
						visited[nr][nc] = true;
					} else if(numberMap[nr][nc] > 0) {
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
