import java.util.*;
class Solution {
    static long result;
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long number = numbers[i];
            String bit = Long.toString(number, 2);
            result = 0L;
            changeBit(bit);
            if(result == 0L){
                answer[i] = number + (number+1)/2L;
            } else {
                answer[i] = result;
            }
        }
        return answer;
    }
    
    public void changeBit(String bit){
        if(bit.charAt(bit.length()-1) == '0'){
            String newBit = bit.substring(0, bit.length()-1) + 1;
            result = Long.parseLong(newBit, 2);
            return;
        } else {
            for(int i=bit.length()-2; i>=0; i--){
                if(bit.charAt(i) == '0'){
                    String newBit = bit.substring(0, i) + 10 + bit.substring(i+2);
                    result = Long.parseLong(newBit, 2);
                    return;
                }
            }
        }
    }
}