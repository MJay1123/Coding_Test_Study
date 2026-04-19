import java.util.*;
import java.io.*;

public class Solution {
	static int n, m;
	static int[][] chocolate;
	static int[][] sumChocolate;
	static long[][][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			chocolate = new int[n][m];
			for(int r=0; r<n; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<m; c++) {
					chocolate[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			sumChocolate = new int[n+1][m+1];
			for(int r=1; r<=n; r++) {
				for(int c=1; c<=m; c++) {
					sumChocolate[r][c] = sumChocolate[r][c-1] + chocolate[r-1][c-1];
				}				
			}
			for(int r=1; r<=n; r++) {
				for(int c=1; c<=m; c++) {
					sumChocolate[r][c] += sumChocolate[r-1][c];
				}
			}
			dp = new long[n][m][n][m];
			long answer = getDP(0, 0, n-1, m-1);
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static long getDP(int sr, int sc, int er, int ec) {
		if(sr == er && sc == ec) {
			return 0;
		} else {
			if(dp[sr][sc][er][ec] == 0) {
				long sum = sumChocolate[er+1][ec+1] - sumChocolate[er+1][sc] - sumChocolate[sr][ec+1] + sumChocolate[sr][sc];
				long minimum = Long.MAX_VALUE;
				for(int r=sr; r<er; r++) {
					long result = getDP(sr, sc, r, ec) + getDP(r+1, sc, er, ec);
					minimum = Math.min(minimum, sum + result);
				}
				for(int c=sc; c<ec; c++) {
					long result = getDP(sr, sc, er, c) + getDP(sr, c+1, er, ec);
					minimum = Math.min(minimum, sum + result);					
				}
				dp[sr][sc][er][ec] = minimum;
			}
		}
		return dp[sr][sc][er][ec];
	}
}

