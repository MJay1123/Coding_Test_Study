import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> entireMap = new HashMap<>();
        for(int i=0; i<gems.length; i++){
            entireMap.put(gems[i], entireMap.getOrDefault(gems[i], 0) + 1);
        }
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;
        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        add(map, gems[0]);
        while(true){
            if(map.size() == entireMap.size()){
                if(right - left < answer[1] - answer[0]){
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                if(map.get(gems[left]) == 1){
                    right++;
                    if(right == gems.length){
                        break;
                    }
                    add(map, gems[right]);
                } else {
                    remove(map, gems[left]);
                    left++;
                }
            } else {
                right++;
                if(right == gems.length){
                    break;
                }
                add(map, gems[right]);
            }
        }
        return answer;
    }
    public void add(HashMap<String, Integer> map, String gem){
        map.put(gem, map.getOrDefault(gem, 0) + 1);
    }
    public void remove(HashMap<String, Integer> map, String gem){
        map.put(gem, map.get(gem) - 1);
        if(map.get(gem) == 0){
            map.remove(gem);
        }
    }
}