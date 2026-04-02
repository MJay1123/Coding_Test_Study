import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static long MOD = 1000000007;
	static long[] factorials = new long[4000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			long up = factorial(N);
			long down1 = square(factorial(K), MOD-2);
			long down2 = square(factorial(N-K), MOD-2);
			long answer = up * down1 % MOD * down2 % MOD;
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static long square(long a, long b) {
		if(b == 0) {
			return 1;
		}
		long temp = square(a, b / 2);
		if(b % 2 == 0) {
			return temp * temp % MOD;
		} else {
			return temp * temp % MOD * a % MOD;
		}
	}
	public static long factorial(int n) {
		if(factorials[n] == 0) {
			if(n == 0) {
				factorials[0] = 1;
			} else {
				factorials[n] = factorial(n-1) * n % MOD;				
			}
		}
		return factorials[n];
	}
}
