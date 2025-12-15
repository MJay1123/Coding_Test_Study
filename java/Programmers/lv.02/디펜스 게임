준호는 요즘 디펜스 게임에 푹 빠져 있습니다. 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임입니다. 디펜스 게임은 다음과 같은 규칙으로 진행됩니다.

준호는 처음에 병사 n명을 가지고 있습니다.
매 라운드마다 enemy[i]마리의 적이 등장합니다.
남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
예를 들어 남은 병사가 7명이고, 적의 수가 2마리인 경우, 현재 라운드를 막으면 7 - 2 = 5명의 병사가 남습니다.
남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
게임에는 무적권이라는 스킬이 있으며, 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있습니다.
무적권은 최대 k번 사용할 수 있습니다.
준호는 무적권을 적절한 시기에 사용하여 최대한 많은 라운드를 진행하고 싶습니다.

준호가 처음 가지고 있는 병사의 수 n, 사용 가능한 무적권의 횟수 k, 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다.
  준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 1,000,000,000
1 ≤ k ≤ 500,000
1 ≤ enemy의 길이 ≤ 1,000,000
1 ≤ enemy[i] ≤ 1,000,000
enemy[i]에는 i + 1 라운드에서 공격해오는 적의 수가 담겨있습니다.
모든 라운드를 막을 수 있는 경우에는 enemy[i]의 길이를 return 해주세요.
----------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        if(k >= enemy.length){
            return enemy.length;
        }
        
        int sum = 0;
        int kCount = k;
        for(int i=0; i<enemy.length; i++){
            answer++;
            addNumber(list, enemy[i]);
            sum += enemy[i];            // 합이 n을 넘으면
            if(sum > n){
                if(kCount > 0){
                    kCount--;
                    sum -= poll(list);  // 가장 큰 수를 뺀다.(무적권을 사용)
                } else {
                    return i;
                }
            }
        }
        return answer;
    }
    
    // 아래는 priorityQueue<Integer> 구현(큰 수를 우선으로 하는)
    
    public int peek(List<Integer> list){
        return list.get(0);
    }
    
    public int poll(List<Integer> list){
        int num = peek(list);
        removeNumber(list);
        return num;
    }
    
    public void removeNumber(List<Integer> list){
        changeEachOther(list, 0, list.size()-1);
        list.remove(list.size() - 1);
        int parentIndex = 0;
        while(true){
            
            int childIndex1 = parentIndex*2 + 1;
            int childIndex2 = parentIndex*2 + 2;
            if(childIndex1 >= list.size() || childIndex2 >= list.size()){
                return;
            }
            if(list.get(childIndex1) >= list.get(childIndex2)){
                if(list.get(parentIndex) < list.get(childIndex1)){
                    changeEachOther(list, parentIndex, childIndex1);
                    parentIndex = childIndex1;
                } else {
                    return;
                }
            } else {
                if(list.get(parentIndex) < list.get(childIndex2)){
                    changeEachOther(list, parentIndex, childIndex2);
                    parentIndex = childIndex2;
                } else {
                    return;
                }
            }
        }
    }
    
    public void addNumber(List<Integer> list, int num){
        list.add(num);
        int childIndex = list.size() - 1;
        while(true){
            if(childIndex == 0){
                return;
            }
            int parentIndex = (childIndex-1)/2;
            if(list.get(parentIndex) < list.get(childIndex)){
                changeEachOther(list, parentIndex, childIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }
    
    public void changeEachOther(List<Integer> list, int index1, int index2){
        int temp = list.get(index2);
        list.set(index2, list.get(index1));
        list.set(index1, temp);
    }
}
