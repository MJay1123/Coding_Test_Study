import java.io.*;
import java.util.*;

public class Solution {
	static int N, B, S;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			S = 0;
			st = new StringTokenizer(br.readLine());
			int[] heights = new int[N];
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				S += heights[i];
			}
			result = S;
			C(heights, 0, 0);
			int answer = result - B;
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void C(int[] heights, int index, int sum) {
		if(sum >= B) {
			result = Math.min(result, sum);
			return;
		}
		if(index == heights.length) {
			return;
		}
		C(heights, index+1, sum+heights[index]);
		C(heights, index+1, sum);
	}
}
