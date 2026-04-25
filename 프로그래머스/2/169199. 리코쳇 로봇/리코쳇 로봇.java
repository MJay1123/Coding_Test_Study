import java.util.*;
class Solution {
    static int R, C;
    static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
    static char[][] map;
    static int[][] dp;
    static int GR, GC, RR, RC;
    public int solution(String[] board) {
        R = board.length+2;
        C = board[0].length()+2;
        map = new char[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(r == 0 || r == R-1 || c == 0 || c == C-1){
                    map[r][c] = 'D';
                } else {
                    map[r][c] = board[r-1].charAt(c-1);
                }
                if(map[r][c] == 'G'){
                    GR = r;
                    GC = c;
                } else if(map[r][c] == 'R'){
                    RR = r;
                    RC = c;
                }
            }
        }
        int answer = 0;
        dp = new int[R][C];
        for(int r=0; r<R; r++){
            Arrays.fill(dp[r], 10000);
        }
        getDP(RR, RC);
        answer = dp[GR][GC] == 10000 ? -1 : dp[GR][GC];
        return answer;
    }
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    public static void getDP(int startR, int startC){
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();
        dp[startR][startC] = 0;
        rQueue.offer(startR);
        cQueue.offer(startC);
        distQueue.offer(0);
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            int dist = distQueue.poll();
            for(int i=0; i<4; i++){
                int d=1;
                while(true){
                    int nr = r + around[i][0] * d;
                    int nc = c + around[i][1] * d;
                    if(map[nr][nc] == 'D'){
                        break;
                    }
                    d++;
                }
                int nr = r + around[i][0] * (d-1);
                int nc = c + around[i][1] * (d-1);
                if(dp[nr][nc] > dist + 1){
                    dp[nr][nc] = dist + 1;
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    distQueue.offer(dp[nr][nc]);
                }
            }
        }
    }
}