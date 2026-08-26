import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] prices;
	static int[] satisfactions;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// N : 1 ~ 1000000
			// M : 1 ~ 25
			prices = new int[M];
			satisfactions = new int[M];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				prices[i] = Integer.parseInt(st.nextToken());
				satisfactions[i] = Integer.parseInt(st.nextToken());
			}
			answer = new int[M+1];
			C(0, new boolean[M], 0, 0);
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<M; i++) {
				if(answer[i] == 1) {
					sb.append(i).append(" ");
				}
			}
			sb.append(answer[M]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void C(int depth, boolean[] visited, int price, int satisfaction) {
		if(price > N) {
			return;
		}
		if(depth == M) {
			if(satisfaction > answer[M]) {
				for(int i=0; i<M; i++) {
					if(visited[i]) {
						answer[i] = 1;
					} else {
						answer[i] = 0;
					}
				}
				answer[M] = satisfaction;
			}
			return;
		}
		visited[depth] = true;
		C(depth+1, visited, price + prices[depth], satisfaction + satisfactions[depth]);
		visited[depth] = false;
		C(depth+1, visited, price, satisfaction);
	}
}
