package notyet.BOJ2206;

import java.io.*;
import java.util.*;

public class Main {

    static int N;               // 지도의 세로 길이
    static int M;               // 지도의 가로 길이
    static int[][] map;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int[][][] distance = new int[N][M][2];
        distance[N-1][M-1][0] = 1000 * 1000;
        distance[N-1][M-1][1] = 1000 * 1000;
        boolean[][] visited = new boolean[N][M];
        boolean[][] breakVisited = new boolean[N][M];
        BFS(new Location(0, 0), distance, visited, breakVisited);
        if(distance[N-1][M-1][0] < distance[N-1][M-1][1]){
            answer = distance[N-1][M-1][0];
        }
        answer = Math.min(distance[N-1][M-1][0], distance[N-1][M-1][1]);
        if(answer == 1000 * 1000){
            bw.write(-1 + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
    }

    public static void BFS(Location loc, int[][][] distance, boolean[][] visited, boolean[][] breakVisited){
        int r = loc.r;
        int c = loc.c;
        Queue<Location> queue = new LinkedList<>();
        Queue<Boolean> breakQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        queue.offer(loc);
        breakQueue.offer(false);
        distanceQueue.offer(1);
        visited[r][c] = true;
        distance[r][c][0] = 1;

        while(!queue.isEmpty()){
            loc = queue.poll();
            boolean wallBreak = breakQueue.poll();
            int dist = distanceQueue.poll();
            r = loc.r;
            c = loc.c;
            for(int i=0; i<4; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(checkRange(nr, nc)){
                    if(!wallBreak){
                        if(map[nr][nc] == 0){
                            if(visited[nr][nc]){
                                continue;
                            } else {
                                distance[nr][nc][0] = dist + 1;
                                visited[nr][nc] = true;
                                queue.offer(new Location(nr, nc));
                                breakQueue.offer(false);
                                distanceQueue.offer(dist + 1);
                            }
                        } else {
                            distance[nr][nc][1] = dist + 1;
                            breakVisited[nr][nc] = true;
                            queue.offer(new Location(nr, nc));
                            breakQueue.offer(true);
                            distanceQueue.offer(dist + 1);
                        }
                    } else {
                        if(map[nr][nc] == 1){
                            continue;
                        } else {
                            if(breakVisited[nr][nc]){
                                continue;
                            } else {
                                distance[nr][nc][1] = dist + 1;
                                breakVisited[nr][nc] = true;
                                queue.offer(new Location(nr, nc));
                                breakQueue.offer(true);
                                distanceQueue.offer(dist + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    static class Location{
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
