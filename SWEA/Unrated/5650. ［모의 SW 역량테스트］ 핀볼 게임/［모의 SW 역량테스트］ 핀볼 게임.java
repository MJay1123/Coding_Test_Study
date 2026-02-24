import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static Integer[][][] memo;
	static int answer;
	static int[][] wormHoles;

	static class Pinball {
		int r;
		int c;
		int direction;
		int score;

		public Pinball(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
			this.score = 0;
		}

		public void move() {
			r += directions[direction][0];
			c += directions[direction][1];
			if (map[r][c] > 5) { // 웜홀을 만난 경우(위치 이동)
				int num = map[r][c] - 6;
				if (r == wormHoles[num][0] && c == wormHoles[num][1]) {
					r = wormHoles[num][2];
					c = wormHoles[num][3];
				} else {
					r = wormHoles[num][0];
					c = wormHoles[num][1];
				}
			} else if (map[r][c] > 0) { // 블록을 만난 경우(방향 변경)
				direction = changedDirections[direction][map[r][c]];
				score++;
			}
		}

		@Override
		public String toString() {
			return "Pinball [r=" + r + ", c=" + c + ", direction=" + direction + ", score=" + score + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			wormHoles = new int[5][4];
			for (int r = 0; r <= N + 1; r++) {
				Arrays.fill(map[r], 5);
			}
			for (int r = 1; r <= N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int c = 1; c <= N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] > 5) {
						int num = map[r][c] - 6;
						if (wormHoles[num][0] == 0 && wormHoles[num][1] == 0) {
							wormHoles[num][0] = r;
							wormHoles[num][1] = c;
						} else {
							wormHoles[num][2] = r;
							wormHoles[num][3] = c;
						}
					}
				}
			}
			answer = 0;
			memo = new Integer[N + 2][N + 2][4];
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (map[r][c] == 0) {
//						BFS(r, c);
						answer = Math.max(answer,  DFS(r, c));
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int DFS(int startR, int startC) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (memo[startR][startC][i] == null) {
				Pinball pb = new Pinball(startR, startC, i);
				while (true) {
					pb.move();
					if (map[pb.r][pb.c] == -1 || (pb.r == startR && pb.c == startC)) {
						break;
					}
				}
				result = Math.max(result, pb.score);
			}
		}
		return result;
	}

	public static void BFS(int startR, int startC) {
		Queue<Pinball> queue = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			if (memo[startR][startC][i] == null) {
				queue.offer(new Pinball(startR, startC, i));
				memo[startR][startC][i] = 0;
			}
		}
		while (!queue.isEmpty()) {
			Pinball pb = queue.poll();
			pb.move();
			int r = pb.r;
			int c = pb.c;
			int dir = pb.direction;
			if (map[r][c] == -1 || (r == startR && c == startC)) {
				answer = Math.max(answer, pb.score);
			} else {
				if (memo[r][c][dir] == null || memo[r][c][dir] < pb.score) {
					queue.offer(pb);
					memo[r][c][dir] = pb.score;
				}
			}
		}
	}

	static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] changedDirections = {
			// [directionIndex, blockIndex]
			{ 0, 1, 2, 2, 3, 2 }, { 1, 3, 3, 0, 2, 3 }, { 2, 0, 1, 3, 0, 0 }, { 3, 2, 0, 1, 1, 1 } };

	public static void print(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			System.out.println(Arrays.toString(arr[r]));
		}
	}

	public static void print(Integer[][][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				for (int d = 0; d < arr[r][c].length; d++) {
					System.out.print(arr[r][c][d]);
				}
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}