import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Integer> combi = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				combi.add((1 << a-1) | (1 << b-1));
			}
			int answer = 0;
			for (int i = 0; i < (1 << N); i++) {
				boolean possible = true;
				for (int j = 0; j < combi.size(); j++) {
					if (Integer.bitCount(i & combi.get(j)) == 2) {
						possible = false;
						break;
					}
				}
				if (possible) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}