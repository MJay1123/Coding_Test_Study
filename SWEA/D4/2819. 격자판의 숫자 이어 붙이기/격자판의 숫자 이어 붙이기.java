import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map = new int[4][4];
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			for(int r=0; r<4; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<4; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			hs.clear();
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					DFS(r, c, map[r][c], 1);
				}
			}
			int answer = hs.size();
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void DFS(int r, int c, int result, int depth) {
		if(depth == 7) {
			hs.add(result);
			return;
		}
		for(int i=0; i<4; i++) {
			int nr = r + around[i][0];
			int nc = c + around[i][1];
			if(!checkRange(nr, nc)) {
				continue;
			}
			DFS(nr, nc, result * 10 + map[nr][nc], depth+1);
		}
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}

}
