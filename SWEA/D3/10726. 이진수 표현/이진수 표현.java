import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= TC; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int temp = 0;
			for(int i=0; i<N; i++) {
				temp = temp | (1 << i);
			}
			if((temp & M) == temp) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}