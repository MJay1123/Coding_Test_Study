import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());
            double c = Integer.parseInt(st.nextToken());
            double answer = Math.abs((a + c) / 2 - b);
            answer = (int)(answer * 10) * 1.0 / 10;
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}