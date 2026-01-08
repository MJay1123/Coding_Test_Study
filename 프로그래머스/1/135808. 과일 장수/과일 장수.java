import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<score.length; i++){
            pq.offer(score[i]);
        }
        while(pq.size() >= m){
            for(int i=0; i<m-1; i++){
                pq.poll();
            }
            answer += pq.poll() * m;
        }
        return answer;
    }
}