import java.util.*;
import java.io.*;

class Solution {
	static class Tank {
		int r;
		int c;
		int direction;
		public Tank(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
		public void move(int direction) {
			this.direction = direction;
			int nr = r + directions[direction][0];
			int nc = c + directions[direction][1];
			if(checkRange(nr, nc) && map[nr][nc] == '.') {
				map[r][c] = '.';
				map[nr][nc] = tankShape[direction];
				this.r = nr;
				this.c = nc;
			} else {
				map[r][c] = tankShape[direction];
			}
		}
		public void shoot() {
			int sr = this.r;
			int sc = this.c;
			int direction = this.direction;
			while(true) {
				sr += directions[direction][0];
				sc += directions[direction][1];
				if(checkRange(sr, sc)) {
					if(map[sr][sc] == '*') {
						map[sr][sc] = '.';
						break;
					} else if(map[sr][sc] == '#') {
						break;
					} else {
						continue;
					}
				} else {
					break;
				}
			}
		}
	}
	static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static char[] tankShape = {'v', '>', '^', '<'};
	static char[][] map;
	static int W, H;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Tank tank = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int r = 0; r < H; r++) {
				String str = br.readLine();
				for (int c = 0; c < W; c++) {
					map[r][c] = str.charAt(c);
					if ("<>^v".contains(map[r][c] + "")) {
						tank = new Tank(r, c, getDirection(map[r][c]));
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			for(int i=0; i<N; i++) {
				char command = commands.charAt(i);
				process(command, tank);
			}
			map[tank.r][tank.c] = tankShape[tank.direction];  
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					sb.append(map[r][c]);
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getDirection(char ch) {
		for(int i=0; i<4; i++) {
			if(tankShape[i] == ch) {
				return i;
			}
		}
		return -1;
	}
	public static void process(char command, Tank tank) {
		if(command == 'S') {
			tank.shoot();
		}
		if(command == 'U') {
			tank.move(2);
		}
		if(command == 'D') {
			tank.move(0);
		}
		if(command == 'L') {
			tank.move(3);
		}
		if(command == 'R') {
			tank.move(1);
		}
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}