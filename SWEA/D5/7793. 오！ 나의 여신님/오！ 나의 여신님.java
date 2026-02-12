import java.util.*;
import java.io.*;

class Solution {
	static int N, M;
	static class Location {
		String name;
		int r, c;
		public Location(String name, int r, int c) {
			this.name = name;
			this.r = r;
			this.c = c;
		}
	}
	static Location sooyeon, god;
	static List<Location> devils = new ArrayList<>();
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			devils.clear();
			char[][] map = new char[N][M];
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<M; c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c] == 'S') {
						sooyeon = new Location("Sooyeon", r, c);
					}
					if(map[r][c] == 'D') {
						god = new Location("God", r, c);
					}
					if(map[r][c] == '*') {
						devils.add(new Location("Devil" + (devils.size() + 1), r, c));
					}
				}
			}
			int[][] arr = new int[N][M];
			devilBFS(map, arr);
			sooyeonBFS(map, arr);
			sb.append("#").append(test_case).append(" ");
			if(arr[god.r][god.c] == 0) {
				sb.append("GAME OVER");
			} else {
				sb.append(arr[god.r][god.c]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	public static void sooyeonBFS(char[][] map, int[][] arr) {
		boolean[][] visited = new boolean[N][M];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();	
		rQueue.offer(sooyeon.r);
		cQueue.offer(sooyeon.c);
		distQueue.offer(0);
		visited[sooyeon.r][sooyeon.c] = true;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int dist = distQueue.poll();
			if(map[r][c] == 'D') {
				return;
			}
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
					if(arr[nr][nc] == 0 || arr[nr][nc] + dist + 1 < 0) {
						arr[nr][nc] = dist + 1;
						visited[nr][nc] = true;
						rQueue.offer(nr);
						cQueue.offer(nc);
						distQueue.offer(dist + 1);
					}
				}
			}
		}
	}
	public static void devilBFS(char[][] map, int[][] arr) {
		boolean[][] visited = new boolean[N][M];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();	
		for(Location devil : devils) {
			rQueue.offer(devil.r);
			cQueue.offer(devil.c);
			distQueue.offer(0);
			visited[devil.r][devil.c] = true; 
		}
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int dist = distQueue.poll();
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
					arr[nr][nc] = dist - 1;
					visited[nr][nc] = true;
					rQueue.offer(nr);
					cQueue.offer(nc);
					distQueue.offer(dist - 1);
				}
			}
		}
	}
}