import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int r=1; r<dp.length; r++){
            for(int c=1; c<dp[0].length; c++){
                if(str1.charAt(r-1) == str2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
        bw.write(dp[dp.length - 1][dp[0].length - 1] + "\n");
        bw.flush();
    }
}
