import java.util.*;
import java.io.*;

public class Solution {
	static int V, E;
	static List<Integer>[] connectedTo, connectedFrom;
	static int[] previousNodeCounts;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			connectedTo = new List[V+1];
			connectedFrom = new List[V+1];
			previousNodeCounts = new int[V+1];
			for(int i=1; i<=V; i++) {
				connectedTo[i] = new ArrayList<>();
				connectedFrom[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				connectedTo[num1].add(num2);
				connectedFrom[num2].add(num1);	
				previousNodeCounts[num2]++;
			}
			BFS();
		 	sb.append("#").append(testCase).append(" ");
		 	for(int i=0; i<list.size(); i++) {
		 		sb.append(list.get(i)).append(" ");
		 	}
		 	sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void BFS() {
		list.clear();
		boolean[] visited = new boolean[V+1];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=V; i++) {
			if(connectedFrom[i].size() == 0) {
				queue.offer(i);
				list.add(i);
				visited[i] = true;
			}
		}
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int next : connectedTo[num]) {
				previousNodeCounts[next]--;
				if(!visited[next] && previousNodeCounts[next] == 0) {
					queue.offer(next);
					list.add(next);
					visited[next] = true;
				}
			}
		}
	}
}