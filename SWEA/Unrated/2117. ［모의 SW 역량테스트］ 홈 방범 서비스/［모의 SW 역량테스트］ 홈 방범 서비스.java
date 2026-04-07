import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[][] map;
	static int[] maxCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxCount = new int[2 * N];
			int[][][] range = new int[2 * N][N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						for(int rr=0; rr<N; rr++) {
							for(int cc=0; cc<N; cc++) {
								int dist = getDistance(r, c, rr, cc);
								for(int d=dist; d < 2*N; d++) {
									range[d][rr][cc]++;
									maxCount[d] = Math.max(maxCount[d], range[d][rr][cc]);
								}
							}
						}						
					}
				}
			}
			int answer = 0;
			for(int d=1; d<2*N; d++) {
				int cost = d * d + (d-1) * (d-1);
				if(cost <= maxCount[d] * M) {
					answer = maxCount[d];
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	public static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2) + 1;
	}
}