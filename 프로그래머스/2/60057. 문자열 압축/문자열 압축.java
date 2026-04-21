import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int l=1; l<=s.length() / 2; l++){
            // System.out.println("l : " + l + " : " + compress(s, l));
            answer = Math.min(answer, compress(s, l));
        }
        return answer;
    }
    public int compress(String s, int l){
        int result = s.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<l; i++){
            sb.append("_");
        }
        String str1 = s + sb.toString();
        String str2 = sb.toString() + s;
        for(int i=0; i<s.length(); i+=l){
            boolean same = true;
            for(int j=i; j<i+l; j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    same = false;
                    break;
                }
            }
            if(same){
                count++;
            } else {
                if(count > 0){
                    result = result + (count+1 + "").length() - count * l;
                }
                count = 0;
            }
        }
        if(count > 0){
            result = result + (count+1 + "").length() - count * l;
        }
        return result;
    }
}