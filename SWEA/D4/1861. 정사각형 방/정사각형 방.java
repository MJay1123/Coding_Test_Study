import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] visited = new boolean[N][N];
            int[] answer = new int[2];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(!visited[r][c]){
                        int[] result = BFS(r, c, map, visited);
                        if(answer[1] < result[1]){
                            answer[1] = result[1];
                            answer[0] = result[0];
                        } else if(answer[1] == result[1]){
                            answer[0] = Math.min(answer[0], result[0]);
                        }
                    }
                }
            }
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int[] BFS(int startR, int startC, int[][] map, boolean[][] visited){
        // {minimumNumber, count}
        int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
        int[] result = new int[2];
        result[0] = map[startR][startC];
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        rQueue.offer(startR);
        cQueue.offer(startC);
        visited[startR][startC] = true;
        result[1]++;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            for(int m=0; m<4; m++){
                int nr = r + move[m][0];
                int nc = c + move[m][1];
                if(checkRange(nr, nc, map.length) && !visited[nr][nc] && (Math.abs(map[r][c] - map[nr][nc]) == 1)){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    visited[nr][nc] = true;
                    result[1]++;
                    if(result[0] > map[nr][nc]){
                        result[0] = map[nr][nc];
                    }
                }
            }
        }
        return result;
    }
    public static boolean checkRange(int r, int c, int N){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}