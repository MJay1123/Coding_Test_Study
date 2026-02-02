import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

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
			int[][] map = new int[N+1][N+1];
			int[][] arr = new int[N+1][N+1];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r+1][c+1] = Integer.parseInt(st.nextToken());
					arr[r+1][c+1] = map[r+1][c+1] + arr[r][c+1] + arr[r+1][c] - arr[r][c];
				}
			}
			int answer = 0;
			for(int r=1; r<N+1-M+1; r++) {
				for(int c=1; c<N+1-M+1; c++) {
					int temp = arr[r+M-1][c+M-1] - arr[r+M-1][c-1] - arr[r-1][c+M-1] + arr[r-1][c-1];
					answer = Math.max(answer, temp);
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}