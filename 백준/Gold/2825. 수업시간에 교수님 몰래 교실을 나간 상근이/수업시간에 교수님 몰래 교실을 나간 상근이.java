import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int[] countOfBits = new int[(1 << 10)];
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			int bit = 0;
			while(num > 0) {
				int digit = (int)(num % 10);
				bit = (bit | (1 << digit));
				num /= 10;
			}
			countOfBits[bit]++;
		}
		long answer = 0;
		for(int i=0; i<countOfBits.length; i++) {
			int count = countOfBits[i];
			answer += C(count);
		}
		for(int i=0; i<countOfBits.length-1; i++) {
			for(int j=i+1; j<countOfBits.length; j++) {
				if((i & j) > 0) {
					answer += (long)countOfBits[i] * countOfBits[j];
				}
			}
		}
		sb.append(answer).append("\n");
		bw.write(sb.toString());
		bw.flush();
	}
	public static long C(int a) {
		return (long)a * (a-1) / 2;
	}
}