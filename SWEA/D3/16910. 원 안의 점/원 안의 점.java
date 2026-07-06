import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            N = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int x=1; x<=N; x++){
                for(int y=1; y<=N; y++){
                    if(x * x + y * y <= N * N){
                        answer++;
                    }
                }
            }
            answer = answer * 4 + N * 4 + 1;
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}