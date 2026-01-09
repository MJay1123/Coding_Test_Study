import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<food.length; i++){
            int useCount = food[i] / 2;
            for(int j=0; j<useCount; j++){
                sb.append(i);
            }
        }
        sb.append("0");
        for(int i=food.length-1; i>0; i--){
            int useCount = food[i] / 2;
            for(int j=0; j<useCount; j++){
                sb.append(i);
            }
        }
        answer = sb.toString();
        return answer;
    }
    
}