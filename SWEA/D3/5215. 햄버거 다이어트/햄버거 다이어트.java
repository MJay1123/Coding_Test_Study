import java.io.*;
import java.util.*;

class Solution {
	static int N, L;
	static int answer;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] ingredients = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			boolean[] used = new boolean[N];
			C(0, 0, 0, ingredients, used);
			sb.append(answer).append(" ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void C(int index, int scoreSum, int calorieSum, int[][] ingredients, boolean[] used) {
		if(calorieSum > L) {
			return;
		}
		if(index == N) {
			answer = Math.max(answer, scoreSum);
			return;
		}
		used[index] = true;
		C(index+1, scoreSum + ingredients[index][0], calorieSum + ingredients[index][1], ingredients, used);
		used[index] = false;
		C(index+1, scoreSum, calorieSum, ingredients, used);
	}
}