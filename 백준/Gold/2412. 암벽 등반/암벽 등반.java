import java.util.*;
import java.io.*;

class Main {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			Point p = (Point)obj;
			return this.x == p.x && this.y == p.y;
		}

		@Override
		public String toString() {
			return "Point[x=" + x + ", y=" + y + "]";
		}
		
	}

	static int n, T;
	static HashMap<Point, Integer> distanceMap = new HashMap<>();
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		distanceMap.put(new Point(0,0), 0);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			distanceMap.put(new Point(x, y), Integer.MAX_VALUE);
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
		Point start = new Point(0, 0);
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return distanceMap.get(p1) - distanceMap.get(p2);
			}
		});
		pq.offer(start);
		while(!pq.isEmpty()) {
//			System.out.println(distanceMap);
			Point currPoint = pq.poll();
			if(currPoint.y == T) {
				answer = Math.min(answer, distanceMap.get(currPoint));
			}
			for(int x=currPoint.x-2; x<=currPoint.x+2; x++) {
				for(int y=currPoint.y-2; y<=currPoint.y+2; y++) {
					if(x == currPoint.x && y == currPoint.y) {
						continue;
					}
					Point nextPoint = new Point(x, y);
					if(distanceMap.containsKey(nextPoint)) {
						if(distanceMap.get(currPoint) + 1 < distanceMap.get(nextPoint)) {
							distanceMap.replace(nextPoint, distanceMap.get(currPoint) + 1);
							pq.offer(nextPoint);
						}
					}
				}
			}
		}
	}
}