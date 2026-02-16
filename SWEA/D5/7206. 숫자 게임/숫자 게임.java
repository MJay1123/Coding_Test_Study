import java.util.*;
import java.io.*;

class Solution {
	static Integer[] memo = new Integer[100000];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int startNum = Integer.parseInt(br.readLine());
			int answer = get(startNum);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int get(int num) {
		if (memo[num] == null) {
			memo[num] = divide(num);
		}
		return memo[num];
	}

	public static int divide(int num) {
		if (num < 10) {
			return 0;
		}
		int length = (int)Math.log10(num);
		int result = 0;
		for (int bit = 1; bit < (1 << length); bit++) {
			result = Math.max(result, 1 + get(divideByBit(num, bit)));
		}
		return result;
	}

	public static int divideByBit(int num, int bit) {
		int result = 1;
		String str = num + "";
		int prev = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((bit & (1 << i)) > 0) {
				result *= Integer.parseInt(str.substring(prev, i + 1));
				prev = i + 1;
			}
		}
		if(prev < str.length()) {
			result *= Integer.parseInt(str.substring(prev));
		}
		return result;
	}
}
