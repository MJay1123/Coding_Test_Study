import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] counts = new int[1001];
        for(int i=0; i<weights.length; i++){
            int weight = weights[i];
            counts[weight]++;
        }
        for(int w1=100; w1<=1000; w1++){
            if(counts[w1] > 0){
                answer += 1L * counts[w1] * (counts[w1] - 1) / 2;
                for(int w2=w1+1; w2<=1000; w2++){
                    if(counts[w2] > 0){
                        if(compare(w1, w2)){
                            answer += 1L * counts[w1] * counts[w2];
                        }
                    }
                }
            }
        }
        return answer;
    }
    public boolean compare(int w1, int w2){ // w1 < w2
        if(w1 == w2){
            return true;
        }
        if(w1 * 2 == w2){
            return true;
        }
        if(w1 * 3 == w2 * 2){
            return true;
        }
        if(w1 * 4 == w2 * 3){
            return true;
        }
        return false;
    }
}