import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int count = BFS();
		bw.write(distance[K] + "\n" + count);
		bw.flush();
	}

	public static int BFS() {
		distance = new int[100001];
		Arrays.fill(distance,  1000000);
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		queue.offer(N);
		distQueue.offer(0);
		distance[N] = 0;
		int count = 1;
		int[] next = new int[3];
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int dist = distQueue.poll();
			next[0] = cur + 1;
			next[1] = cur - 1;
			next[2] = cur * 2;
			int nextDistance = 0;
			for (int i = 0; i < 3; i++) {
				if(next[i] < 0) {
					continue;
				} else if (next[i] > 100000) {
					nextDistance = dist + 1 + (next[i] - 100000);
					next[i] = 100000;
				} else {
					nextDistance = dist + 1;
				}
				if (distance[next[i]] > nextDistance) {
					distance[next[i]] = nextDistance;
					queue.offer(next[i]);
					distQueue.offer(nextDistance);
					if (next[i] == K) {
						count = 1;
					}
				} else if (distance[next[i]] == nextDistance) {
					queue.offer(next[i]);
					distQueue.offer(nextDistance);
					if (next[i] == K) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
