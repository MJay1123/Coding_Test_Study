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
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
            int answer = 0;
            if(A.length <= B.length) {
            	answer = getSum(A, B);
            } else {
            	answer = getSum(B, A);
            }
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int getSum(int[] shorter, int[] longer) {
		int sLen = shorter.length;
		int lLen = longer.length;
		int max = 0;
		for(int i=0; i<=lLen-sLen; i++) {
			int sum = 0;
			for(int j=0; j<sLen; j++) {
				sum += shorter[j] * longer[i+j];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}