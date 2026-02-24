import java.util.*;
import java.io.*;

public class Solution {
	static int[] num = {2, 3, 5, 7, 11};
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			count = new int[5];
			for(int i=0; i<5; i++) {
				while(N % num[i] == 0) {
					N /= num[i];
					count[i]++;
				}
			}
			sb.append("#").append(testCase).append(" ");
			for(int i=0; i<5; i++) {
				sb.append(count[i]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
