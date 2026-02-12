import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] around = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static int[][] rooms;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					rooms[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int startNumber = 0;
			int count = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					visited = new boolean[N][N];
					int temp = BFS(r, c, rooms);
					if(count < temp) {
						count = temp;
						startNumber = rooms[r][c];
					} else if(count == temp) {
						startNumber = Math.min(startNumber,  rooms[r][c]);
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(startNumber).append(" ").append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int BFS(int startR, int startC, int[][] rooms) {
		int result = 0;
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		distQueue.offer(1);
		visited[startR][startC] = true;
		while(!rQueue.isEmpty()){
			int r = rQueue.poll();
			int c = cQueue.poll();
			int dist = distQueue.poll();
			result = Math.max(result, dist);
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc] && rooms[nr][nc] == rooms[r][c] + 1) {
					visited[nr][nc] = true;
					rQueue.offer(nr);
					cQueue.offer(nc);
					distQueue.offer(dist + 1);
				}
			}
		}
		return result;
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
