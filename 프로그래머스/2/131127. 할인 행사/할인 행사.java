import java.util.*;
class Solution {
    static int[] count;
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0; i<want.length; i++){
            String stuff = want[i];
            int index = i;
            map.put(stuff, index);
        }
        count = new int[number.length];
        int left = 0;
        int right = 9;
        for(int i=left; i<=right; i++){
            String stuff = discount[i];
            change(stuff, 1);
        }
        if(check(number)){
            answer++;
        }
        while(true){
            String stuff = discount[left];
            change(stuff, -1);
            left++;
            right++;
            if(right == discount.length){
                break;
            }
            stuff = discount[right];
            change(stuff, 1);
            if(check(number)){
                answer++;
            }
        }
        return answer;
    }
    public void change(String stuff, int amount){
        Integer index = map.get(stuff);
        if(index != null){
            count[index] += amount;
        }
    }
    public boolean check(int[] number){
        for(int i=0; i<number.length; i++){
            if(number[i] > count[i]){
                return false;
            }
        }
        return true;
    }
}