import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static boolean possible = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            String str =  br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int[][] result = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                result[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != result[i][j]){
                    if(i+2 < N && j+2 < M){
                        change(arr, i+1, j+1);
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
        }
        if(possible){
            bw.write(count + "\n");
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
    }

    public static void change(int[][] arr, int r, int c){
        count++;
        for(int i=r-1; i<=r+1; i++){
            for(int j=c-1; j<=c+1; j++){
                if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
                    continue;
                }
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
    }
}
