import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			List<int[]> waterList = new ArrayList<>();
			List<int[]> landList = new ArrayList<>();
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<M; c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c] == 'W') {
						waterList.add(new int[] {r, c});
					} else {
						landList.add(new int[] {r, c});
					}
				}
			}
			int[][] distance = new int[N][M];
			int INF = N * M;
			for(int r=0; r<N; r++) {
				Arrays.fill(distance[r], INF);
			}
			BFS(map, distance, waterList);
            int answer = 0;
            for(int[] l : landList) {
            	answer += distance[l[0]][l[1]];
            }
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static boolean checkRange(int r, int c, char[][] map) {
		return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
	}
	public static void BFS(char[][] map, int[][] distance, List<int[]> waterList) {
		int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
		Queue<Integer> rQueue = new ArrayDeque<>();
		Queue<Integer> cQueue = new ArrayDeque<>();
		for(int[] w : waterList) {
			int r = w[0];
			int c = w[1];
			distance[r][c] = 0;
			boolean temp = false;
			for(int m=0; m<4; m++) {
				int nr = r + move[m][0];
				int nc = c + move[m][1];
				if(checkRange(nr, nc, map) && map[nr][nc] == 'L') {
					temp = true;
					break;
				}
			}
			if(temp) {
				rQueue.offer(r);
				cQueue.offer(c);
			}
		}
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int m=0; m<4; m++) {
				int nr = r + move[m][0];
				int nc = c + move[m][1];
				if(checkRange(nr, nc, map)){
					if(distance[nr][nc] != 0 && distance[nr][nc] > distance[r][c] + 1) {
						distance[nr][nc] = distance[r][c] + 1;
						rQueue.offer(nr);
						cQueue.offer(nc);
					}
				}
			}
		}
	}
}