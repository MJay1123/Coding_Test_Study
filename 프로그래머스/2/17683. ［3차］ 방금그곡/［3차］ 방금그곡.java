import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = null;
        int answerTime = 1000000;
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int time = getTime(info[0], info[1]);
            String title = info[2];
            String str = replaceString(info[3]);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<time; j++){
                sb.append(str.charAt(j % str.length()));
            }
            str = sb.toString();
            String melody = replaceString(m);
            if(str.contains(melody)){
                if(answer == null){
                    answer = title;
                    answerTime = time;
                } else {
                    if(answerTime < time){
                        answer = title;
                        answerTime = time;
                    }
                }
            }
        }
        if(answer == null){
            answer = "(None)";
        }
        return answer;
    }
    public String replaceString(String str){
        String result = str.replaceAll("C#", "c");
        result = result.replaceAll("D#", "d");
        result = result.replaceAll("F#", "f");
        result = result.replaceAll("G#", "g");
        result = result.replaceAll("A#", "a");
        return result;
    }
    public int getTime(String start, String end){
        int sh = Integer.parseInt(start.substring(0,2));
        int sm = Integer.parseInt(start.substring(3,5));
        int eh = Integer.parseInt(end.substring(0,2));
        int em = Integer.parseInt(end.substring(3,5));
        return (60 * eh + em) - (60 * sh + sm);
    }
}