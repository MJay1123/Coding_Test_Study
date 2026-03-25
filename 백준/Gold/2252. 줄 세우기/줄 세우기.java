import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] connectedTo;
	static int[] preCount;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connectedTo = new List[N+1];
		preCount = new int[N+1];
		for(int i=1; i<=N; i++) {
			connectedTo[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connectedTo[a].add(b);
			preCount[b]++;
		}
		BFS();
		bw.write(sb.toString());
		bw.flush();
	}
	public static void BFS() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(preCount[i] == 0) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for(int next : connectedTo[current]) {
				preCount[next]--;
				if(preCount[next] == 0 && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}
