import java.util.*;
import java.io.*;

public class Solution {
	static int K, N, M;
	static List<MicroOrganism>[][] map;
	static int[][] directions = {{},{-1,0},{1,0},{0,-1},{0,1}};
	static class MicroOrganism implements Comparable<MicroOrganism>{
		int r;
		int c;
		int amounts;
		int direction;
		public MicroOrganism(int r, int c, int amounts, int direction) {
			this.r = r;
			this.c = c;
			this.amounts = amounts;
			this.direction = direction;
		}
		public void move() {
			if(amounts == 0) {
				return;
			}
			map[r][c].remove(this);
			r += directions[direction][0];
			c += directions[direction][1];
			if(r == 0 || c == 0 || r == N-1 || c == N-1) {
				amounts /= 2;
				direction = (direction <= 2) ? (3-direction) : (7-direction);
			}
			map[r][c].add(this);
		}
		@Override
		public int compareTo(MicroOrganism m) {
			return m.amounts - this.amounts;
		}
		
	}
	static MicroOrganism[] micros;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new List[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = new ArrayList<>();
				}
			}
			micros = new MicroOrganism[K];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int amounts = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				MicroOrganism mo = new MicroOrganism(r, c, amounts, direction);
				micros[i] = mo;
				map[r][c].add(mo);
			}
			for(int time=0; time<M; time++) {
				for(int j=0; j<K; j++) {
					micros[j].move();
				}
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(map[r][c].size() > 1) {
							Collections.sort(map[r][c]);
							MicroOrganism mo = map[r][c].get(0);
							for(int j=1; j<map[r][c].size(); j++) {
								mo.amounts += map[r][c].get(j).amounts;
								map[r][c].get(j).amounts = 0;
							}
							map[r][c].clear();
							map[r][c].add(mo);
						}
					}
				}
			}
			int answer = 0;
			for(int i=0; i<K; i++) {
				answer += micros[i].amounts;
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
