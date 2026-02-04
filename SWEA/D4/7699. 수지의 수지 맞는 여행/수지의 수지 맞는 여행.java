import java.util.*;
import java.io.*;

class Solution {
	static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	static int answer = 0;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			answer = 0;
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			for(int r=0; r<R; r++) {
				String str = br.readLine();
				for(int c=0; c<C; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			boolean[][] visited = new boolean[R][C];
			HashSet<Character> hs = new HashSet<>();
			DFS(0, 0, map, visited, hs);
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static boolean checkRange(int r, int c, char[][] map) {
		return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
	}
	public static void DFS(int r, int c, char[][] map, boolean[][] visited, HashSet<Character> hs) {
		visited[r][c] = true;
		hs.add(map[r][c]);
		answer = Math.max(answer,  hs.size());
		for(int i=0; i<4; i++) {
			int nr = r + move[i][0];
			int nc = c + move[i][1];
			if(checkRange(nr, nc, map) && !visited[nr][nc] && !hs.contains(map[nr][nc])){
				DFS(nr, nc, map, visited, hs);
			}
		}
		hs.remove(map[r][c]);
		visited[r][c] = false;
	}
}