import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] connectedTo = {{}, {0,1,2,3},{0,2},{1,3},{1,2},{0,1},{0,3},{2,3}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = BFS(R, C);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	public static int BFS(int startR, int startC){
		int count = 0;
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> timeQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		timeQueue.offer(1);
		visited[startR][startC] = true;
		count++;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int time = timeQueue.poll();
			if(time < L) {
				for(int i : connectedTo[map[r][c]]) {
					int nr = r + around[i][0];
					int nc = c + around[i][1];
					if(checkRange(nr, nc) && contains(connectedTo[map[nr][nc]], (i+2)%4) && !visited[nr][nc]) {
						rQueue.offer(nr);
						cQueue.offer(nc);
						timeQueue.offer(time+1);
						visited[nr][nc] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
	public static boolean contains(int[] arr, int num) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}
