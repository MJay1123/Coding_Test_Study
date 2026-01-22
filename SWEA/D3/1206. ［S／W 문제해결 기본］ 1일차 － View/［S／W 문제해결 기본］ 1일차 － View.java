import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] buildings = new int[2][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                buildings[0][i] = Integer.parseInt(st.nextToken());		// 천장
            }
            for(int i=0; i<N; i++){
                for(int j=-2; j<=2; j++){
                    if(j == 0){
                        continue;
                    }
                    if(i+j >= 0 && i+j < N){
                        buildings[1][i] = Math.max(buildings[1][i], buildings[0][i+j]);
                    }
                }
            }
            int answer = 0;
            for(int i=0; i<N; i++){
                if(buildings[0][i] >= buildings[1][i]){
                	answer += buildings[0][i] - buildings[1][i];
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}