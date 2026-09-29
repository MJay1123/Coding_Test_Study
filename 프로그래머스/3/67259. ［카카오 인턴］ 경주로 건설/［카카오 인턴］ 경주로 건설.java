import java.util.*;
class Solution {
    int R, C;
    int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
    int answer = 25 * 25 * 600;
    int[][][] map;
    public int solution(int[][] board) {
        R = board.length;
        C = board[0].length;
        map = new int[R][C][4];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                Arrays.fill(map[r][c], 25 * 25 * 600);
            }
        }
        Arrays.fill(map[0][0], 0);
        dijkstra(0, 0, -1, 0, board);
        for(int i=0; i<4; i++){
            answer = Math.min(answer, map[R-1][C-1][i]);
        }
        return answer;
    }
    boolean checkRange(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    public void dijkstra(int r, int c, int direction, int cost, int[][] board){
        for(int i=0; i<4; i++){
            int nr = r + around[i][0];
            int nc = c + around[i][1];
            if(checkRange(nr, nc) && board[nr][nc] == 0){
                int newCost = cost + 100;
                if(direction != -1 && i != direction){
                    newCost += 500;
                }
                if(map[nr][nc][i] == 0 || map[nr][nc][i] >= newCost){
                    map[nr][nc][i] = newCost;
                    dijkstra(nr, nc, i, newCost, board);
                }
            }
        }
    }
}
