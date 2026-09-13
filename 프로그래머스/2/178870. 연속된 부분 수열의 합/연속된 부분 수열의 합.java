import java.util.*;
class Solution {
    static int[] answer;
    static int N;
    public int[] solution(int[] sequence, int k) {
        N = sequence.length;
        answer = new int[2];
        answer[0] = 0;
        answer[1] = N-1;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while(right < N){
            if(sum == k){
                if(check(left, right)){
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
                right++;
                if(right == N){
                    break;
                }
                sum += sequence[right];
            } else if(sum < k){
                right++;
                if(right == N){
                    break;
                }
                sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        return answer;
    }
    public boolean check(int left, int right){
        if(answer[1]-answer[0] > right-left){
            return true;
        }
        if(answer[1]-answer[0] == right-left && answer[0] > left){
            return true;
        }
        return false;
    }
}