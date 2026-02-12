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
			List<Integer> twoBits = new ArrayList<>();
			for(int i=0; i<(1 << N); i++) {
				if(Integer.bitCount(i) == 2){
					twoBits.add(i);
				}
			}
			int[][] synergy = new int[N][N];
			int[] score = new int[(1 << N) - 1];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					synergy[r][c] = Integer.parseInt(st.nextToken());
					int bit = (1 << r) | (1 << c);
					score[bit] += synergy[r][c];
				}
			}
			int difference = Integer.MAX_VALUE;
			for(int a=0; a < (1 << N); a++) {
				if(Integer.bitCount(a) == N / 2) {
					int b = ((1 << N) - 1) ^ a;
					int scoreA = 0;
					int scoreB = 0;
					for(int bit : twoBits) {
						if((a & bit) == bit) {
							scoreA += score[bit];
						}
						if((b & bit) == bit) {
							scoreB += score[bit];
						}
					}
					difference = Math.min(difference, Math.abs(scoreA - scoreB));
				}
			}
			sb.append("#").append(testCase).append(" ").append(difference).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
