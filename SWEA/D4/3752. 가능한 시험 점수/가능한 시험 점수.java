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
			boolean[] dp = new boolean[10001];
			int answer = 0;
			dp[0] = true;
			answer++;
			for(int i=0; i<N; i++) {
				int score = scores[i];
				for(int prev = 10000; prev>=0; prev--) {
					if(dp[prev]) {
						if(prev + score <= 10000 && !dp[prev + score]) {
							answer++;
							dp[prev + score] = true;
						}
					}
				}
			}
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
