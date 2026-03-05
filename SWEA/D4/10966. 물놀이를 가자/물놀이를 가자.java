import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static char[][] map;
	static int[][] countMap;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for(int r=0; r<N; r++) {
				String temp = br.readLine();
				for(int c=0; c<M; c++) {
					map[r][c] = temp.charAt(c); 
				}
			}
			int answer = BFS();
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int BFS() {
		int count = 0;
		countMap = new int[N][M];
		for(int r=0; r<N; r++) {
			Arrays.fill(countMap[r], -1);
		}
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 'W') {
					rQueue.offer(r);
					cQueue.offer(c);
					countMap[r][c] = 0;
				}
			}
		}
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && countMap[nr][nc] == -1) {
					rQueue.offer(nr);
					cQueue.offer(nc);
					countMap[nr][nc] = countMap[r][c] + 1;
					count += countMap[nr][nc];
				}
			}
		}
		return count;
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
