import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int V = Integer.parseInt(br.readLine());
		List<Integer>[][] connection = new List[V + 1][2];
		for (int i = 1; i <= V; i++) {
			connection[i][0] = new ArrayList<>();	// 연결된 정점
			connection[i][1] = new ArrayList<>();	// 정점까지의 거리
		}
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				connection[num][0].add(node);
				connection[num][1].add(weight);
			}
		}
		boolean[] visited = new boolean[V + 1];
		int[] temp = BFS(1, connection, visited);
		visited = new boolean[V + 1];
		int[] result = BFS(temp[0], connection, visited);
		int answer = result[1];
		bw.write(answer + "\n");
		bw.flush();
	}

	public static int[] BFS(int start, List<Integer>[][] connection, boolean[] visited) {
		int[] result = new int[2]; // {number, distance}
		result[0] = start;
		Queue<Integer> numQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		numQueue.offer(start);
		distQueue.offer(0);
		visited[start] = true;
		while (!numQueue.isEmpty()) {
			int num = numQueue.poll();
			int dist = distQueue.poll();
			for (int i = 0; i < connection[num][0].size(); i++) {
				int next = connection[num][0].get(i);
				int weight = connection[num][1].get(i);
				if (!visited[next]) {
					visited[next] = true;
					numQueue.offer(next);
					distQueue.offer(dist + weight);
					if (result[1] < dist + weight) {
						result[0] = next;
						result[1] = dist + weight;
					}
				}
			}
		}
		return result;
	}
}