import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int start = 0;
        int end = 0;
        while(true){
            if(start == s.length()){
                break;
            }
            end = cut(s, start);
            answer++;
            start = end + 1;
        }
        return answer;
    }
    
    public int cut(String s, int start){
        char ch = s.charAt(start);
        int count1 = 1;
        int count2 = 0;
        for(int i=start+1; i<s.length(); i++){
            if(s.charAt(i) == ch){
                count1++;
            } else {
                count2++;
            }
            if(count1 == count2){
                return i;
            }
        }
        return s.length()-1;
    }
}
