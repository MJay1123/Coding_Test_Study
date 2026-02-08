import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			int N = Integer.parseInt(br.readLine());
            for(int i=0; i<8; i++) {
            	sb.append(N / coins[i]).append(" ");
            	N %= coins[i];
            }
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}