import java.util.*;
import java.io.*;
public class Solution {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Long.parseLong(br.readLine());
            long answer = -1;
            long low = 1;
            long high = 1000000 + 1;
            while(low < high){
                long middle = (low + high) / 2;
                long result = middle * middle * middle;
                if(result == N){
                    answer = middle;
                    break;
                }
                if(result > N){
                    high = middle;
                } else if(result < N){
                    low = middle + 1;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}