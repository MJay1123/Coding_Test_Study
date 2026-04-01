import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] directionMap;
	static int[][] groupMap;
	static int[][] around = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U, D, L, R
	static HashMap<Character, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hm.put('U', 0);
		hm.put('D', 1);
		hm.put('L', 2);
		hm.put('R', 3);		
		directionMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				directionMap[r][c] = hm.get(str.charAt(c));
			}
		}
		groupMap = new int[N][M];
		int groupCount = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(groupMap[r][c] == 0) {
					BFS(r, c, groupCount++);
				}
			}
		}
		bw.write(groupCount - 1 + "\n");
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	public static void BFS(int startR, int startC, int groupNum) {
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		groupMap[startR][startC] = groupNum;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			for(int i=0; i<4; i++) {
				int nr = r + around[i][0];
				int nc = c + around[i][1];
				if(!checkRange(nr, nc)) {
					continue;
				}
				if(groupMap[nr][nc] != 0) {
					continue;
				}
				if(i == directionMap[r][c]) {
					rQueue.offer(nr);
					cQueue.offer(nc);
					groupMap[nr][nc] = groupNum;
				} else if(i + directionMap[nr][nc] == 1 || i + directionMap[nr][nc] == 5) {
					rQueue.offer(nr);
					cQueue.offer(nc);
					groupMap[nr][nc] = groupNum;
				}
			}
		}
	}
}