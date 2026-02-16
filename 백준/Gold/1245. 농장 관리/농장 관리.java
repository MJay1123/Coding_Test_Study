import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] farm;
	static int[][] around = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	static boolean[][] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		farm = new int[N][M];
		checked = new boolean[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				farm[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(!checked[r][c]) {
					if(BFS(r, c)) {
						answer++;
					}
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
	public static boolean BFS(int startR, int startC) {
		boolean[][] visited = new boolean[N][M];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		visited[startR][startC] = true;
		checked[startR][startC] = true;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<8; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(checkRange(nr, nc) && !visited[nr][nc]) {
					if(farm[nr][nc] == farm[startR][startC]) {
						rQueue.offer(nr);
						cQueue.offer(nc);
						visited[nr][nc] = true;
						checked[nr][nc] = true;
					} else if(farm[nr][nc] < farm[startR][startC]) {
						visited[nr][nc] = true;
					} else {
//						System.out.println("false! : " + startR + ", " + startC);
						return false;
					}
				}
			}
		}
//		System.out.println("true! : " + startR + ", " + startC);
		return true;
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
