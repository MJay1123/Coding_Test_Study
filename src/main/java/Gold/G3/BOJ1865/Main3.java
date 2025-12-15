package Gold.G3.BOJ1865;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 지점
            int M = Integer.parseInt(st.nextToken());   // 도로
            int W = Integer.parseInt(st.nextToken());   // 웜홀
            int[][] timeArray = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(timeArray[i], 10000);
            }
            boolean[][] isExist = new boolean[N + 1][N + 1];
            for (int road = 0; road < M; road++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if (isExist[S][E]) {
                    timeArray[S][E] = Math.min(timeArray[S][E], T);
                } else {
                    timeArray[S][E] = T;
                    isExist[S][E] = true;
                }
                if (isExist[E][S]) {
                    timeArray[E][S] = Math.min(timeArray[E][S], T);
                } else {
                    timeArray[E][S] = T;
                    isExist[E][S] = true;
                }
            }
            for (int wormHole = 0; wormHole < W; wormHole++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if (isExist[S][E]) {
                    timeArray[S][E] = Math.min(timeArray[S][E], -T);
                } else {
                    timeArray[S][E] = -T;
                    isExist[S][E] = true;
                }
            }
            boolean result = false;
            for(int start=1; start<=N; start++) {
                int[] distance = new int[N + 1];
                Arrays.fill(distance, INF);
                distance[start] = 0;
                for (int i = 1; i < N; i++) {
                    BF(timeArray, isExist, distance);
                }
                if(distance[start] < 0) {
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
    public static void BF(int[][] timeArray, boolean[][] isExist, int[] distance){
        for(int current=1; current<timeArray.length; current++){
            if(distance[current] != INF){
                for(int next=1; next<timeArray.length; next++){
                    if(isExist[current][next]){
                        distance[next] = Math.min(distance[next], distance[current] + timeArray[current][next]);
                    }
                }
            }
        }
    }
}