import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] W;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				W[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		int[][] dp = new int[N][(1 << N)];
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], 100000000);							
		}
		Queue<Integer> numQueue = new LinkedList<>();
		Queue<Integer> visitQueue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			dp[i][(1 << i)] = 0;
			numQueue.offer(i);
			visitQueue.offer(1 << i);
		}
		answer = 1000000000;
		for(int start=0; start<N; start++) {
			dp[start][(1 << start)] = 0;
			numQueue.offer(start);
			visitQueue.offer(1 << start);
			while(!numQueue.isEmpty()) {
				int cn = numQueue.poll();
				int cv = visitQueue.poll();
				if(cv == (1 << N) - 1) {
					if(W[cn][start] != 0) {
						answer = Math.min(answer, dp[cn][cv] + W[cn][start]);
					}
				} else {
					for(int nn=0; nn<N; nn++) {
						if(nn == start) {
							continue;	// 시작점 x
						}
						if((cv & (1 << nn)) > 0) {
							continue;	// 이미 방문한 경우
						}
						if(W[cn][nn] == 0) {
							continue;	// 갈 수 없는 경우
						}
						int nv = cv | (1 << nn);
						if(dp[nn][nv] > dp[cn][cv] + W[cn][nn]) {
							dp[nn][nv] = dp[cn][cv] + W[cn][nn];
							numQueue.offer(nn);
							visitQueue.offer(nv);
						}
					}
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
