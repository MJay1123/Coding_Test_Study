import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());		// A회사 1L당 요금
            int Q = Integer.parseInt(st.nextToken());		// B회사 기본 요금
            int R = Integer.parseInt(st.nextToken());		// 기본 요금 제한
            int S = Integer.parseInt(st.nextToken());		// 1L당 추가 요금
            int W = Integer.parseInt(st.nextToken());		// 사용 L
            int priceA = P * W;
            int priceB = (W <= R) ? Q : Q + (W-R) * S;
            int answer = Math.min(priceA, priceB);
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}