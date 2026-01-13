import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N+1][N+1];
            for(int r=1; r<=N; r++){
                for(int c=1; c<=r; c++){
                    if(r == 1 || c == 1 || c == N){
                        arr[r][c] = 1;
                    } else {
                        arr[r][c] = arr[r-1][c-1] + arr[r-1][c];
                    }
                }
            }
            bw.write("#" + test_case + "\n");
            for(int r=1; r<=N; r++){
                for(int c=1; c<=r; c++){
                    bw.write(arr[r][c] + " ");
                }
                bw.write("\n");
            }
		}
        bw.flush();
	}
}