import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            boolean answer = true;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for(int i=0; i<N; i++){
                int time = arr[i];
                int bread = time / M * K;
                int visitedCount = i + 1;
                if(bread < visitedCount){
                    answer = false;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
            if(answer){
                sb.append("Possible\n");
            } else {
                sb.append("Impossible\n");
            }
            bw.write(sb.toString());
		}
        bw.flush();
	}
}