import java.util.*;
class Solution {
    static int posNumber = 0;
    static int videoLengthNumber = 0;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int opStartNumber = timeToNumber(op_start);
        int opEndNumber = timeToNumber(op_end);
        posNumber = timeToNumber(pos);
        videoLengthNumber = timeToNumber(video_len);
        if(posNumber >= opStartNumber && posNumber <= opEndNumber){
            posNumber = opEndNumber;
        }
        for(String command : commands){
            moveTime(command);
            if(posNumber >= opStartNumber && posNumber <= opEndNumber){
                posNumber = opEndNumber;
            }
        }
        String answer = numberToTime(posNumber);
        return answer;
    }
    
    public int timeToNumber(String str){
        String[] arr = str.split(":");
        int minute = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        return minute * 60 + second;
    }
    
    public String numberToTime(int number){
        int minute = number / 60;
        int second = number % 60;
        String result = String.format("%02d:%02d", minute, second);
        return result;
    }
    
    public void moveTime(String command){
        if(command.equals("prev")){
            posNumber -= 10;
            if(posNumber < 0){
                posNumber = 0;
            }
        }
        if(command.equals("next")){
            posNumber += 10;
            if(posNumber > videoLengthNumber){
                posNumber = videoLengthNumber;
            }
        }
    }
}