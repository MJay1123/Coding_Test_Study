import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String number = "" + n;
        
        for(int i=0; i<number.length(); i++){
            answer += (number.charAt(i)-48);
        }
        return answer;
    }
}