import java.util.*;
import java.io.*;

class Main {
	static int n, T;
	static HashMap<Long, Integer> longMap = new HashMap<>();
	static int answer;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		longMap.put(0L, 0);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long yx = (long)y * 10000000L + x;
			longMap.put(yx, Integer.MAX_VALUE);
		}
		answer = 1000000;
		dijkstra();
		if(answer == 1000000) {
			answer = -1;
		}
		sb.append(answer).append("\n");
		bw.write(sb.toString());
		bw.flush();
	}

	public static void dijkstra() {
		long start = 0L;
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long l1, Long l2) {
				return longMap.get(l1) - longMap.get(l2);
			}
		});
		pq.offer(start);
		while(!pq.isEmpty()) {
			long current = pq.poll();
			long cx = current % 10000000L;
			long cy = current / 10000000L;
			if(cy == T) {
				answer = Math.min(answer, longMap.get(current));
			}
			for(long x=cx-2; x<=cx+2; x++) {
				for(long y=cy-2; y<=cy+2; y++) {
					if(x == cx && y == cy) {
						continue;
					}
					long next = y * 10000000L + x;
					if(longMap.containsKey(next)) {
						if(longMap.get(current) + 1 < longMap.get(next)) {
							longMap.replace(next, longMap.get(current) + 1);
							pq.offer(next);
						}
					}
				}
			}
		}
	}
}