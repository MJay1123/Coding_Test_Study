import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i][0] = r;
			arr[i][1] = c;
		}
		int[][] dp = new int[N][N];
		for(int d=1; d<N; d++) {
			int left = 0;
			int right = left + d;
			while(true) {
				int min = Integer.MAX_VALUE;
				if(right >= N) {
					break;
				}
				for(int i=left; i<right; i++) {
					min = Math.min(min, dp[left][i] + dp[i+1][right] + arr[left][0] * arr[i][1] * arr[right][1]);
				}
				dp[left][right] = min;
				left++;
				right++;
			}
		}
		int answer = dp[0][N-1];
		bw.write(answer + "\n");
		bw.flush();
	}
}