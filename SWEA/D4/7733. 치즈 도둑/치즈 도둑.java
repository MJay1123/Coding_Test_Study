import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int[][] cheese;
	static boolean[][] eaten;
	static int[][] around = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					cheese[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 1;
			eaten = new boolean[N][N];
			for (int day = 1; day <= 100; day++) {
				eatCheese(day);
				int count = 0;
				boolean[][] visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!eaten[r][c] && !visited[r][c]) {
							BFS(r, c, visited);
							count++;
						}
					}
				}
				answer = Math.max(answer, count);
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void eatCheese(int day) {
		for (int r = 0; r < cheese.length; r++) {
			for (int c = 0; c < cheese[0].length; c++) {
				if (cheese[r][c] == day) {
					eaten[r][c] = true;
				}
			}
		}
	}

	public static void BFS(int startR, int startC, boolean[][] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startR * 100 + startC);
		visited[startR][startC] = true;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			int r = temp / 100;
			int c = temp % 100;
			for (int i = 0; i < 4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if (checkRange(nr, nc) && !eaten[nr][nc] && !visited[nr][nc]) {
					queue.offer(nr * 100 + nc);
					visited[nr][nc] = true;
				}
			}
		}
	}
}