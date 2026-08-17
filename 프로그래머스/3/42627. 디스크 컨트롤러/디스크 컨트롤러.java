import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Work> jobsQueue = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work w1, Work w2){
                return w1.requestTime - w2.requestTime;
            }
        });
        PriorityQueue<Work> waitingQueue = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work w1, Work w2){
                if(w1.processTime != w2.processTime){
                    return w1.processTime - w2.processTime;
                }
                if(w1.requestTime != w2.requestTime){
                    return w1.requestTime - w2.requestTime;
                }
                return w1.number - w2.number;
            }
        });
        for(int i=0; i<jobs.length; i++){
            jobsQueue.offer(new Work(i, jobs[i][0], jobs[i][1]));
        }
        int currentTime = 0;
        int totalTime = 0;
        Work work = null;

        while(true){
            if(waitingQueue.isEmpty() && jobsQueue.isEmpty()){
                break;
            }
            if(waitingQueue.isEmpty()){
                if(!jobsQueue.isEmpty() && currentTime <= jobsQueue.peek().requestTime){
                    currentTime = jobsQueue.peek().requestTime;
                }
            }
            while(!jobsQueue.isEmpty() && jobsQueue.peek().requestTime <= currentTime){
                waitingQueue.offer(jobsQueue.poll());
            }
            work = waitingQueue.poll();
            currentTime += work.processTime;
            totalTime += (currentTime - work.requestTime);
        }
        int answer = totalTime / jobs.length;
        return answer;
    }
    class Work {
        int number;
        int requestTime;
        int processTime;
        public Work(int number, int requestTime, int processTime){
            this.number = number;
            this.requestTime = requestTime;
            this.processTime = processTime;
        }
        
        @Override
        public String toString(){
            return "Work[num : " + number + ", r : " + requestTime + ", p : " + processTime + "]";
        }
    }
}