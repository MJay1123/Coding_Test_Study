import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        long count = 0;
        while(true){
            if(pq.size() <= 1 && pq.peek() < K){
                return -1;
            }
            if(pq.peek() >= K){
                break;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.offer(food1 + (food2 * 2));
            count++;
        }
        answer = (int)count;
        return answer;
    }
}