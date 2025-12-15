package Gold.G3.BOJ1865;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
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
            for(int n=1; n<=N; n++){
                boolean[] visited = new boolean[N+1];
                DFS(n, n, 0, timeArray, isExist, visited);
            }
            boolean result = false;
            for(int i=0; i<list.size(); i++){
                if(list.get(i) < 0){
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
    public static void DFS(int start, int current, int time, int[][] timeArray, boolean[][] isExist, boolean[] visited){
        for(int next=1; next<timeArray.length; next++){
            if(isExist[current][next] && !visited[next]){
                if(next == start){
                    list.add(time + timeArray[current][next]);
                    return;
                }
                visited[next] = true;
                DFS(start, next, time+timeArray[current][next], timeArray, isExist, visited);
                visited[next] = false;
            }
        }
    }
}

