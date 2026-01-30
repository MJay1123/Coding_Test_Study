import java.util.*;
import java.io.*;

class Solution {
	static String[] encryptedNumber = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
			"0111011", "0110111", "0001011" };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int startIndex = -1;
			String code = "";
			for (int n = 0; n < N; n++) {
				String temp = br.readLine();
				if (startIndex == -1) {
					for (int m = M - 1; m >= 0; m--) {
						if (temp.charAt(m) == '1') {
							code = temp.substring(m - 55, m + 1);
							break;
						}
					}
				}
			}
			int[] numbers = getNumbers(code);
			int answer = checkNumbers(numbers);
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int checkNumbers(int[] numbers) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < 8; i += 2) {
			sum1 += numbers[i];
			sum2 += numbers[i + 1];
		}
		if ((sum1 * 3 + sum2) % 10 == 0) {
			return sum1 + sum2;
		}
		return 0;
	}

	public static int[] getNumbers(String str) {
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			String temp = str.substring(7 * i, 7 * (i + 1));
			arr[i] = getNumber(temp);
		}
		return arr;
	}

	public static int getNumber(String str) {
		for (int i = 0; i < 10; i++) {
			if (encryptedNumber[i].equals(str)) {
				return i;
			}
		}
		return 0;
	}
}