import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int[] minimumCount = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] nextPlace = new int[101][7];
        for(int r=1; r<=100; r++){
            for(int c=1; c<=6; c++){
                nextPlace[r][c] = (r+c <= 100) ? r+c : 100;
            }
        }
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int r=start-6; r<=start-1; r++){
                if(r >= 1) {
                    nextPlace[r][start - r] = end;
                }
            }
        }
        for(int i=1; i<=100; i++){
            minimumCount[i] = Integer.MAX_VALUE;
        }
        BFS(1, nextPlace);
        answer = minimumCount[100];
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void BFS(int start, int[][] nextPlace){
        minimumCount[start] = 0;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            start = queue.poll();
            visited[start] = true;
            for(int i=1; i<=6; i++){
                int next = nextPlace[start][i];
                if(!visited[next]){
                    if(minimumCount[next] > minimumCount[start] + 1){
                        minimumCount[next] = minimumCount[start] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
