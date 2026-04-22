import java.util.*;
class Solution {
    static boolean[] spoiler_range;
    static class Word {
        String str;
        int start;
        int end;
        public Word(String str, int start, int end){
            this.str = str;
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String message, int[][] spoiler_ranges) {
        spoiler_range = new boolean[message.length()];
        for(int i=0; i<spoiler_ranges.length; i++){
            int[] range = spoiler_ranges[i];
            for(int j=range[0]; j<=range[1]; j++){
                spoiler_range[j] = true;
            }
        }
        List<Word> wordList = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();
        int start = 0;
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i) == ' '){
                int end = i-1;
                Word w = new Word(message.substring(start, i), start, end);
                if(isSpoiler(w)){
                    wordList.add(w);
                } else {
                    wordSet.add(w.str);
                }
                start = i + 1;
            }
        }
        Word w = new Word(message.substring(start, message.length()), start, message.length()-1);
        if(isSpoiler(w)){
            wordList.add(w);
        } else {
            wordSet.add(w.str);
        }
        int answer = 0;
        int wordIndex = 0;
        int rangeIndex = 0;
        for(Word word : wordList){
            if(!wordSet.contains(word.str)){
                answer++;
                wordSet.add(word.str);
            }
        }
        return answer;
    }
    public static boolean isSpoiler(Word w){
        for(int i=w.start; i<=w.end; i++){
            if(spoiler_range[i]){
                return true;
            }
        }
        return false;
    }
}