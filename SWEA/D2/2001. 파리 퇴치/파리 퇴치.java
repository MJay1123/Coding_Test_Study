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
            int[][] map = new int[N][N];
            for(int r=0; r<N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int r=0; r<=N-M; r++){
                for(int c=0; c<=N-M; c++){
                    answer = Math.max(answer, catchFly(map, r, c, M));
                }
            }
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
    public static int catchFly(int[][] map, int r, int c, int M){
        int count = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                count += map[r+i][c+j];
            }
        }
        return count;
    }
}