import java.util.*;
import java.io.*;

public class Solution {
	static int N, W, H;
	static int[][] arr;
	static int[][] map;
	static int[] counts;
	static int[][] around = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 1 ~ 4
			W = Integer.parseInt(st.nextToken());	// 2 ~ 12
			H = Integer.parseInt(st.nextToken());	// 2 ~ 15
			/*
			 * 순열? 조합? 순서에 따라 바뀔수도있을거같다.
			 * 벽돌을 떨어뜨리는 경우의 수 : 12 * 12 * 12 * 12 = 22500 정도?
			 * 벽돌깨기 BFS : W*H = 180 정도
			 * 
			 * */
			arr = new int[H][W];
		 	for(int r=0; r<H; r++) {
		 		st = new StringTokenizer(br.readLine());
		 		for(int c=0; c<W; c++) {
		 			arr[r][c] = Integer.parseInt(st.nextToken());
		 		}
		 	}
		 	List<Integer> list = new ArrayList<>();
		 	answer = 10000;
		 	dropBrick(list);
		 	sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void init() {
		counts = new int[W];
		map = new int[H][W];
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				map[r][c] = arr[r][c];
				if(map[r][c] > 0) {
					counts[c]++;
				}
			}
		}
	}
	public static void dropBrick(List<Integer> list) {
		if(list.size() == N) {
			init();
			for(int i : list) {
				breakBlocks(i);
			}
			int sum = 0;
			for(int i=0; i<W; i++) {
				sum += counts[i];
			}
			answer = Math.min(answer,  sum);
			return;
		}
		for(int i=0; i<W; i++) {
			list.add(i);
			dropBrick(list);
			list.remove(list.size()-1);
		}
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
	public static void breakBlocks(int startC) {
		if(counts[startC] == 0) {
			return;
		}
		int startR = H - counts[startC];
		Queue<Integer> rQueue = new LinkedList<>();
		Queue<Integer> cQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		rQueue.offer(startR);
		cQueue.offer(startC);
		distQueue.offer(map[startR][startC]);
		map[startR][startC] = 0;
		counts[startC]--;
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			int dist = distQueue.poll();
			for(int i=0; i<4; i++) {
				for(int d=1; d<dist; d++) {
					int nr = r + around[i][0] * d;
					int nc = c + around[i][1] * d;
					if(checkRange(nr, nc) && map[nr][nc] != 0) {
						rQueue.offer(nr);
						cQueue.offer(nc);
						distQueue.offer(map[nr][nc]);
						map[nr][nc] = 0;
						counts[nc]--;
					}
				}
			}
		}
		refreshMap();
	}
	public static void refreshMap() {
		Queue<Integer> queue = new LinkedList<>();
		for(int c=0; c<W; c++) {
			queue.clear();
			for(int r=H-1; r>=0; r--) {
				if(map[r][c] == 0) {
					queue.offer(r);
				} else {
					if(queue.isEmpty()) {
						continue;
					} else {
						int index = queue.poll();
						map[index][c] = map[r][c];
						map[r][c] = 0;
						queue.offer(r);
					}
				}
			}
		}
	}
}
