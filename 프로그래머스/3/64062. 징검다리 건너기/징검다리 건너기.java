import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 0;
        int high = 200000001;
        while(low < high){
            int middle = (low + high) / 2;
            if(check(middle, stones, k)){
                answer = Math.max(answer, middle);
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return answer;
    }
    public boolean check(int people, int[] stones, int k){
        int[] arr = new int[stones.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = (stones[i] - people + 1 <= 0) ? 0 : stones[i] - people + 1;
        }
        int maxLength = 1;
        int length = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }
        maxLength = Math.max(maxLength, length);
        if(maxLength > k){
            return false;
        }
        return true;   
    }
}