import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] arr;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int number = 1;
            int directionIndex = 0;
            int r = 0; 
            int c = 0;
            while(true){
                if(!checkRange(r, c) || arr[r][c] != 0){
                    break;
                }
                arr[r][c] = number++;
                int nr = r + direction[directionIndex][0];
                int nc = c + direction[directionIndex][1];
                if(!checkRange(nr, nc) || arr[nr][nc] != 0){
                    directionIndex = (directionIndex + 1) % 4;
                    nr = r + direction[directionIndex][0];
                    nc = c + direction[directionIndex][1];
                }
                r = nr;
                c = nc;
            }
            sb.append("#").append(test_case).append("\n");
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}