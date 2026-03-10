import java.util.*;
import java.io.*;

public class Solution {
	static int V, E;
	static int[] arr;
	static class Connection {
		int num1;
		int num2;
		int weight;
		public Connection(int num1, int num2, int weight) {
			this.num1 = num1;
			this.num2 = num2;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new int[V+1];
			for(int i=1; i<=V; i++) {
				arr[i] = i;
			}
			PriorityQueue<Connection> pq = new PriorityQueue<>(new Comparator<Connection>() {
				@Override
				public int compare(Connection c1, Connection c2) {
					return c1.weight - c2.weight;
				}
			});
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pq.offer(new Connection(A, B, C));
			}
			int count = 0;
			long weight = 0;
			while(!pq.isEmpty()) {
				if(count == V-1) {
					break;
				}
				Connection c = pq.poll();
				if(union(c.num1, c.num2)) {
					count++;
					weight += c.weight;
				}
			}
			sb.append("#").append(testCase).append(" ").append(weight).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean union(int num1, int num2) {
		if(getRoot(num1) != getRoot(num2)) {
			arr[getRoot(num1)] = getRoot(num2);
			return true;
		}
		return false;
	}
	public static int getRoot(int num) {
		List<Integer> list = new ArrayList<>();
		while(arr[num] != num) {
			list.add(num);
			num = arr[num];
		}
		for(int i : list) {
			arr[i] = num;
		}
		return num;
	}
}
