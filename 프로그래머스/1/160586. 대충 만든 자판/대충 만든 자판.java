import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] arr = new int['Z'-'A'+1];
        Arrays.fill(arr, 200);
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                int index = keymap[i].charAt(j) - 'A';
                arr[index] = Math.min(arr[index], j+1);
            }
        }
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                int index = targets[i].charAt(j) - 'A';
                if(arr[index] <= 100){
                    answer[i] += arr[index];
                } else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}