import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(A % 2 == 0 || B % 2 == 0 || C % 2 == 0) {
				sb.append(1);
			} else {
				sb.append(2);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}