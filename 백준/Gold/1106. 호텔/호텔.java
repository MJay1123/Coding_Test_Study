import java.util.*;
import java.io.*;

public class Main {
	static int C, N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[C + 1];		// dp[people] = minimum_cost
		Arrays.fill(dp, 1000000);
		dp[0] = 0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<N; j++) {
				int cost = arr[j][0];
				int increase = arr[j][1];
				int index = i + increase > C ? C : i + increase;
				dp[index] = Math.min(dp[index], dp[i] + cost);				
			}
		}
		int answer = dp[C];
		bw.write(answer + "\n");
		bw.flush();
	}
}