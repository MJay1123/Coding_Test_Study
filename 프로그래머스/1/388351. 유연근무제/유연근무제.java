import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0; i<schedules.length; i++){
            if(check(schedules[i], timelogs[i], startday)){
                answer++;
            }
        }
        return answer;
    }
    
    public static int changeTime(int time){
        int hour = time / 100;
        int minute = time % 100;
        int sum = hour*60 + minute;
        return sum;
    }
    
    public static boolean check(int time, int[] timelog, int startday){
        int needTime = changeTime(time) + 10;               // 출근해야 하는 시각
        int count = 0;
        for(int i=0; i<7; i++){
            int commuteTime = changeTime(timelog[i]);
            if(startday == 6 || startday == 7){
                startday++;
                if(startday > 7){
                    startday -= 7;
                }
                continue;
            }
            if(commuteTime > needTime){
                return false;
            }
            startday++;
            if(startday > 7){
                startday -= 7;
            }
        }
        return true;
    }
}