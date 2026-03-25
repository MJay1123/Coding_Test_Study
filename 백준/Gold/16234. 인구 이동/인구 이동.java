import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R;
	static int[][] map;
	static int[] parent;
	static List<Integer> list = new ArrayList<>();
	static int sum;
	static boolean[][] visited;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while(true) {
			boolean moved = false;
			visited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c]) {
						if(BFS(r, c)) {
							moved = true;
							movePeople();
						}
					}
				}
			}
			if(moved) {
				day++;
			} else {
				break;
			}
		}
		bw.write(day + "\n");
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	public static boolean BFS(int startR, int startC) {
		list.clear();
		sum = 0;
		boolean willMove = false;
		Queue<Integer> queue = new LinkedList<>();
		visited[startR][startC] = true;
		queue.offer(startR * 100 + startC);
		while(!queue.isEmpty()) {
			int value = queue.poll();
			list.add(value);
			int r = value / 100;
			int c = value % 100;
			sum += map[r][c];
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc]) {
					int difference = Math.abs(map[nr][nc] - map[r][c]);
					if(difference >= L && difference <= R) {
						visited[nr][nc] = true;
						queue.offer(nr * 100 + nc);
						if(map[r][c] != map[nr][nc]) {
							willMove = true;
						}
					}
				}
			}
		}
		return willMove;
	}
	public static void movePeople() {
		int people = sum / list.size();
		for(int i : list) {
			int r = i / 100;
			int c = i % 100;
			map[r][c] = people;
		}
	}
}
