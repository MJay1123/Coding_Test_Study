import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[1000];
			int[] counts = new int[101];
			int answer = 0;
			int maxCount = 0;
			for(int i=0; i<1000; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				counts[arr[i]]++;
				if(maxCount < counts[arr[i]]) {
					maxCount = counts[arr[i]];
					answer = arr[i];
				} else if(maxCount == counts[arr[i]]) {
					answer = Math.max(answer, arr[i]);
				}
			}
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}