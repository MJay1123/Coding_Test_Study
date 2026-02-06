import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[6];
			int answer = 0;
			int sum = 0;
			for(int i=0; i<6; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
				answer = Math.max(answer,  arr[i]);
			}
			answer += (7-((sum + answer) % 7));
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}