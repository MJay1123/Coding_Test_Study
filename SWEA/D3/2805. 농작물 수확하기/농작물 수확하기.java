import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int distance = (N-1) / 2;
            int[][] arr = new int[N][N];
            int answer = 0;
            for(int r=0; r<N; r++){
                String line = br.readLine();
                for(int c=0; c<N; c++){
                    arr[r][c] = line.charAt(c) - '0';
                    if(getDistance(r, c, distance, distance) <= distance){
                        answer += arr[r][c];
                    }
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
    public static int getDistance(int r1, int c1, int r2, int c2){
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
}