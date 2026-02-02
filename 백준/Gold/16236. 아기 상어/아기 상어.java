import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] shark = new int[4]; // {r, c, size, eatFishCount}
		shark[2] = 2;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > 0) {
					if (map[r][c] == 9) {
						shark[0] = r;
						shark[1] = c;
						map[r][c] = 0;
					}
				}
			}
		}
		int answer = 0;
		while (true) {
			int m = BFS(map, shark);
			if (m == -1) {
				break;
			}
			answer += m;
		}
		bw.write(answer + "\n");
		bw.flush();
	}

	public static boolean checkRange(int r, int c, int[][] map) {
		return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
	}

	public static int BFS(int[][] map, int[] shark) {
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		int[][] move = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		int startR = shark[0];
		int startC = shark[1];
		rQueue.offer(startR);
		cQueue.offer(startC);
		distQueue.offer(0);
		visited[startR][startC] = true;
		while (!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int dist = distQueue.poll();
			if (map[r][c] > 0 && map[r][c] < shark[2]) {
				pq.offer(new Fish(r, c, map[r][c], dist));
			}
			for (int m = 0; m < 4; m++) {
				int nr = r + move[m][0];
				int nc = c + move[m][1];
				if (checkRange(nr, nc, map) && !visited[nr][nc] && map[nr][nc] <= shark[2]) {
					rQueue.offer(nr);
					cQueue.offer(nc);
					distQueue.offer(dist + 1);
					visited[nr][nc] = true;
				}
			}
		}

		if(pq.isEmpty()) {
			return -1;
		}
		Fish fish = pq.peek();
		shark[0] = fish.r;
		shark[1] = fish.c;
		map[fish.r][fish.c] = 0;
		shark[3]++;
		if(shark[3] == shark[2]) {
			shark[3] = 0;
			shark[2]++;
		}
		return fish.distance;
	}

	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int distance;

		public Fish(int r, int c, int size, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.distance != o.distance) {
				return this.distance - o.distance;
			}
			if (this.r != o.r) {
				return this.r - o.r;
			}
			return this.c - o.c;
		}
	}
}