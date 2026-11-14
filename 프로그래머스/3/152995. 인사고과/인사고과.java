import java.util.*;
class Solution {
    class Employee {
        int[] score;
        int scoreSum;
        boolean isWanho;
        public Employee(int[] score, boolean isWanho){
            this.score = score;
            this.scoreSum = score[0] + score[1];
            this.isWanho = isWanho;
        }
        @Override
        public String toString(){
            return Arrays.toString(score) + " " + scoreSum + " " + isWanho;
        }
    }
    public int solution(int[][] scores) {
        int N = scores.length;
        PriorityQueue<Employee> pq = new PriorityQueue<>(
            new Comparator<Employee>(){
                @Override
                public int compare(Employee e1, Employee e2){
                    if(e1.score[0] != e2.score[0]){
                        return e2.score[0] - e1.score[0];
                    }
                    return e1.score[1] - e2.score[1];
                }
            }
        );
        Employee wanho = new Employee(scores[0], true);
        pq.offer(wanho);
        for(int i=1; i<scores.length; i++){
            pq.offer(new Employee(scores[i], false));
        }
        int[] maxScore = new int[2];
        maxScore[0] = pq.peek().score[0];
        maxScore[1] = pq.peek().score[1];
        int sequence = 1;
        int rank = 1;
        while(!pq.isEmpty()){
            Employee emp = pq.poll();
            if(emp.score[0] > wanho.score[0] && emp.score[1] > wanho.score[1]){
                return -1;
            }
            if(emp.score[0] < maxScore[0] && emp.score[1] < maxScore[1]){
                continue;
            } else if(emp.score[0] == maxScore[0] && emp.score[1] > maxScore[1]){
                maxScore[1] = emp.score[1];
            } else if(emp.score[0] < maxScore[0] && emp.score[1] > maxScore[1]){
                maxScore[0] = emp.score[0];
                maxScore[1] = emp.score[1];
            }
            if(emp.scoreSum > wanho.scoreSum){
                rank++;
            }
        }
        return rank;
    }
}