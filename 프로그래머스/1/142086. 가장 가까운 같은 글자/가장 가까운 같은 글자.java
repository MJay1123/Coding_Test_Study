import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] arr = new int[26];
        for(int i=0; i<26; i++){
            arr[i] = -1;
        }
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(arr[index] == -1){
                answer[i] = -1;
            } else {
                answer[i] = i - arr[index];
            } 
            arr[index] = i;
        }
        return answer;
    }
}