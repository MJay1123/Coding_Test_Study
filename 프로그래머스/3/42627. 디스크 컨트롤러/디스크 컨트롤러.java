import java.util.*;
class Solution {
    static class Process {
        int number;
        int request;
        int length;
        Integer start;
        public Process(int number, int request, int length){
            this.number = number;
            this.request = request;
            this.length = length;
        }
    }
    static Process processing;
    public int solution(int[][] jobs) {
        PriorityQueue<Process> waitingQueue = new PriorityQueue<>(new Comparator<Process>(){
            @Override
            public int compare(Process p1, Process p2){
                return p1.request - p2.request;
            }
        });
        for(int i=0; i<jobs.length; i++){
            int s = jobs[i][0];
            int l = jobs[i][1];
            waitingQueue.offer(new Process(i, s, l));
        }
        int answer = 0;
        PriorityQueue<Process> dc = new PriorityQueue<>(new Comparator<Process>(){
            @Override
            public int compare(Process p1, Process p2){
                if(p1.length != p2.length){
                    return p1.length - p2.length;
                }
                if(p1.request != p2.request){
                    return p1.request - p2.request;
                }
                return p1.number - p2.number;
            }
            
        });
        int time = 0;
        while(true){
            if(waitingQueue.isEmpty() && dc.isEmpty()){
                break;
            }
            while(!waitingQueue.isEmpty() && waitingQueue.peek().request <= time){
                dc.offer(waitingQueue.poll());
            }
            if(!dc.isEmpty()){
                processing = dc.poll();
                time += processing.length;
                answer += time - processing.request;
            } else {
                time++;
            }
        }
        answer /= jobs.length;
        return answer;
    }
}