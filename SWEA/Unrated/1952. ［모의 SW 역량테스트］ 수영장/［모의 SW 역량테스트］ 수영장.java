import java.util.*;
import java.io.*;

class Solution {
	static int answer;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] prices = new int[4];
			for(int i=0; i<4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int[] days = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
				days[0] += days[i];
			}
			answer = 3000 * 30 * 12;
			if(days[0] > 0) {
				C(1, 0, prices, days);
			}
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static void C(int month, int money, int[] prices, int[] days) {
		if(month > 12) {
			answer = Math.min(answer, money);
			return;
		}
		C(month+1, money + prices[0] * days[month], prices, days);
		C(month+1, money + prices[1], prices, days);
		C(month+3, money + prices[2], prices, days);
		C(month+12, money + prices[3], prices, days);
	}
}