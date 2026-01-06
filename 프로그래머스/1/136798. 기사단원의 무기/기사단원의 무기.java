import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int damage = numberToDamage(i);
            answer += (damage > limit) ? power : damage;
        }
        return answer;
    }
    
    public static int numberToDamage(int number){
        int result = 0;
        for(int i=1; i<=(int)Math.sqrt(number); i++){
            if(number % i == 0){
                if(number / i == i){
                    result++;
                } else {
                    result += 2;
                }
            }
        }
        return result;
    }
}
    