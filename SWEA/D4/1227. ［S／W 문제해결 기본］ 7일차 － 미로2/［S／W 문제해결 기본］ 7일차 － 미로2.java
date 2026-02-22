import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static int startR, startC, endR, endC;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=10; testCase++) {
			br.readLine();
			map = new int[100][100];
			for(int r=0; r<100; r++) {
				String str = br.readLine();
				for(int c=0; c<100; c++) {
					map[r][c] = str.charAt(c) - '0';
					if(map[r][c] == 2) {
						startR = r;
						startC = c;
					}
					if(map[r][c] == 3) {
						endR = r;
						endC = c;
					}
				}
			}
		 	int answer = BFS();
		 	sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}
	public static int BFS() {
		boolean[][] visited = new boolean[100][100];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		visited[startR][startC] = true;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			if(r == endR && c == endC) {
				break;
			}
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
					rQueue.offer(nr);
					cQueue.offer(nc);
					visited[nr][nc] = true;
				}
			}
		}
		if(visited[endR][endC]) {
			return 1;
		} else {
			return 0;
		}
	}
}