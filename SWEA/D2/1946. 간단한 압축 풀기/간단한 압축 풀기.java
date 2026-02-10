import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			int N = Integer.parseInt(br.readLine());
			int n = 0;
			int count = 0;
			while(n < N) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String Ci = st.nextToken();
				int Ki = Integer.parseInt(st.nextToken());
				n++;
				for(int i=0; i<Ki; i++) {
					if(count == 10) {
						sb.append("\n");
						count = 0;
					}
					sb.append(Ci);
					count++;
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}