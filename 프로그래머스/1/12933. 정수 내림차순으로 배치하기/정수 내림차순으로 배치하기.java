import java.util.*;
class Solution {
    public long solution(long n){
        int[] arr = new int[(n+"").length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(n % 10);
            n = n / 10;
        }
        Arrays.sort(arr);
        long answer = 0;
        for(int i=arr.length-1; i>=0; i--){
            answer *= 10;
            answer += arr[i];
        }
        return answer;
    }
}