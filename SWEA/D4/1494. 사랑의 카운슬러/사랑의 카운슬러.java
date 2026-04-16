import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] X;
	static int[] Y;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			Y = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
			answer = Long.MAX_VALUE;
			match(0, 0, 0, 0, 0);
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void match(int x, int y, int pc, int mc, int index) {
		if(index == N) {
			long vectorSize = 0L + (long)x * x + (long)y * y;
			answer = Math.min(answer, vectorSize);
			return;
		}
		if(pc < N/2) {
			match(x + X[index], y + Y[index], pc+1, mc, index+1);
		}
		if(mc < N/2) {
			match(x - X[index], y - Y[index], pc, mc+1, index+1);
		}
	}
}

