import java.util.*;
import java.io.*;

public class Solution {
	static int[] tickets = new int[4];
	static int[] days = new int[13];
	static int MAX = 3000 * 365;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				tickets[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[13];
			Arrays.fill(dp, MAX);
			dp[12] = tickets[3];
			dp[0] = 0;
			for(int month=1; month<=12; month++) {
				if(month - 3 >= 0) {
					dp[month] = Math.min(dp[month], dp[month-3] + tickets[2]);
				}
				dp[month] = Math.min(dp[month], dp[month-1] + tickets[1]);
				dp[month] = Math.min(dp[month], dp[month-1] + days[month] * tickets[0]);
			}
			int answer = dp[12];
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
