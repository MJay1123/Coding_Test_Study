import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            if(i == 1){
                arr[i] = 1;
            } else if(i == 2) {
                arr[i] = 3;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
            }
        }
        bw.write(arr[n] + "\n");
        bw.flush();
    }
}
