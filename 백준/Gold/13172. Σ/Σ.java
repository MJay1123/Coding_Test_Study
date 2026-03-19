import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static long[][] dices;
	static long moduler = 1000000007L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(br.readLine());
		dices = new long[M][2];
		long answer = 0;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long S = Long.parseLong(st.nextToken());
			dices[i][0] = N;
			dices[i][1] = S;
			answer += getNum(S, N);
			answer %= moduler;
		}
		bw.write(answer + "\n");
		bw.flush();
	}
	public static long point(long A, long B) {
		if(B == 0) {
			return 1L;
		}
		if(B == 1) {
			return A;
		}
		long half = point(A, B / 2);
		if(B % 2 == 1) {
			return (half * half % moduler) * A % moduler;
		} else {			
			return half * half % moduler;
		}
	}
	public static long getNum(long S, long N) {
		if(S % N == 0) {
			return S / N;
		}
		long inverse = point(N, moduler-2) % moduler;
		return S * inverse % moduler;
	}
}
