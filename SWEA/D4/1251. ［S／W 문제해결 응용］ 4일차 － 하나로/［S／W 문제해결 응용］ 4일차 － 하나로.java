import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] islandLocations;
	static class Island {
		int index;
		long x;
		long y;
		public Island(int index, long x, long y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
	static class Connection {
		Island is1;
		Island is2;
		double distance;
		public Connection(Island is1, Island is2) {
			this.is1 = is1;
			this.is2 = is2;
			this.distance = Math.pow(is1.x - is2.x, 2) + Math.pow(is1.y - is2.y, 2);
		}
	}
	static int[] arr;
	static Island[] islands;
	static double E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			islandLocations = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				islandLocations[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				islandLocations[i][1] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			islands = new Island[N];
			for(int i=0; i<N; i++) {
				islands[i] = new Island(i, islandLocations[i][0], islandLocations[i][1]);
			}
			PriorityQueue<Connection> pq = new PriorityQueue<>(new Comparator<Connection>() {
				@Override
				public int compare(Connection c1, Connection c2) {
					if(c1.distance < c2.distance) {
						return -1;
					} else {
						return 1;
					}
				}
			});
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					pq.offer(new Connection(islands[i], islands[j]));
				}
			}
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = i;
			}
			int count = 0;
			double distSum = 0;
			while(true) {
				if(count == N-1) {
					break;
				}
				Connection c = pq.poll();
				if(union(c.is1.index, c.is2.index)) {
					distSum += c.distance;
					count++;
				}
			}
			long answer = Math.round(E * distSum);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean union(int num1, int num2) {
		if(getRoot(num1) == getRoot(num2)) {
			return false;
		}
		arr[getRoot(num1)] = getRoot(num2);
		return true;
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