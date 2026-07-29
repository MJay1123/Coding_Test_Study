import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    static int[][] successRate;
    static boolean[] visited;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            successRate = new int[N][N];
            for(int r=0; r<N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    successRate[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N];
            answer = 0.0;
            work(0, 1.0);
            answer *= 100;
            sb.append("#").append(tc).append(" ").append(String.format("%.6f", answer)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void work(int index, double percentage){
        if(percentage <= answer){
            return;
        }
        if(index == N){
            answer = Math.max(answer, percentage);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                work(index+1, percentage * (successRate[index][i] * 1.0 / 100));
                visited[i] = false;
            }
        }
    }
}