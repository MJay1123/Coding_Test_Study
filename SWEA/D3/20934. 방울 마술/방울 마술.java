import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cup = st.nextToken();
			int bell = 0;
			for(int i=0; i<3; i++) {
				if(cup.charAt(i) == 'o') {
					bell = i;
				}
			}
			int K = Integer.parseInt(st.nextToken());
			int answer = 0;
			if(K == 0) {
				answer = bell;
			} else {
				if(bell % 2 == 0) {
					answer = (K % 2 == 0) ? 0 : 1;
				} else {
					answer = (K % 2 == 0) ? 1 : 0;
				}
			}
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
