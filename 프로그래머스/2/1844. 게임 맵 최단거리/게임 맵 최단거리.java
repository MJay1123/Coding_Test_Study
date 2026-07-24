import java.util.*;

class Solution {
    static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] VISITED;
    static int[][] MAP;
    static int R, C;
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        MAP = new int[R][C];
        VISITED = new boolean[R][C];
        BFS(0, 0, maps);
        int answer = MAP[R-1][C-1] > 0 ? MAP[R-1][C-1] + 1 : -1;
        return answer;
    }
    
    public static void BFS(int startR, int startC, int[][] maps) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        rQueue.offer(startR);
        cQueue.offer(startC);
        VISITED[startR][startC] = true;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            if(r == R-1 && c == C-1){
                return;
            }
            for(int i=0; i<4; i++){
                int nr = r + around[i][0];
                int nc = c + around[i][1];
                if(checkRange(nr, nc) && !VISITED[nr][nc] && maps[nr][nc] == 1){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    VISITED[nr][nc] = true;
                    MAP[nr][nc] = MAP[r][c] + 1;
                }
            }
        }
    }
    
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}