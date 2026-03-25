import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] connection;
	static int[] connectedCount;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connection = new List[N+1];
		for(int i=1; i<=N; i++) {
			connection[i] = new ArrayList<>();
		}
		connectedCount = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int previous = -1;
			int current = Integer.parseInt(st.nextToken());
			for(int j=1; j<count; j++) {
				previous = current;
				current = Integer.parseInt(st.nextToken());
				connection[previous].add(current);
				connectedCount[current]++;
			}
		}
		count = N;
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(connectedCount[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int current = queue.poll();
			count--;
			sb.append(current).append("\n");
			for(int next : connection[current]) {
				connectedCount[next]--;
				if(connectedCount[next] == 0) {
					queue.offer(next);
				}
			}
		}
		if(count == 0) {
			bw.write(sb.toString());
		} else {
			bw.write(0 + "\n");
		}
		bw.flush();
	}
}
