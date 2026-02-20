import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			int[][] change = new int[Q][2];
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				change[i][0] = L;
				change[i][1] = R;
			}
			for(int r=Q-1; r>=0; r--) {
				int L = change[r][0];
				int R = change[r][1];
				for(int c=L; c<=R; c++) {
					if(arr[c] == 0) {
						arr[c] = r+1;
					}
				}
			}
			sb.append("#").append(testCase).append(" ");
			for(int i=1; i<=N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
