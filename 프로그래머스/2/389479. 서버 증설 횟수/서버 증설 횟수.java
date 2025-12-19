import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[][] servers = new int[2][24];
        for(int i=0; i<24; i++){
            int need = players[i] / m - servers[0][i];
            if(need > 0){
                servers[1][i] += need;
                for(int j=i; j<i+k; j++){
                    if(j == 24){
                        break;
                    }
                    servers[0][j] += need;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<24; i++){
            answer += servers[1][i];
        }
        return answer;
    }
}