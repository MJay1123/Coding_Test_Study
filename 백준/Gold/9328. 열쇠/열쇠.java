// 열쇠
import java.util.*;
import java.io.*;

public class Main {
	static int h, w;
	static char[][] map;
	static boolean[] keys;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			for(int r=0; r<=h+1; r++) {
				if(r == 0 || r == h+1) {
					for(int c=0; c<=w+1; c++) {
						map[r][c] = '.';
					}
				} else {
					map[r][0] = '.';
					map[r][w+1] = '.';
					String temp = br.readLine();
					for(int c=1; c<=w; c++) {
						map[r][c] = temp.charAt(c-1);
					}
				}
			}
			keys = new boolean[26];
			String temp = br.readLine();
			if(!temp.equals("0")) {
				for(int i=0; i<temp.length(); i++) {
					keys[temp.charAt(i) - 'a'] = true;
				}
			}
			answer = 0;
			while(true) {
				boolean result = BFS(0, 0);
				if(!result) {
					break;
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r <= h+1 && c >= 0 && c <= w+1;
	}
	public static boolean BFS(int startR, int startC) {
		boolean result = false;
		boolean[][] visited = new boolean[h+2][w+2];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		visited[0][0] = true;
		rQueue.offer(0);
		cQueue.offer(0);
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc]) {
					if(map[nr][nc] == '.') {
						visited[nr][nc] = true;
						rQueue.offer(nr);
						cQueue.offer(nc);
					} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
						keys[map[nr][nc] - 'a'] = true;
						map[nr][nc] = '.';
						visited[nr][nc] = true;
						rQueue.offer(nr);
						cQueue.offer(nc);
						result = true;
					} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
						if(keys[map[nr][nc] - 'A']) {
							map[nr][nc] = '.';
							visited[nr][nc] = true;
							rQueue.offer(nr);
							cQueue.offer(nc);							
						}						
					} else if(map[nr][nc] == '$') {
						map[nr][nc] = '.';
						visited[nr][nc] = true;
						rQueue.offer(nr);
						cQueue.offer(nc);
						answer++;
					}
				}
			}
		}
		return result;
	}
}
