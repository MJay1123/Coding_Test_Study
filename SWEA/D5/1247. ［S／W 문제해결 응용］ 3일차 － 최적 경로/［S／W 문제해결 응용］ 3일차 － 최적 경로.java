import java.util.*;
import java.io.*;

public class Solution {
	static class Location {
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static Location home;
	static Location company;
	static Location[] customers;
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
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company = new Location(x, y);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new Location(x, y);
			customers = new Location[N];
			for(int i=0; i<N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				customers[i] = new Location(x, y); 
			}
			answer = 10000000;
			visited = new boolean[N];
			goToNext(0, 0, company);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void goToNext(int visitedCount, int distance, Location current) {
		if(visitedCount == N) {
			answer = Math.min(answer, distance + getDistance(current, home));
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				goToNext(visitedCount+1, distance + getDistance(current, customers[i]), customers[i]);
				visited[i] = false;
			}
		}
	}
	public static int getDistance(Location loc1, Location loc2) {
		return Math.abs(loc1.x - loc2.x) + Math.abs(loc1.y - loc2.y); 
	}
}