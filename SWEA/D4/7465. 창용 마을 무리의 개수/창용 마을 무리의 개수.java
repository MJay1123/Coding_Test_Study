import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(getRoot(a) != getRoot(b)) {
					arr[getRoot(b)] = a;
				}
			}
			int answer = 0;
			for(int i=1; i<=N; i++) {
				if(arr[i] == 0) {
					answer++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getRoot(int num) {
		if(arr[num] == 0) {
			return num;
		}
		return getRoot(arr[num]);
	}
}
