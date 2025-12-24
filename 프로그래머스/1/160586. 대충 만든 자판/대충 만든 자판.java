import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> hm = new HashMap<>();
        for(int j=0; j<targets.length; j++){ // targets들을 반환
            for(int i=0; i<targets[j].length(); i++){
                String targetStr = Character.toString(targets[j].charAt(i)); // targets의 문자들 반환
                hm.put(targetStr, getMin(getNum(keymap, targetStr))); // 최소 횟수 반환
            }
        }
        for(int j=0; j<targets.length; j++){
            for(int i=0; i<targets[j].length(); i++){
                if(hm.get(Character.toString(targets[j].charAt(i))) < 0){ // -1 값 반환 시
                    answer[j] = -1; // -1 값 반환
                    break;
                }
                answer[j] += hm.get(Character.toString(targets[j].charAt(i)));
            }
        }
        return answer;
    }
    
    public int[] getNum(String[] keymap, String targetStr){ // 각 keymap에서의 최소 index 반환
        int[] numberArray = new int[keymap.length];
        for(int i=0; i<keymap.length; i++){
            numberArray[i] = keymap[i].indexOf(targetStr);
        }
        return numberArray;
    }
    
    public int getMin(int[] numberArray){
        int a = 300; // Math.min을 적용하기 위해서 큰 값 넣고 보기 ㅋ
        for(int i=0; i<numberArray.length; i++){
            if(numberArray[i] >= 0){ // 없을 때 반환하는 -1을 제외
                a = Math.min(a, numberArray[i]); // 최솟값 반환
            }
        }
        if(a == 300){
            a = -100; // 아예 없으면 음수 반환
        }
        return a+1;
    }
}