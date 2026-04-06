import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] W;
	static int answer;
	static class Node implements Comparable<Node> {
		int num;
		int visit;
		int dist;
		public Node(int num, int visit, int dist) {
			this.num = num;
			this.visit = visit;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node n) {
			return this.dist - n.dist;
		}
	}
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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		answer = 1000000000;
		for(int start=0; start<N; start++) {
			pq.offer(new Node(start, 1 << start, 0));
			dp[start][(1 << start)] = 0;
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				int cn = n.num;
				int cv = n.visit;
				int cd = n.dist;
				if(cv == ((1 << N) - 1)) {
					if(W[cn][start] != 0) {
						answer = Math.min(answer, cd + W[cn][start]);
					}
				} else {
					for(int nn=0; nn<N; nn++) {
						if(nn == start) {
							continue;
						}
						if((cv & (1 << nn)) > 0) {
							continue;
						}
						if(W[cn][nn] == 0) {
							continue;
						}
						int nv = cv | (1 << nn);
						int nd = cd + W[cn][nn];
						if(dp[nn][nv] > nd) {
							dp[nn][nv] = nd;
							pq.offer(new Node(nn, nv, nd));
						}
					}
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
