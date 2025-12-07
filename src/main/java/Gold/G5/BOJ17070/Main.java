package Gold.G5.BOJ17070;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] home = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] arr = new int[N][N][3];
        arr[0][1][0] = 1;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(checkRange(r, c+1, N) && home[r][c+1] != 1){
                    arr[r][c+1][0] += arr[r][c][0] + arr[r][c][1];
                }
                if(checkRange(r+1, c+1, N) && home[r+1][c+1] != 1 && home[r][c+1] != 1 && home[r+1][c] != 1) {
                    arr[r+1][c+1][1] += arr[r][c][0] + arr[r][c][1] + arr[r][c][2];
                }
                if(checkRange(r+1, c, N) && home[r+1][c] != 1) {
                    arr[r+1][c][2] += arr[r][c][1] + arr[r][c][2];
                }
            }
        }
        bw.write(arr[N-1][N-1][0] + arr[N-1][N-1][1] + arr[N-1][N-1][2] + "\n");
        bw.flush();
    }
    public static boolean checkRange(int r, int c, int N){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
