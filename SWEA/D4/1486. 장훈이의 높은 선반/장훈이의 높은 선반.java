import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int S = 0;
			st = new StringTokenizer(br.readLine());
			int[] heights = new int[N];
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				S += heights[i];
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			combination(heights, 0, 0, pq, B);
			int answer = pq.peek() - B;
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void combination(int[] heights, int index, int sum, PriorityQueue<Integer> pq, int B) {
		if(index == heights.length) {
			if(sum >= B) {
				pq.offer(sum);
			}
			return;
		}
		combination(heights, index+1, sum+heights[index], pq, B);
		combination(heights, index+1, sum, pq, B);
	}
}
