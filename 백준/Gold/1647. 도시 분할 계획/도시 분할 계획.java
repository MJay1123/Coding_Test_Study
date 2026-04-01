import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static Road[] roads;
	static class Road implements Comparable<Road> {
		int num1;
		int num2;
		int cost;
		public Road(int num1, int num2, int cost) {
			this.num1 = num1;
			this.num2 = num2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Road r) {
			return this.cost - r.cost;
		}
	}
	static class Connection implements Comparable<Connection> {
		int num;
		int cost;
		public Connection(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public int compareTo(Connection c) {
			return this.cost - c.cost;
		}
	}
	static int[] parents; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		roads = new Road[M];
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			roads[i] = new Road(A, B, C);
		}
		Arrays.sort(roads);
		int groupCount = N;
		int costSum = 0;
		for(int i=0; i<M; i++) {
			if(groupCount == 2) {
				break;
			}
			Road r = roads[i];
			int num1 = r.num1;
			int num2 = r.num2;
			int cost = r.cost;
			if(union(num1, num2)) {
				costSum += cost;
				groupCount--;
			}
		}
		int answer = costSum;
		bw.write(answer + "\n");
		bw.flush();
	}
	public static int find(int num) {
		if(parents[num] == num) {
			return num;
		}
		parents[num] = find(parents[num]);
		return parents[num];
	}
	public static boolean union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		if(root1 == root2) {
			return false;
		}
		parents[root1] = root2;
		return true;
	}
}
