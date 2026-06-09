import java.util.*;
import java.io.*;

class Solution {
    static long MOD = 1000000007L;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][3];
        dp[1][2] = 1;
        for(int r=2; r<=1000; r++){
            dp[r][1] = (dp[r-1][1] * r + dp[r-1][2] * (r / 2)) % MOD;		// 0이 아닌 개수
            dp[r][2] = dp[r-1][2] * (r - r / 2) % MOD;						// 0의 개수
            dp[r][0] = (dp[r-1][0] * r % MOD + (dp[r-1][1] + dp[r-1][2]) % MOD * (r / 2) % MOD) % MOD;
        }
		for(int test_case = 1; test_case <= T; test_case++)	{
			sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]);
            sb.append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}