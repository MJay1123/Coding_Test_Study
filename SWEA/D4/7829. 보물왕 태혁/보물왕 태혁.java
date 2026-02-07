import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int P = Integer.parseInt(br.readLine());
			int[] arr = new int[P];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<P; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int answer = 0;
			if(P % 2 == 0) {
				answer = arr[0] * arr[P-1];
			} else {
				answer = arr[P/2] * arr[P/2];
			}
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}