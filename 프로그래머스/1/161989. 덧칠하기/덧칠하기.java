import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        int current = 0;
        while(current <= n && index < section.length){
            int nextPaint = section[index];
            index++;
            if(current <= nextPaint){
                current = nextPaint;
                current += m;
                answer++;
            }
        }
        return answer;
    }
}