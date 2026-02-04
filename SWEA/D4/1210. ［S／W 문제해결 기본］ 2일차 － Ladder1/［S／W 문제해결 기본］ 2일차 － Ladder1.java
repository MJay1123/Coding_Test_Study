import java.util.*;
import java.io.*;

public class Solution {
	static int startC = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			sb.append("#").append(testCase).append(" ");
			int[][] ladders = new int[100][100];
			int endC = 0;
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
					if(ladders[r][c] == 2) {
						endC = c;
					}
				}
			}
			DFS(99, endC, ladders);
			int answer = startC;
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}
	public static void DFS(int r, int c, int[][] ladders) {
		if(r == 0) {
			startC = c;
			return;
		}
		if(checkRange(r, c-1) && ladders[r][c-1] == 1) {
			while(checkRange(r, c-1) && ladders[r][c-1] == 1) {
				c--;
			}
		} else if(checkRange(r, c+1) && ladders[r][c+1] == 1) {
			while(checkRange(r, c+1) && ladders[r][c+1] == 1) {
				c++;	
			}
		}
		DFS(r-1, c, ladders);
	}
}
