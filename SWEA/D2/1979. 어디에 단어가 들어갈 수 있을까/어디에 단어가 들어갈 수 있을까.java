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
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int r=0; r<N; r++){
                int count = 0;
                for(int c=0; c<N; c++){
                    if(arr[r][c] == 1){
                        count++;
                    } else {
                        if(count == K){
                            answer++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    answer++;
                }
            }
            for(int c=0; c<N; c++){
                int count = 0;
                for(int r=0; r<N; r++){
                    if(arr[r][c] == 1){
                        count++;
                    } else {
                        if(count == K){
                            answer++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    answer++;
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}