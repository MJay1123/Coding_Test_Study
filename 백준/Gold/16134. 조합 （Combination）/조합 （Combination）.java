import java.util.*;
import java.io.*;

public class Main {
	static int N, R;
	static long MOD = 1000000007;
	static long[] factorials = new long[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		long up = factorial(N);
		long down1 = square(factorial(R), MOD-2);
		long down2 = square(factorial(N-R), MOD-2);
		long answer = up * down1 % MOD * down2 % MOD;
		bw.write(answer + "\n");
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
