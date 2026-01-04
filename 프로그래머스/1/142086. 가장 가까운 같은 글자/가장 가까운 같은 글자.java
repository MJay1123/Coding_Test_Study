class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            answer[i] = -1;
        }
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<i; j++){
                if(s.charAt(j) == s.charAt(i)){
                    answer[i] = i-j;
                }
            }
        }
        return answer;
    }
}