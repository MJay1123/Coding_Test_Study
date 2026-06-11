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
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            double avg = sum / N;
            int answer = 0;
            for(int i=0; i<N; i++){
                if(arr[i] <= avg){
                    answer++;
                }
            }
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}