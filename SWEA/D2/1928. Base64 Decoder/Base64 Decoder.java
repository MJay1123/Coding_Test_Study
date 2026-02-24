import java.util.*;
import java.io.*;

public class Solution {
	static String[] bits = new String[64];
	static char[] arr = new char[64];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 64; i++) {
			bits[i] = Integer.toString(i, 2);
			int l = bits[i].length();
			bits[i] = "000000".substring(l) + bits[i];
		}
		for (int i = 0; i < 26; i++) {
			arr[i] = (char) ('A' + i);
		}
		for (int i = 26; i < 52; i++) {
			arr[i] = (char) ('a' + i - 26);
		}
		for (int i = 52; i < 62; i++) {
			arr[i] = (char) ('0' + i - 52);
		}
		arr[62] = '+';
		arr[63] = '-';
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int n = getNum(ch);
				sb2.append(bits[n]);
			}
			String temp = sb2.toString();
			sb2 = new StringBuilder();
			for (int j = 0; j < temp.length(); j += 8) {
				if (j + 8 <= temp.length()) {
					int k = Integer.parseInt(temp.substring(j, j + 8), 2);
					sb2.append((char)(k));
				}
			}
			sb.append("#").append(testCase).append(" ").append(sb2.toString()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int getNum(char ch) {
		for (int i = 0; i < 64; i++) {
			if (arr[i] == ch) {
				return i;
			}
		}
		return 0;
	}
}
