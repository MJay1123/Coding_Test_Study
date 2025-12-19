import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int answer = 1;
        dp[0] = 1;
        for(int i=1; i<N; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(A[j] < A[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            answer= Math.max(answer, dp[i]);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
