import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] scores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			scores = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			boolean[][] dp = new boolean[N][10001];
			dp[0][0] = true;
			dp[0][scores[0]] = true;
			for(int i=1; i<N; i++) {
				int score = scores[i];
				for(int prev = 0; prev <=10000; prev++){
					if(dp[i-1][prev]) {
						dp[i][prev] = true;
						dp[i][prev + score] = true;
					}
				}
			}
			int answer = 0;
			for(int i=0; i<=10000; i++) {
				if(dp[N-1][i]) {
					answer++;
				}
			}
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
