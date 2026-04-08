import java.util.*;
import java.io.*;

public class Solution {
	static int N, K;
	static int[] V;
	static int[] C;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			V = new int[N+1];
			C = new int[N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			dp = new int[N+1][K+1];
			for(int i=1; i<=N; i++) {
				if(V[i] <= K) {
					dp[i][V[i]] = Math.max(dp[i][V[i]], C[i]);
					answer = Math.max(answer,  dp[i][V[i]]);
				}
			}
			for(int r=1; r<=N; r++) {
				for(int c=0; c<=K; c++) {
					if(dp[r][c] > 0) {
						for(int i=r+1; i<=N; i++) {
							if(c + V[i] <= K) {
								dp[i][c+V[i]] = Math.max(dp[i][c+V[i]], dp[r][c] + C[i]);
								answer = Math.max(answer, dp[i][c+V[i]]);
							}
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
