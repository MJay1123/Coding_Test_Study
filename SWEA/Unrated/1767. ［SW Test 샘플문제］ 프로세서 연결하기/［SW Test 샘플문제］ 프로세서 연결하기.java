import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int coreCount, lineCount;
	static int maxCore, minLine;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			List<int[]> coreList = new ArrayList<>();
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1 && r != 0 && c != 0 && r != N-1 && c != N-1) {
						coreList.add(new int[] {r, c});
					}
				}
			}
			coreCount = 0;
			lineCount = 0;
			maxCore = 0;
			minLine = 200;
			DFS(coreList, 0, map);
            int answer = minLine;
            sb.append(answer).append("\n");
           
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static void DFS(List<int[]> coreList, int coreIndex, int[][] map) {
		if(coreIndex == coreList.size()) {
			if(maxCore < coreCount) {
				maxCore = coreCount;
				minLine = lineCount;
			} else if(maxCore == coreCount) {
				minLine = Math.min(minLine,  lineCount);	
			}
			return;
		}
		int[] core = coreList.get(coreIndex);
		int r = core[0];
		int c = core[1];
		for(int m=0; m<4; m++) {
			boolean possible = true;
			for(int d=1; d<N; d++) {
				int nr = r + d * move[m][0];
				int nc = c + d * move[m][1];
				if(!checkRange(nr, nc)) {
					break;
				}
				if(map[nr][nc] != 0) {
					possible = false;
					break;
				}
			}
			if(possible) {
				for(int d=1; d<N; d++) {
					int nr = r + d * move[m][0];
					int nc = c + d * move[m][1];
					if(checkRange(nr, nc)) {
						map[nr][nc] = 2;	// 전선 연결
						lineCount++;
					}
				}
				coreCount++;
				DFS(coreList, coreIndex+1, map);
				for(int d=1; d<N; d++) {
					int nr = r + d * move[m][0];
					int nc = c + d * move[m][1];
					if(checkRange(nr, nc)) {
						map[nr][nc] = 0;	// 전선 연결 해제
						lineCount--;
					}
				}
				coreCount--;
			}
		}
		DFS(coreList, coreIndex+1, map);
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	public static void print(int[][] map) {
		System.out.println();
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println();
	}
}