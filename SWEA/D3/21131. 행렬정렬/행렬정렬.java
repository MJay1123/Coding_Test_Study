import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] arr;
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1][N+1];
            for(int r=1; r<=N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=1; c<=N; c++){
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            while(true){
                boolean finished = true;
                for(int c=N; c>=2; c--){
                	if(arr[1][c] != c){
                    	transpose(arr, c);
                        answer++;
                        finished = false;
                    	break;
                    }
            	}
                if(finished){
                    break;
                }
            }
			sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static void transpose(int[][] arr, int x) {
        for(int r=1; r<=x; r++){
            for(int c=1; c<r; c++){
                int temp = arr[r][c];
                arr[r][c] = arr[c][r];
                arr[c][r] = temp;
            }
        }
    }
}