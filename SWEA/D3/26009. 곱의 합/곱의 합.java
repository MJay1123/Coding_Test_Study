import java.util.*;
import java.io.*;
class Solution {
    static long MOD = 998244353;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long A = (long)a * (a+1) / 2 % MOD;
            long B = (long)b * (b+1) / 2 % MOD;
            long C = (long)c * (c+1) / 2 % MOD;
            long answer = A * B % MOD * C % MOD;
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}