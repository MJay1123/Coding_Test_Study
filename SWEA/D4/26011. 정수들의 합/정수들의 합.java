import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			long answer = B(N, K);
            sb.append(answer).append("\n");  
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static long B(int N, int K) {
		long answer = 0;
		for(int left=N-1; left >= K-N+1; left--) {
			int right = K - left;
			answer += A(N, left) * A(N, right);
		}
		return answer;
	}
	public static long A(int N, int x) {
		if(Math.abs(x) >= N) {
			return 0;
		}
		return N - Math.abs(x);
	}
}
