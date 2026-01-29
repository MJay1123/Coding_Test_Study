import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int testCase = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ");
			int[][] ladders = new int[100][100];
			int end = 0;
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
					if (ladders[r][c] == 2) {
						end = c;
					}
				}
			}
			int answer = 0;
			int r = 100;
			int c = end;
			while (true) {
				if (r == 0) {
					answer = c;
					break;
				}
				if (checkRange(r, c - 1) && ladders[r][c - 1] == 1) {
					while (checkRange(r, c - 1) && ladders[r][c - 1] == 1) {
						c--;
					}
				} else if (checkRange(r, c + 1) && ladders[r][c + 1] == 1) {
					while (checkRange(r, c + 1) && ladders[r][c + 1] == 1) {
						c++;
					}
				}
				r--;
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}

}