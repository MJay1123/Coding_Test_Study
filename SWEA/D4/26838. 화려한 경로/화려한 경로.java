import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, K;
	static int[] color;
	static List<Integer>[] connections;
	static int[][] dp;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			color = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			connections = new List[N+1];
			for(int i=1; i<=N; i++) {
				connections[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				if(color[num1] != color[num2]) {
					connections[num1].add(num2);
					connections[num2].add(num1);					
				}
			}
			dp = new int[N+1][1 << K];
			for(int i=1; i<=N; i++) {
				Arrays.fill(dp[i], -1);
			}
			for(int i=1; i<=N; i++) {
				dp[i][1 << (color[i]-1)] = 1;
			}
			answer = 0;
			
			for(int used=0; used < (1<<K); used++) {
				if(Integer.bitCount(used) >= 2) {
					for(int n=1; n<=N; n++) {
						answer += getDP(n, used);					
					}					
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getDP(int current, int used) {
		if(used == 0) {
			return 0;
		}
		if((used & (1 << (color[current]-1))) == 0) {
			return 0;
		}
		
		if(dp[current][used] == -1) {
			int sum = 0;
			int prevUsed = used ^ (1 << (color[current]-1));
			for(int prev : connections[current]) {
				if((prevUsed & (1 << (color[prev]-1))) > 0){
					sum += getDP(prev, prevUsed);					
				}
			}
			dp[current][used] = sum;
		}
		return dp[current][used];
	}
}
