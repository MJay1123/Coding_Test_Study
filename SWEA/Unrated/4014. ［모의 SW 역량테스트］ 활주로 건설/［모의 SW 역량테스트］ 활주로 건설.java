import java.util.*;
import java.io.*;

public class Solution {
	static int N, X;
	static int[][] map;
	static int[] change;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			change = new int[N - 1];
			visited = new boolean[N];
			int answer = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N - 1; c++) {
					change[c] = map[r][c + 1] - map[r][c];
				}
				if (check()) {
					answer++;
				}
			}
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N - 1; r++) {
					change[r] = map[r + 1][c] - map[r][c];
				}
				if (check()) {
					answer++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static boolean check() {
		Arrays.fill(visited, false);
		for (int i = 0; i < N - 1; i++) {
			if (change[i] == 0) {
				continue;
			} else if (change[i] == 1) {
				visited[i] = true;
				for (int d = 1; d < X; d++) {
					if (i - d < 0 || change[i - d] != 0 || visited[i - d]) {
						return false;
					}
					visited[i - d] = true;
				}
			} else if (change[i] == -1) {
				visited[i + 1] = true;
				for (int d = 1; d < X; d++) {
					if (i + d >= N - 1 || change[i + d] != 0 || visited[i + d + 1]) {
						return false;
					}
					visited[i + 1 + d] = true;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static void print(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			System.out.println(Arrays.toString(arr[r]));
		}
	}
}
