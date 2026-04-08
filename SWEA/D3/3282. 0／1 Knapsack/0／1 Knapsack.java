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
			dp = new int[N+1][K+1];
			for(int i=0; i<=N; i++) {
				Arrays.fill(dp[i], -1);
			}
			int answer = getDP(0, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getDP(int index, int volume) {
		if(index > N || volume > K) {
			return 0;
		}
		if(dp[index][volume] == -1) {
			int temp = 0;
			for(int i=index+1; i<=N; i++) {
				int v = V[i];
				int c = C[i];
				if(volume + v <= K) {
					temp = Math.max(temp, getDP(i, volume + v) + c);
				}
			}
			dp[index][volume] = temp;
		}
		return dp[index][volume];
	}
}
