import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for(int i=1; i<=14; i++){
            arr[0][i] = i;
        }
        for(int r=1; r<=14; r++){
            for(int c=1; c<=14; c++){
                if(c == 1){
                    arr[r][c] = arr[r-1][c];
                } else {
                    arr[r][c] = arr[r][c-1] + arr[r-1][c];
                }
            }
        }
        for(int t=0; t<T; t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[k][n] + "\n");
        }
        bw.flush();
    }
}
