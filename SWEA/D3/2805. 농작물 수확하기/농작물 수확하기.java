import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			int center = N / 2;
			int distance = N / 2;
			int answer = 0;
			int[][] farm = new int[N][N];
			for(int r=0; r<N; r++) {
				String temp = br.readLine();
				for(int c=0; c<N; c++) {
					farm[r][c] = temp.charAt(c) - '0';
					if(Math.abs(r-center) + Math.abs(c-center) <= distance) {
						answer += farm[r][c];
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
