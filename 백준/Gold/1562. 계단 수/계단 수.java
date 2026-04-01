import java.util.*;
import java.io.*;

public class Main {
	static int INF = 1000000000;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[][][] dp = new int[N+1][10][(1<<10)];		// dp[length][last_num][visited_bit]
		for(int num=1; num<=9; num++) {
			dp[1][num][(1 << num)] = 1;
		}
		for(int length = 1; length < N; length++) {
			for(int visited_bit=0; visited_bit < (1 << 10); visited_bit++) {
				dp[length+1][1][visited_bit | 2] += dp[length][0][visited_bit];
				dp[length+1][1][visited_bit | 2] %= INF;
				for(int last_num=1; last_num<=8; last_num++) {
					dp[length+1][last_num-1][visited_bit | (1 << (last_num-1))] += dp[length][last_num][visited_bit];
					dp[length+1][last_num-1][visited_bit | (1 << (last_num-1))] %= INF;
					dp[length+1][last_num+1][visited_bit | (1 << (last_num+1))] += dp[length][last_num][visited_bit];
					dp[length+1][last_num+1][visited_bit | (1 << (last_num+1))] %= INF;
				}
				dp[length+1][8][visited_bit | (1 << 8)] += dp[length][9][visited_bit];
				dp[length+1][8][visited_bit | (1 << 8)] %= INF;
			}
		}
		long answer = 0;
		for(int last_num=0; last_num <= 9; last_num++) {
			answer += dp[N][last_num][(1 << 10) - 1];
			answer %= INF;
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
