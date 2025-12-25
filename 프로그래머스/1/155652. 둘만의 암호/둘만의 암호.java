import java.util.Arrays;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] isSkip = new boolean[26];
        for(int i=0; i<skip.length(); i++){
            isSkip[skip.charAt(i) - 'a'] = true;
        }
        for(int i=0; i<s.length(); i++){
            int alphabetIndex = s.charAt(i) - 'a';
            int move = 0;
            while(move < index){
                if(isSkip[alphabetIndex]){
                    alphabetIndex = (alphabetIndex + 1) % 26;
                } else {
                    alphabetIndex = (alphabetIndex + 1) % 26;
                    move++;
                }
            }
            while(isSkip[alphabetIndex]){
                alphabetIndex = (alphabetIndex + 1) % 26;
            }
            answer += (char)('a' + alphabetIndex);
        }
        return answer;
    }
}