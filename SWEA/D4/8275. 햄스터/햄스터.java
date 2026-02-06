import java.util.*;
import java.io.*;

class Solution {
	static int N, X, M; // 햄스터 우리 N개, 각 우리에 햄스터 최대 X마리
	static int[] answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken()); // 우리 최대 햄스터 수
			M = Integer.parseInt(st.nextToken());
			int[][] cages = new int[2][N + 1];
			int[][] arr = new int[M][3];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); // {left, right, count} left ~ right 우리 안애 count 햄스터
				}
			}
			answer = null;
			C(1, cages, arr);
			if (answer == null) {
				sb.append(-1).append("\n");
			} else {
				for (int i = 1; i <= N; i++) {
					sb.append(answer[i]).append(" ");
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int[] copyArray(int[][] array) {
		int[] newArray = new int[array[0].length];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = array[0][i];
		}
		return newArray;
	}

	public static void C(int index, int[][] cages, int[][] arr) {
		if (index == N + 1) {
			if (check(cages, arr)) {
				if (answer == null) {
					answer = copyArray(cages);
				} else {
					if (answer[0] < cages[0][0]) {
						answer = copyArray(cages);
					} else if (answer[0] == cages[0][0]) {
						for (int i = 1; i <= N; i++) {
							if (answer[i] < cages[0][i]) {
								return;
							} else if (answer[i] > cages[0][i]) {
								answer = copyArray(cages);
								return;
							} else {
								continue;
							}
						}
					}
				}
			}
			return;
		}
		for (int i = X; i >= 0; i--) {
			cages[0][index] = i;
			C(index + 1, cages, arr);
		}
	}

	public static boolean check(int[][] cages, int[][] arr) {
		for (int i = 1; i <= N; i++) {
			cages[1][i] = cages[1][i - 1] + cages[0][i];
		}
		cages[0][0] = cages[1][N];
		for (int i = 0; i < M; i++) {
			int left = arr[i][0];
			int right = arr[i][1];
			int count = arr[i][2];
			if (cages[1][right] - cages[1][left - 1] != count) {
				return false;
			}
		}
		return true;
	}
}