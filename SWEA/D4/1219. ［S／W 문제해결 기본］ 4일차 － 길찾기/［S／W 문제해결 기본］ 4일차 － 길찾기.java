import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int test_case = Integer.parseInt(st.nextToken());
			int[][] roads = new int[100][2];
			boolean[] visited = new boolean[100];
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(roads[start][0] == 0) {
					roads[start][0] = end;
				} else {
					roads[start][1] = end;
				}
			}
			DFS(0, roads, visited);
			int answer = visited[99] ? 1 : 0;
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void DFS(int num, int[][] roads, boolean[] visited) {
		for(int i=0; i<2; i++) {
			if(roads[num][i] != 0) {
				visited[roads[num][i]] = true;
				DFS(roads[num][i], roads, visited);
			}
		}
	}
}	