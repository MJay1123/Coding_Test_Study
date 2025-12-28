import java.util.*;
class Solution {
    static int answer = 0;
    static int[][] move = {{-1,1},{-1,0},{-1,-1}};
    public int solution(int n) {
        boolean[][] chessBoard = new boolean[n][n];
        boolean[] usedColumn = new boolean[n];
        placeInRow(chessBoard, 0);
        return answer;
    }
    public void placeInRow(boolean[][] chessBoard, int r){
        int n = chessBoard.length;
        if(r == n){
            answer++;
            return;
        }
        for(int c=0; c<n; c++){
            if(checkPreviousRows(r, c, chessBoard)){
                chessBoard[r][c] = true;
                placeInRow(chessBoard, r+1);
                chessBoard[r][c] = false;
            }
        }
    }
    public boolean checkPreviousRows(int r, int c, boolean[][] chessBoard){
        int n = chessBoard.length;
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                int nr = r + move[i][0] * j;
                int nc = c + move[i][1] * j;
                if(checkRange(nr, nc, n)){
                    if(chessBoard[nr][nc]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean checkRange(int r, int c, int n){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}