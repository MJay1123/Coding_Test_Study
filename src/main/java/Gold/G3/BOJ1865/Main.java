package Gold.G3.BOJ1865;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<TC; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 지점
            int M = Integer.parseInt(st.nextToken());   // 도로
            int W = Integer.parseInt(st.nextToken());   // 웜홀
            int[][] timeArray = new int[N+1][N+1];
            for(int i=0; i<=N; i++){
                Arrays.fill(timeArray[i], 10000);
            }
            boolean[][] isExist = new boolean[N+1][N+1];
            list.clear();
            for(int road=0; road<M; road++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(isExist[S][E]){
                    timeArray[S][E] = Math.min(timeArray[S][E], T);
                } else {
                    timeArray[S][E] = T;
                    isExist[S][E] = true;
                }
                if(isExist[E][S]){
                    timeArray[E][S] = Math.min(timeArray[E][S], T);
                } else {
                    timeArray[E][S] = T;
                    isExist[E][S] = true;
                }
            }
            for(int wormHole=0; wormHole<W; wormHole++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(isExist[S][E]) {
                    timeArray[S][E] = Math.min(timeArray[S][E], -T);
                } else {
                    timeArray[S][E] = -T;
                    isExist[S][E] = true;
                }
            }
            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(timeArray[i][j] > timeArray[i][k] + timeArray[k][j]){
                            timeArray[i][j] = timeArray[i][k] + timeArray[k][j];
                        }
                    }
                }
            }
            boolean result = false;
            for(int i=1; i<=N; i++){
                if(timeArray[i][i] < 0){
                    result = true;
                    break;
                }
            }
            if(result){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}

