import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, K;
	static Cell[][] map;
	static int[][] around = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Queue<Integer> nonActivatedQueue = new LinkedList<>();
	static Queue<Integer> activatedQueue = new LinkedList<>();

	static class Cell {
		int r;
		int c;
		int time;
		int life;
		int activated; // 비활성 : 0, 활성 : 1, 죽은 : 2

		public Cell(int r, int c, int life) {
			this.r = r;
			this.c = c;
			this.time = 0;
			this.life = life;
			this.activated = 0;
			nonActivatedQueue.offer(r * 1000 + c);
		}

		public void pass() {
			if (activated == 2) {
				return;
			}
			time++;
			if (time == 1 && activated == 1) {
				for (int i = 0; i < 4; i++) {
					int nr = r + around[i][0];
					int nc = c + around[i][1];
					if (map[nr][nc] == null) {
						map[nr][nc] = new Cell(nr, nc, life);
					} else if (map[nr][nc].activated == 0 && map[nr][nc].time == 0 && map[nr][nc].life < this.life) {
						map[nr][nc].life = this.life;
					}
				}
			}
			if (time == life) {
				time = 0;
				activated++;
			}
			if (activated == 0) {
				nonActivatedQueue.offer(r * 1000 + c);
			} else if (activated == 1) {
				activatedQueue.offer(r * 1000 + c);
			}
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", time=" + time + ", life=" + life + ", activated=" + activated + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Cell[N + 400][M + 400]; // 여유있게 양옆으로 200씩 추가
			nonActivatedQueue.clear();
			activatedQueue.clear();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						map[r + 200][c + 200] = new Cell(r + 200, c + 200, life);
					}
				}
			}
			int time = 0;
			while (time < K) {
				time++;
				int nSize = nonActivatedQueue.size();
				int aSize = activatedQueue.size();
				for (int i = 0; i < nSize; i++) {
					int loc = nonActivatedQueue.poll();
					int r = loc / 1000;
					int c = loc % 1000;
					map[r][c].pass();
				}
				for (int i = 0; i < aSize; i++) {
					int loc = activatedQueue.poll();
					int r = loc / 1000;
					int c = loc % 1000;
					map[r][c].pass();
				}
			}
			int answer = nonActivatedQueue.size() + activatedQueue.size();
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
