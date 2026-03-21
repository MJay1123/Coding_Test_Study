import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		long[][] dots = new long[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dots[i][0] = Long.parseLong(st.nextToken());
			dots[i][1] = Long.parseLong(st.nextToken());
		}
		long sum = 0;
		for (int i = 1; i < N - 1; i++) {
			sum += getTriangle(dots[0][0], dots[0][1], dots[i][0], dots[i][1], dots[i + 1][0], dots[i + 1][1]);
		}
		sum = Math.abs(sum);
		double answer = sum / 2.0;
		answer = Math.round(answer * 10) / 10.0;
		System.out.printf("%.1f\n", answer);
	}

	public static long getTriangle(long x1, long y1, long x2, long y2, long x3, long y3) {
		long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3); 
		return temp;
	}
}
