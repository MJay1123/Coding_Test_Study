import java.util.*;
import java.io.*;

public class Solution {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			int oneCount = 0;
			int twoCount = 0;
			for (int i = 0; i < N; i++) {
				int difference = maxHeight - trees[i];
				if (difference % 2 == 1) {
					oneCount++;
				}
				twoCount += difference / 2;
			}
			int answer = 0;
			if (oneCount == twoCount) {
				answer += 2 * twoCount;
			} else if (oneCount > twoCount) {
				answer += 2 * twoCount;
				oneCount -= twoCount;
				answer += 2 * (oneCount - 1) + 1;
			} else {
				answer += 2 * oneCount;
				twoCount -= oneCount;
				answer += (twoCount / 3) * 4;
				twoCount %= 3;
				if (twoCount == 1) {
					answer += 2;
				} else if (twoCount == 2) {
					answer += 3;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
