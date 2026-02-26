import java.util.*;
import java.io.*;

public class Solution {
	static int x1, y1, x2, y2;
	static int[][][] move = {{{1,0},{-1,0}},{{0,1},{0,-1}}};
	static Integer[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()); 
			y1 = Integer.parseInt(st.nextToken()); 
			x2 = Integer.parseInt(st.nextToken()); 
			y2 = Integer.parseInt(st.nextToken()); 
			BFS();
			int answer = Math.min(map[x2+100][y2+100][0], map[x2+100][y2+100][1]);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void BFS() {
		map = new Integer[201][201][2];
		Queue<Integer> xQueue = new LinkedList<>();
		Queue<Integer> yQueue = new LinkedList<>();
		Queue<Integer> prevMoveQueue = new LinkedList<>();
		xQueue.offer(x1);
		xQueue.offer(x1);
		prevMoveQueue.offer(0);
		map[x1+100][y1+100][0] = 0;
		yQueue.offer(y1);
		yQueue.offer(y1);
		prevMoveQueue.offer(1);
		map[x1+100][y1+100][1] = 0;
		while(!xQueue.isEmpty()) {
			int x = xQueue.poll();
			int y = yQueue.poll();
			int prevMove = prevMoveQueue.poll();
			for(int i=0; i<2; i++) {
				int nx = x + move[1-prevMove][i][0];
				int ny = y + move[1-prevMove][i][1];
				if(checkRange(nx, ny)){
					if(map[nx+100][ny+100][1-prevMove] == null || map[nx+100][ny+100][1-prevMove] > map[x+100][y+100][prevMove] + 1) {
						xQueue.offer(nx);
						yQueue.offer(ny);
						prevMoveQueue.offer(1-prevMove);
						map[nx+100][ny+100][1-prevMove] = map[x+100][y+100][prevMove] + 1;
					}
				}
			}
		}
	}
	public static boolean checkRange(int x, int y) {
		return x >= -100 && x <= 100 && y >= -100 && y <= 100;
	}
}
