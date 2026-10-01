import java.util.*;
class Solution {
    static int S;
    static class Signal {
        int color;
        int time;
        public Signal(int color, int time){
            this.color = color;
            this.time = time;
        }
        public void timePass(int[] signalTime){
            if(time == 0){
                color = (color + 1) % 3;
                time = signalTime[color];
                if(color == 1){
                    yellowCount++;
                } else if(color == 2){
                    yellowCount--;
                }
            }
            time--;
        }
    }
    static int yellowCount = 0;
    public int solution(int[][] signals) {
        S = signals.length;
        Signal[] signalsArray = new Signal[S];
        int maxLength = 1;
        for(int i=0; i<S; i++){
            signalsArray[i] = new Signal(0, signals[i][0]);
        }
        int answer = -1;
        for(int time=1; time<=Math.pow(20, S); time++){
            for(int i=0; i<S; i++){
                signalsArray[i].timePass(signals[i]);
            }
            if(yellowCount == S){
                answer = time;
                break;
            }
        }
        return answer;
    }
}