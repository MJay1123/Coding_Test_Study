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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(getRoot(a, arr) == getRoot(b, arr)) {
					continue;
				} else {
					arr[getRoot(b, arr)] = a;
				}
			}
            int answer = 0;
            for(int i=1; i<=N; i++) {
            	if(arr[i] == 0) {
            		answer++;
            	}
            }
            sb.append(answer).append("\n");
           
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int getRoot(int num, int[] arr) {
		while(true) {
			if(arr[num] == 0) {
				return num;
			}
			num = arr[num];
		}
	}
}