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
			int maxCount = 0;
			visited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c]) {
						int[] result = BFS(r, c);
						if(maxCount < result[1]) {
							maxCount = result[1];
							startNumber = result[0];
						} else if(maxCount == result[1]) {
							startNumber = Math.min(startNumber, result[0]);
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(startNumber).append(" ").append(maxCount).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int[] BFS(int startR, int startC) {
		int minimumNum = N * N;
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		count++;
		while(!queue.isEmpty()){
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];
			minimumNum = Math.min(minimumNum, rooms[r][c]);
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc] && (rooms[nr][nc] == rooms[r][c] + 1 || rooms[nr][nc] == rooms[r][c] - 1)) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
					count++;
				}
			}
		}
		int[] result = new int[] {minimumNum, count};
		return result;
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
