import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] checkPoints = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalDistance = 0;
            for(int i=0; i<N; i++){
                checkPoints[i] = Integer.parseInt(st.nextToken());
                if(i > 0){
                    totalDistance += Math.abs(checkPoints[i] - checkPoints[i-1]);
                }
            }
            int[] skipDistance = new int[N];
            int max = 0;
            for(int i=1; i<N-1; i++){
                skipDistance[i] = Math.abs(checkPoints[i] - checkPoints[i-1]) + Math.abs(checkPoints[i+1] - checkPoints[i]) - Math.abs(checkPoints[i+1] - checkPoints[i-1]);
                if(max < skipDistance[i]){
                    max = skipDistance[i];
                }
            }
            int answer = totalDistance - max;
            bw.write(answer + "\n");
		}
        bw.flush();
	}
}