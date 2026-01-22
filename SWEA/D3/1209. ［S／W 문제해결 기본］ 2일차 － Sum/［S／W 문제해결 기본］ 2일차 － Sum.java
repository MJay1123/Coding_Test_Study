import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 1; t<=10; t++){
			int testCase = Integer.parseInt(br.readLine());
            int[][] arr = new int[101][101];
            int[] diagonalSum = new int[2];
            for(int r=1; r<=100; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=1; c<=100; c++){
                    arr[r][c] = Integer.parseInt(st.nextToken());
                    arr[r][0] += arr[r][c];
                    arr[0][c] += arr[r][c];
                    if(r == c){
                        diagonalSum[0] += arr[r][c];
                    }
                    if(r + c == 101){
                        diagonalSum[1] += arr[r][c];
                    }
                }
            }
            int answer = Math.max(diagonalSum[0], diagonalSum[1]);
            for(int i=1; i<=100; i++){
                answer = Math.max(answer, Math.max(arr[0][i], arr[i][0]));
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}