import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			String num = br.readLine();
			int answer = Integer.parseInt(num);
			for(int i=1; i<num.length(); i++) {
				int a = Integer.parseInt(num.substring(0, i));
				int b = Integer.parseInt(num.substring(i, num.length()));
				answer = Math.min(answer,  a + b);
			}
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
