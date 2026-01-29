import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int testCase = Integer.parseInt(br.readLine());
            int[][] map = new int[16][16];
            int[] startEnd = new int[4];
            for(int r=0; r<16; r++){
                String temp = br.readLine();
                for(int c=0; c<16; c++){
                    map[r][c] = temp.charAt(c) - '0';
                    if(map[r][c] == 2){
                        startEnd[0] = r;
                        startEnd[1] = c;
                    }
                    if(map[r][c] == 3){
                        startEnd[2] = r;
                        startEnd[3] = c;
                    }
                }
            }
            boolean[][] visited = new boolean[16][16];
            BFS(startEnd, map, visited);
            if(visited[startEnd[2]][startEnd[3]]){
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean check(int r, int c, int[][] map){
        if(r >= 0 && r < 16 && c >= 0 && c < 16){
            if(map[r][c] != 1){
                return true;
            }
        }
        return false;
    }
    public static void BFS(int[] startEnd, int[][] map, boolean[][] visited){
        int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        int startR = startEnd[0];
        int startC = startEnd[1];
        rQueue.offer(startR);
        cQueue.offer(startC);
        visited[startR][startC] = true;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            for(int i=0; i<4; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(check(nr, nc, map) && !visited[nr][nc]){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }
}