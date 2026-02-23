import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] company;
	static int[] home;
	static int[][] customers;
	static int answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			company = new int[] {cx, cy};
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			home = new int[] {hx, hy};
			customers = new int[N][2];
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customers[i][0] = x;
				customers[i][1] = y;
			}
			answer = 10000000;
			visited = new boolean[N]; 
			visitCustomers(company, 0, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void visitCustomers(int[] current, int distance, int visitedCount) {
		if(visitedCount == N) {
			int result = distance + getDistance(current, home);
			answer = Math.min(answer, result);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				visitCustomers(customers[i], distance + getDistance(current, customers[i]), visitedCount+1);
				visited[i] = false;
			}
		}
	}
	public static int getDistance(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0])+ Math.abs(loc1[1] - loc2[1]); 
	}
}
