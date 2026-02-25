import java.util.*;
import java.io.*;

class Solution {
	static int A, B;
	static boolean[] memo;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		memo = new boolean[1001];
		for(int i=1; i<=32; i++) {
			if(i == reverseNumber(i) && (i*i) == reverseNumber(i*i)) {
				memo[i*i] = true;
			}
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			int answer = 0;
			for(int i=A; i<=B; i++) {
				if(memo[i]) {
					answer++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int reverseNumber(int num) {
		if(num > 1000) {
			return -1;
		}
		int temp = 0;
		while(num > 0) {
			temp *= 10;
			temp += num % 10;
			num /= 10;
		}
		return temp;
	}
}
