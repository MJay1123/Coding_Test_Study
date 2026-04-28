import java.util.*;
class Solution {
    static int answer;
    static int[][] dp;
    public int solution(int[][] info, int n, int m) {
        dp = new int[info.length+1][m+1];
        for(int i=0; i<=info.length; i++){
            Arrays.fill(dp[i], 1000);
        }
        dp[0][0] = 0;
        for(int i=0; i<info.length; i++){
            for(int b=0; b<m; b++){
                if(dp[i][b] != 1000){
                    dp[i+1][b] = Math.min(dp[i+1][b], dp[i][b] + info[i][0]);
                    if(b+info[i][1] < m){
                        dp[i+1][b+info[i][1]] = Math.min(dp[i+1][b+info[i][1]], dp[i][b]);
                    }
                }
            }
        }
        answer = 1000;
        for(int b=0; b<m; b++){
            answer = Math.min(answer, dp[info.length][b]);
        }
        if(answer >= n){
            answer = -1;
        }
        return answer;
    }
}