import java.util.*;
import java.io.*;

public class Main {
	static int N;

	static class Line {
		int x1, y1;
		int x2, y2;

		public Line(int x1, int y1, int x2, int y2) {
			if (x1 <= x2) {
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			} else {
				this.x1 = x2;
				this.y1 = y2;
				this.x2 = x1;
				this.y2 = y1;
			}
		}

		@Override
		public String toString() {
			return "Line [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
		}
	}

	static Line[] lines;
	static int[] parents;
	static int[] counts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		lines = new Line[N];
		parents = new int[N];
		counts = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			lines[i] = new Line(x1, y1, x2, y2);
			parents[i] = i;
			counts[i] = 1;
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				union(i, j);
			}
		}
		int groupCount = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			int count = counts[i];
			if(count > 0) {
				groupCount++;
				max = Math.max(max, count);
			}
		}
		bw.write(groupCount + "\n");
		bw.write(max + "\n");
		bw.flush();
	}
	public static boolean union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		if(root1 == root2) {
			return false;
		}
		Line l1 = lines[num1];
		Line l2 = lines[num2];
		if(checkCross(l1, l2)) {
			if(counts[root1] <= counts[root2]) {
				parents[root1] = root2;
				counts[root2] += counts[root1];
				counts[root1] = -1;
			} else {
				parents[root2] = root1;
				counts[root1] += counts[root2];
				counts[root2] = -1;
			}
			return true;
		}
		return false;
	}
	public static int find(int num) {
		if(parents[num] == num) {
			return num;
		}
		parents[num] = find(parents[num]);
		return parents[num];
	}
	public static boolean checkCross(Line l1, Line l2) {
		int x1 = l1.x1;
		int y1 = l1.y1;
		int x2 = l1.x2;
		int y2 = l1.y2;
		int x3 = l2.x1;
		int y3 = l2.y1;
		int x4 = l2.x2;
		int y4 = l2.y2;
		if(x2 < x3 || x4 < x1) {
			return false;
		}
		if(Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {
			return false;
		}
		if(ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0) {
			return true;
		}
		return false;
	}
	public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		if(result > 0) {
			return 1;
		} else if(result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}