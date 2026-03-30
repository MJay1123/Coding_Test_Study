import java.util.*;
import java.io.*;

public class Main {
	static class Line {
		long x1, y1;
		long x2, y2;
		public Line(long x1, long y1, long x2, long y2) {
			if(x1 <= x2) {
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
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[][] arr = new long[4][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0][0] = Long.parseLong(st.nextToken());
		arr[0][1] = Long.parseLong(st.nextToken());
		arr[1][0] = Long.parseLong(st.nextToken());
		arr[1][1] = Long.parseLong(st.nextToken());
		Line l1 = new Line(arr[0][0], arr[0][1], arr[1][0], arr[1][1]);
		st = new StringTokenizer(br.readLine());
		arr[2][0] = Long.parseLong(st.nextToken());
		arr[2][1] = Long.parseLong(st.nextToken());
		arr[3][0] = Long.parseLong(st.nextToken());
		arr[3][1] = Long.parseLong(st.nextToken());
		Line l2 = new Line(arr[2][0], arr[2][1], arr[3][0], arr[3][1]);
		int answer = checkCross(l1, l2);
		bw.write(answer + "\n");
		bw.flush();
	}
	public static int checkCross(Line l1, Line l2) {
		long x1 = l1.x1;
		long y1 = l1.y1;
		long x2 = l1.x2;
		long y2 = l1.y2;
		long x3 = l2.x1;
		long y3 = l2.y1;
		long x4 = l2.x2;
		long y4 = l2.y2;
		if(x2 < x3 || x4 < x1) {
			return 0;
		}
		if(Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {
			return 0;
		}
		if(ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0) {
			return 1;
		} else {
			return 0;
		}
	}
	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long result = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
		if(result > 0) {
			return 1;
		} else if(result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
