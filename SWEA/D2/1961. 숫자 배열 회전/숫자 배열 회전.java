import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] arr90 = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    arr90[r][c] = arr[N-1-c][r];
                }
            }
            int[][] arr180 = reverse(arr);
            int[][] arr270 = reverse(arr90);
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append("\n");
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    sb.append(arr90[r][c]);
                }
                sb.append(" ");
                for(int c=0; c<N; c++){
                    sb.append(arr180[r][c]);
                }
                sb.append(" ");
                for(int c=0; c<N; c++){
                    sb.append(arr270[r][c]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
		}
        bw.flush();
	}
	public static int[][] reverse(int[][] arr){
        int n = arr.length;
        int[][] result = new int[n][n];
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                result[r][c] = arr[n-1-r][n-1-c];
            }
        }
        return result;
    }
}