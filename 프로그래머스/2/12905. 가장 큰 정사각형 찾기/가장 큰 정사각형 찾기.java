import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int rows = board.length;
        int columns = board[0].length;
        int[][] dp = new int[rows][columns];
        for(int r=0; r<rows; r++){
            if(board[r][0] == 1){
                dp[r][0] = 1;
                answer = 1;
            }
        }
        for(int c=0; c<columns; c++){
            if(board[0][c] == 1){
                dp[0][c] = 1;
            }
        }
        for(int r=1; r<rows; r++){
            for(int c=1; c<columns; c++){
                if(board[r][c] == 1){
                    dp[r][c] = getMinimum(dp[r-1][c-1], dp[r-1][c], dp[r][c-1]) + 1;
                    answer = Math.max(answer, dp[r][c]*dp[r][c]);
                }
            }
        }
        return answer;
    }
    public int getMinimum(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}