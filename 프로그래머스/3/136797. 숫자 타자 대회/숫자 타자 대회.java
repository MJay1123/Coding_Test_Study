import java.util.*;

class Solution {
    static int[][] numberPad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    static int[][][] dp;
    static String NUMBERS;
    public int solution(String numbers) {
        NUMBERS = numbers;
        dp = new int[10][10][NUMBERS.length()];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Arrays.fill(dp[i][j], 1000000);
            }
        }
        int firstNum = numbers.charAt(0) - '0';
        if(firstNum != 4){
            dp[4][firstNum][0] = getWeight(6, firstNum);
        }
        if(firstNum != 6){
            dp[firstNum][6][0] = getWeight(4, firstNum);
        }
        for(int index=1; index<NUMBERS.length(); index++){
            int nextNum = NUMBERS.charAt(index) - '0';
            for(int l=0; l<10; l++){
                for(int r=0; r<10; r++){
                    if(dp[l][r][index-1] != 1000000){
                        if(l != nextNum){
                            dp[l][nextNum][index] = Math.min(dp[l][nextNum][index], dp[l][r][index-1] + getWeight(r, nextNum));
                        }
                        if(r != nextNum){
                            dp[nextNum][r][index] = Math.min(dp[nextNum][r][index], dp[l][r][index-1] + getWeight(l, nextNum));
                        }
                    }
                }
            }
        }
        int answer = 1000000;
        for(int l=0; l<10; l++){
            for(int r=0; r<10; r++){
                answer = Math.min(dp[l][r][NUMBERS.length()-1], answer);
            }
        }
        return answer;
    }
    
    public int getWeight(int num1, int num2){
        int[] loc1 = numberPad[num1];
        int[] loc2 = numberPad[num2];
        int dr = Math.abs(loc1[0] - loc2[0]);
        int dc = Math.abs(loc1[1] - loc2[1]);
        if(dr + dc == 0){
            return 1;
        } else if(dr + dc == 1){
            return 2;
        } else if(dr + dc == 2){
            if(dr == 0 || dc == 0) {
                return 4;
            } else {
                return 3;
            }
        } else if(dr + dc == 3){
            if(dr == 0 || dc == 0){
                return 6;
            } else {
                return 5;
            }
        } else if(dr + dc == 4){
            if(dr == 1 || dc == 1){
                return 7;
            } else {
                return 6;
            }
        } else {
            return -10000;  // 나오면 안됨
        }
    }
}