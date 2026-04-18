import java.util.*;
import java.io.*;

public class Solution {
	static int N;
//	static List<Integer>[] connections;
//	static boolean[] visited;
	static int[] connectionCount;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
//			connections = new List[N+1];
			connectionCount = new int[N+1];
//			for(int i=1; i<=N; i++) {
//				connections[i] = new ArrayList<>();
//			}
			for(int i=0; i<N-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
//				connections[u].add(v);
//				connections[v].add(u);
				connectionCount[u]++;
				connectionCount[v]++;
			}
			answer = 0;
			for(int i=1; i<=N; i++) {
				if(connectionCount[i] > 2) {
					answer += connectionCount[i] - 2;
				}
			}
//			if(N > 1) {
//				int start = 0;
//				for(int i=1; i<=N; i++) {
//					if(connections[i].size() == 1) {
//						start = i;
//						break;
//					}
//				}
//				visited = new boolean[N+1];
//				DFS(start);
//			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
//	public static void DFS(int num) {
//		visited[num] = true;
//		if(connections[num].size() > 2) {
//			answer += (connections[num].size() - 2);
//		}
//		for(int next : connections[num]) {
//			if(!visited[next]) {
//				DFS(next);
//			}
//		}
//	}
}
