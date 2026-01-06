import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> top = new PriorityQueue<>();
        int index = 0;
        while(top.size() < k){
            if(index == score.length){
                break;
            }
            top.offer(score[index]);
            answer[index] = top.peek();
            index++;
        }
        while(index < score.length){
            if(score[index] > top.peek()){
                top.poll();
                top.offer(score[index]);
            }
            answer[index] = top.peek();
            index++;
        }
        return answer;
    }
}