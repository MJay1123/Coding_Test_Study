import java.util.*;
import java.io.*;

public class Solution {
	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase <= T; testCase++) {
			long N = Long.parseLong(br.readLine());
			long answer = 0;
			while(N > 2) {
				long temp = binarySearch(N);
				answer += (temp * temp - N);
				answer++;
				N = temp;
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static long binarySearch(long N) {
		long left = 0;
		long right = 1000000;
		while(left < right) {
			long middle = (left + right) / 2;
			long mm = middle * middle;
			if(mm < N) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return left;
	}
}
