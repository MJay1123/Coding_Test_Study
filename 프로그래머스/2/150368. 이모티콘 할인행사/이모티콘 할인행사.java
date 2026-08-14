import java.util.*;
class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        combination(users, emoticons, 0, discounts);
        return answer;
    }
    
    public void combination(int[][] users, int[] emoticons, int depth, int[] discounts){
        if(depth == emoticons.length){
            int[] result = calculate(users, emoticons, discounts);
            if(result[0] > answer[0]){
                answer[0] = result[0];
                answer[1] = result[1];
            } else if(result[0] == answer[0] && result[1] > answer[1]){
                answer[1] = result[1];
            }
            return;
        }
        for(int rate=10; rate<=40; rate+=10){
            discounts[depth] = rate;
            combination(users, emoticons, depth+1, discounts);
        }
    }
    public int[] calculate(int[][] users, int[] emoticons, int[] discounts){
        int plusUsers = 0;
        int totalCost = 0;
        for(int i=0; i<users.length; i++){
            int cost = 0;
            for(int j=0; j<discounts.length; j++){
                if(users[i][0] <= discounts[j]){
                    cost += emoticons[j] * (100-discounts[j]) / 100;
                }
            }
            if(users[i][1] <= cost){
                plusUsers++;
            } else {
                totalCost += cost;
            }
        }
        int[] result = new int[2];
        result[0] = plusUsers;
        result[1] = totalCost;
        return result;
    }
}