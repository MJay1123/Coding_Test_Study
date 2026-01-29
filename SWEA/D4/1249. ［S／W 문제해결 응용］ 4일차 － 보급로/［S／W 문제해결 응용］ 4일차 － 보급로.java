import java.util.*;
import java.io.*;

class Solution {
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int maxV = 0;
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c) - '0';
					maxV = Math.max(maxV, map[r][c]);
				}
			}
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				Arrays.fill(arr[r], maxV * N * 2);
			}
			arr[0][0] = 0;
			search(map, arr, 0, 0);
			int answer = arr[N - 1][N - 1];
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
	}

	public static boolean checkRange(int r, int c, int N) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void search(int[][] map, int[][] arr, int startR, int startC) {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for (int m = 0; m < 4; m++) {
				int nr = r + move[m][0];
				int nc = c + move[m][1];
				if (checkRange(nr, nc, map.length) && arr[nr][nc] > arr[r][c] + map[nr][nc]) {
					arr[nr][nc] = arr[r][c] + map[nr][nc];
					rQueue.offer(nr);
					cQueue.offer(nc);
				}
			}
		}
	}
}