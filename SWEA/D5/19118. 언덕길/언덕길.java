import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] heights = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }
            int[] counts = new int[N];
            int max = 0;
            for(int i=1; i<N; i++){
                for(int j=0; j<i; j++){
                    if(heights[j] < heights[i]){
                        counts[i] = Math.max(counts[i], counts[j] + 1);
                        max = Math.max(max, counts[i]);
                    }
                }
            }
            int answer = N - max - 1;
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}